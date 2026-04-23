package com.hospital.QuanLyBenhVien.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/login")
    // SỬA DÒNG NÀY: Chuyển từ @RequestParam sang @RequestBody Map
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {

        // Bóc tách dữ liệu từ JSON Web gửi lên
        String username = payload.get("username");
        String password = payload.get("password");

        // (Nếu Web của bạn gửi chữ 'TenDangNhap' thay vì 'username' thì bạn đổi lại nhé)
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Thiếu tên đăng nhập hoặc mật khẩu"));
        }

        String sql = "SELECT tk.TenDangNhap, tk.MaQuyen, tk.MaNV, nv.HoTen AS TenNhanVien " +
                "FROM TaiKhoan tk " +
                "JOIN NhanVienYTe nv ON tk.MaNV = nv.MaNV " +
                "WHERE tk.TenDangNhap = :username AND tk.MatKhau = :password";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        query.unwrap(NativeQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

        List<Map<String, Object>> result = query.getResultList();

        if (result.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("message", "Sai tên đăng nhập hoặc mật khẩu!"));
        }

        Map<String, Object> userInfo = result.get(0);

        String quyen = (String) userInfo.get("MaQuyen");
        if ("BENHNHAN".equalsIgnoreCase(quyen)) {
            return ResponseEntity.status(403).body(Map.of("message", "Bệnh nhân vui lòng ra trang chủ tra cứu!"));
        }

        return ResponseEntity.ok(userInfo);
    }
}