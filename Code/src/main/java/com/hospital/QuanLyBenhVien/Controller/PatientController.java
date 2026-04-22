package com.hospital.QuanLyBenhVien.Controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private EntityManager entityManager;

    // lịch sử khám của 1 Bệnh nhân
    @GetMapping("/history/search")
    public ResponseEntity<?> searchHistorySmart(@RequestParam String keyword) {
        String sql = "SELECT pkq.MaPhieuKQ, pkq.NgayKham, pkq.TrieuChung, pkq.ChanDoan, nv.HoTen AS TenBacSi " +
                "FROM PhieuKetQuaKhamBenh pkq " +
                "JOIN HoSoBenhAn hs ON pkq.MaHS = hs.MaHS " +
                "JOIN BenhNhan bn ON hs.MaBN = bn.MaBN " +
                "JOIN NhanVienYTe nv ON pkq.MaNV = nv.MaNV " +
                "WHERE bn.HoTen LIKE :keyword OR bn.CCCD = :exactKeyword " +
                "ORDER BY pkq.NgayKham DESC";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("keyword", "%" + keyword + "%");
        query.setParameter("exactKeyword", keyword);

        query.unwrap(NativeQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return ResponseEntity.ok(query.getResultList());
    }

    @GetMapping("/prescription/{maPhieuKQ}")
    public ResponseEntity<?> getPrescriptionAndBill(@PathVariable String maPhieuKQ) {
        String sql = "SELECT t.TenThuoc, c.SoLuong, t.DonGia, (c.SoLuong * t.DonGia) AS ThanhTien " +
                "FROM DonThuoc d " +
                "JOIN ChiTietDonThuoc c ON d.MaDonThuoc = c.MaDonThuoc " +
                "JOIN Thuoc t ON c.MaThuoc = t.MaThuoc " +
                "WHERE d.MaPhieuKQ = :maPhieuKQ";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("maPhieuKQ", maPhieuKQ);
        query.unwrap(NativeQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

        return ResponseEntity.ok(query.getResultList());
    }
}