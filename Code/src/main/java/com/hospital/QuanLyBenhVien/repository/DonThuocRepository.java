package com.hospital.QuanLyBenhVien.repository;

import com.hospital.QuanLyBenhVien.entity.DonThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonThuocRepository extends JpaRepository<DonThuoc, String> {
    // Để trống thế này là Spring Boot tự hiểu và bao thầu hết các lệnh Thêm/Sửa/Xóa!
}