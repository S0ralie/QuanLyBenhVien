package com.hospital.QuanLyBenhVien.controller;

import com.hospital.QuanLyBenhVien.entity.TaiKhoan;
import com.hospital.QuanLyBenhVien.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private TaiKhoanRepository repo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        Optional<TaiKhoan> userOpt = repo.findById(username);

        if (userOpt.isPresent() && userOpt.get().getMatKhau().equals(password)) {
            TaiKhoan user = userOpt.get();
            Map<String, String> response = new HashMap<>();
            response.put("role", user.getMaQuyen());
            response.put("id", user.getMaNV() != null ? user.getMaNV() : user.getMaBN());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Sai tài khoản hoặc mật khẩu");
    }
}