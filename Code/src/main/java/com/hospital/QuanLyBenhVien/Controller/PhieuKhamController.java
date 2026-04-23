package com.hospital.QuanLyBenhVien.Controller;

import com.hospital.QuanLyBenhVien.entity.PhieuDangKyKham;
import com.hospital.QuanLyBenhVien.repository.PhieuDangKyKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/api/phieu-kham")
@CrossOrigin("*")
public class PhieuKhamController {

    @Autowired
    private PhieuDangKyKhamRepository repo;

    @GetMapping
    public List<PhieuDangKyKham> getAll() {
        return repo.findAllByOrderByNgayKhamDescGioKhamAsc();
    }

    @PostMapping("/update-status")
    public ResponseEntity<?> updateStatus(@RequestBody Map<String, String> payload) {
        try {
            // Lấy đúng tên key mà JS gửi lên
            String maPhieu = payload.get("maPhieu");
            String trangThaiMoi = payload.get("trangThai");

            if (maPhieu == null || trangThaiMoi == null) {
                return ResponseEntity.badRequest().body("Thiếu dữ liệu mã phiếu hoặc trạng thái");
            }

            // Dùng JPA tìm phiếu thay vì viết câu SQL dễ sai lỗi chính tả
            PhieuDangKyKham phieu = repo.findById(maPhieu).orElse(null);
            if (phieu != null) {
                phieu.setTrangThai(trangThaiMoi);
                repo.save(phieu); // JPA tự động lưu, không cần @Transactional rườm rà
                return ResponseEntity.ok(Map.of("message", "Cập nhật thành công"));
            }
            return ResponseEntity.status(404).body("Không tìm thấy phiếu");
        } catch (Exception e) {
            // Dòng này sẽ in thẳng lỗi ra màn hình đen IntelliJ để chúng ta bắt tận tay!
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi Server: " + e.getMessage());
        }
    }
}