package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TaiKhoan")
@Data
public class TaiKhoan {
    @Id
    private String tenDangNhap;

    private String matKhau;
    private String maQuyen;
    private String maNV;
    private String maBN;
}