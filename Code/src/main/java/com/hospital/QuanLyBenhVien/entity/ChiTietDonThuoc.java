package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

// Class phụ để khai báo khóa chính đôi
class ChiTietDonThuocId implements Serializable {
    private String maDonThuoc;
    private String maThuoc;
}

@Entity
@Table(name = "ChiTietDonThuoc")
@IdClass(ChiTietDonThuocId.class)
@Data
public class ChiTietDonThuoc {
    @Id
    private String maDonThuoc;
    @Id
    private String maThuoc;

    private Integer soLuong;
    private String lieuLuong;
}