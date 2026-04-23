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
public class AuthController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {

        // CÂU LỆNH MỚI: Chỉ kiểm tra tài khoản và lấy tên Nhân viên y tế
        String sql = "SELECT tk.TenDangNhap, tk.MaQuyen, tk.MaNV, nv.HoTen AS TenNhanVien " +
                "FROM TaiKhoan tk " +
                "JOIN NhanVienYTe nv ON tk.MaNV = nv.MaNV " +
                "WHERE tk.TenDangNhap = :username AND tk.MatKhau = :password";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        // Ép kiểu kết quả về dạng Map (Key - Value) để trả về JSON cho Web dễ đọc
        query.unwrap(NativeQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

        List<Map<String, Object>> result = query.getResultList();

        // Kiểm tra nếu List rỗng nghĩa là sai tài khoản hoặc mật khẩu
        if (result.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("message", "Sai tên đăng nhập hoặc mật khẩu!"));
        }

        // Nếu thành công, trả về thông tin của Bác sĩ/Nhân viên
        Map<String, Object> userInfo = result.get(0);

        // BẢO MẬT THÊM: Chặn luôn nếu lỡ còn sót tài khoản Bệnh nhân nào trong DB
        String quyen = (String) userInfo.get("MaQuyen");
        if ("BENHNHAN".equalsIgnoreCase(quyen)) {
            return ResponseEntity.status(403).body(Map.of("message", "Bệnh nhân vui lòng ra trang chủ tra cứu, không dùng cổng đăng nhập này!"));
        }

        return ResponseEntity.ok(userInfo);
    }
}