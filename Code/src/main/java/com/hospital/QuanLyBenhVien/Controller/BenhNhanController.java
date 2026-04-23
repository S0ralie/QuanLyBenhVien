package com.hospital.QuanLyBenhVien.Controller;

import com.hospital.QuanLyBenhVien.entity.BenhNhan;
import com.hospital.QuanLyBenhVien.repository.BenhNhanRepository; // Nhớ tạo interface này nếu chưa có
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benh-nhan")
@CrossOrigin("*")
public class BenhNhanController {

    @Autowired
    private BenhNhanRepository repo;

    // 1. LẤY DANH SÁCH (Để hiển thị lên bảng)
    @GetMapping
    public List<BenhNhan> getAll() {
        return repo.findAll();
    }

    // 2. THÊM MỚI BỆNH NHÂN
    @PostMapping("/add")
    public ResponseEntity<?> addBenhNhan(@RequestBody BenhNhan bn) {
        if (repo.existsById(bn.getMaBN())) {
            return ResponseEntity.badRequest().body("Mã bệnh nhân đã tồn tại!");
        }
        repo.save(bn);
        return ResponseEntity.ok("Thêm mới thành công!");
    }

    // 3. SỬA THÔNG TIN BỆNH NHÂN
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editBenhNhan(@PathVariable String id, @RequestBody BenhNhan bnUpdate) {
        return repo.findById(id).map(bn -> {
            bn.setHoTen(bnUpdate.getHoTen());
            bn.setSDT(bnUpdate.getSDT());
            // Cập nhật thêm các trường khác nếu cần (Ngày sinh, Giới tính...)
            repo.save(bn);
            return ResponseEntity.ok("Cập nhật thành công!");
        }).orElse(ResponseEntity.badRequest().body("Không tìm thấy bệnh nhân"));
    }

    // 4. XÓA BỆNH NHÂN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBenhNhan(@PathVariable String id) {
        try {
            repo.deleteById(id);
            return ResponseEntity.ok("Xóa thành công!");
        } catch (Exception e) {
            // Lỗi này thường xảy ra do Khóa Ngoại (Bệnh nhân đang có phiếu khám thì không được xóa)
            return ResponseEntity.badRequest().body("Không thể xóa vì bệnh nhân đang có hồ sơ hoặc phiếu khám!");
        }
    }
}