package com.hospital.QuanLyBenhVien.repository;

import com.hospital.QuanLyBenhVien.entity.PhieuDangKyKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhieuDangKyKhamRepository extends JpaRepository<PhieuDangKyKham, String> {
    List<PhieuDangKyKham> findAllByOrderByNgayKhamDescGioKhamAsc();
}