package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BacSi")
@Data
public class BacSi {
    @Id
    private String maNV;

    private String chuyenMon;
    private String bangCap;
}