package com.hospital.QuanLyBenhVien.repository;

import com.hospital.QuanLyBenhVien.entity.ChiTietDonThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDonThuocRepository extends JpaRepository<ChiTietDonThuoc, Object> {
    // Để trống như thế này là được!
    // Mình dùng Object ở đây để tránh việc phải khai báo khóa chính đôi lằng nhằng cho bạn.
}