package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Thuoc")
@Data
public class Thuoc {

    @Id
    private String maThuoc;

    private String tenThuoc;
    private String donVi;

    // Nếu trong SQL Server bảng Thuoc của bạn có thêm cột gì (ví dụ: DonGia, SoLuongTon...)
    // thì bạn khai báo thêm vào đây nhé!
}
