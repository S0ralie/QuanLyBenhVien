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
        String id = payload.get("MaPhieuDK");
        String newStatus = payload.get("rangThai");

        PhieuDangKyKham phieu = repo.findById(id).orElse(null);
        if (phieu != null) {
            phieu.setTrangThai(newStatus);
            repo.save(phieu);
            return ResponseEntity.ok("Cập nhật thành công");
        }
        return ResponseEntity.badRequest().body("Không tìm thấy phiếu");
    }
}