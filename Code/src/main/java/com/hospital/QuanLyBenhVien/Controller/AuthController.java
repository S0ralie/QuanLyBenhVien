package com.hospital.QuanLyBenhVien.Controller;

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

        // --- ĐOẠN NÀY LÀ MÁY ĐẾM NÓI THẬT ---
        System.out.println("1. Web gửi xuống Username: [" + username + "]");
        System.out.println("2. Web gửi xuống Password: [" + password + "]");

        Optional<TaiKhoan> userOpt = repo.findById(username);

        if (userOpt.isPresent()) {
            TaiKhoan user = userOpt.get();
            System.out.println("3. TÌM THẤY TÀI KHOẢN TRONG DB!");
            System.out.println("4. Password trong DB đang là: [" + user.getMatKhau() + "]");

            // Dùng .trim() để cắt khoảng trắng
            if (user.getMatKhau().trim().equals(password)) {
                System.out.println("5. MẬT KHẨU KHỚP! CHO PHÉP ĐĂNG NHẬP.");
                Map<String, String> response = new HashMap<>();
                response.put("role", user.getMaQuyen().trim());
                response.put("id", user.getMaNV() != null ? user.getMaNV() : user.getMaBN());
                return ResponseEntity.ok(response);
            } else {
                System.out.println("5. MẬT KHẨU KHÔNG KHỚP!");
            }
        } else {
            System.out.println("3. KHÔNG TÌM THẤY TÀI KHOẢN NÀY TRONG DATABASE!");
        }
        // ------------------------------------

        return ResponseEntity.status(401).body("Sai tài khoản hoặc mật khẩu");
    }
}