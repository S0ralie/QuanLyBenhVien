package com.hospital.QuanLyBenhVien.Controller;

// Thay đổi chữ 'entity' và 'repository' thành viết hoa/thường cho khớp với thư mục của bạn nhé
import com.hospital.QuanLyBenhVien.entity.ChiTietDonThuoc;
import com.hospital.QuanLyBenhVien.entity.DonThuoc;
import com.hospital.QuanLyBenhVien.entity.Thuoc;
import com.hospital.QuanLyBenhVien.repository.ChiTietDonThuocRepository;
import com.hospital.QuanLyBenhVien.repository.DonThuocRepository;
import com.hospital.QuanLyBenhVien.repository.ThuocRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/don-thuoc")
@CrossOrigin("*")
public class DonThuocController {

    @Autowired
    private DonThuocRepository donThuocRepo;

    @Autowired
    private ChiTietDonThuocRepository chiTietRepo;

    @Autowired
    private ThuocRepository thuocRepo;

    // 1. Lấy danh sách thuốc để bác sĩ chọn trên Web
    @GetMapping("/thuoc")
    public List<Thuoc> getAllThuoc() {
        return thuocRepo.findAll();
    }

    // 2. Lưu đơn thuốc (Dùng Transaction để nếu lỗi sẽ hoàn tác toàn bộ, không bị lưu thiếu)
    @PostMapping("/save")
    @Transactional
    public ResponseEntity<?> saveDonThuoc(@RequestBody Map<String, Object> request) {
        try {
            // Tự động tạo mã đơn thuốc theo thời gian thực (ví dụ: DT1713435432)
            String maDon = "DT" + System.currentTimeMillis();

            // --- BƯỚC 1: LƯU THÔNG TIN ĐƠN THUỐC CHÍNH ---
            DonThuoc don = new DonThuoc();
            don.setMaDonThuoc(maDon);
            don.setNgayKeDon(new Date());
            don.setMaPhieuKQ((String) request.get("maPhieuKham")); // Nối với phiếu khám từ Web gửi lên
            donThuocRepo.save(don);

            // --- BƯỚC 2: LƯU DANH SÁCH CHI TIẾT ĐƠN THUỐC ---
            // Ép kiểu dữ liệu danh sách thuốc từ Web gửi lên
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> danhSachThuoc = (List<Map<String, Object>>) request.get("thuocList");

            for (Map<String, Object> item : danhSachThuoc) {
                ChiTietDonThuoc ct = new ChiTietDonThuoc();
                ct.setMaDonThuoc(maDon);
                ct.setMaThuoc((String) item.get("maThuoc"));

                // Ép kiểu số lượng cẩn thận để không bị lỗi
                ct.setSoLuong(Integer.parseInt(item.get("soLuong").toString()));
                ct.setLieuLuong((String) item.get("lieuLuong"));

                chiTietRepo.save(ct);
            }

            return ResponseEntity.ok("Kê đơn thuốc thành công! Mã đơn: " + maDon);

        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra màn hình đen Console để dễ tìm
            return ResponseEntity.badRequest().body("Lỗi kê đơn: " + e.getMessage());
        }
    }
}