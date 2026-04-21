package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BenhNhan")
@Data
public class BenhNhan {
    @Id
    private String maBN;

    private String hoTen;
    private String cccd;
}