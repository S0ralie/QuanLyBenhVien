package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "PhieuDangKyKham")
@Data
public class PhieuDangKyKham {
    @Id
    private String maPhieuDK;

    private LocalDate ngayKham;
    private LocalTime gioKham;
    private String trangThai;
    private String maBN;
    private String maNV;
}