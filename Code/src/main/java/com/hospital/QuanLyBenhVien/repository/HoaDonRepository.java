package com.hospital.QuanLyBenhVien.repository; // (Lưu ý: Tên package này có thể khác một chút tùy máy bạn)


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<com.hospital.QuanLyBenhVien.entity.HoaDonThanhToan, String> {
}