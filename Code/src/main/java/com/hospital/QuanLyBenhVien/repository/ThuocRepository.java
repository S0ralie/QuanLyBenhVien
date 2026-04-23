package com.hospital.QuanLyBenhVien.repository;

import com.hospital.QuanLyBenhVien.entity.Thuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuocRepository extends JpaRepository<Thuoc, String> {
    // Kế thừa JpaRepository là nó tự động có chức năng findAll()
}
