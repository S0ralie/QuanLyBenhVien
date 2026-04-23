package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DonThuoc")
@Data
public class DonThuoc {
    @Id
    private String maDonThuoc;
    private java.util.Date ngayKeDon;
    private String maPhieuKQ;
}