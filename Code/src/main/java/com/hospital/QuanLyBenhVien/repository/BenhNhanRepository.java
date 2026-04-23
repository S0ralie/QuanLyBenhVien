package com.hospital.QuanLyBenhVien.repository;

import com.hospital.QuanLyBenhVien.entity.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenhNhanRepository extends JpaRepository<BenhNhan, String> {
    // Để trống thế này là đủ, JpaRepository đã bao thầu hết các lệnh Thêm/Sửa/Xóa rồi!
}