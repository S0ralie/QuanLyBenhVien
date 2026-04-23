package com.hospital.QuanLyBenhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "HoaDonThanhToan")
public class HoaDonThanhToan {

    @Id
    @Column(name = "MaHD")
    private String maHD;

    @Column(name = "NgayLap")
    private Date ngayLap;

    @Column(name = "TongTien")
    private Double tongTien;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "MaBN")
    private String maBN;

    // --- GETTER & SETTER ---
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public Date getNgayLap() { return ngayLap; }
    public void setNgayLap(Date ngayLap) { this.ngayLap = ngayLap; }

    public Double getTongTien() { return tongTien; }
    public void setTongTien(Double tongTien) { this.tongTien = tongTien; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getMaBN() { return maBN; }
    public void setMaBN(String maBN) { this.maBN = maBN; }
}