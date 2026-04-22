USE QuanLyBenhVien;
GO

INSERT INTO Khoa (MaKhoa, TenKhoa) VALUES 
('K01', N'Khoa Nội Tổng Quát'),
('K02', N'Khoa Ngoại Chấn Thương'),
('K03', N'Khoa Nhi'),
('K04', N'Khoa Sản Phụ Khoa'),
('K05', N'Khoa Tai Mũi Họng'),
('K06', N'Khoa Răng Hàm Mặt'),
('K07', N'Khoa Tim Mạch');

INSERT INTO Quyen (MaQuyen, TenQuyen) VALUES 
('ADMIN', N'Quản trị hệ thống'),
('BACSI', N'Bác sĩ chuyên khoa'),
('BENHNHAN', N'Bệnh nhân');

INSERT INTO Thuoc (MaThuoc, TenThuoc, DonGia) VALUES 
('T01', N'Paracetamol 500mg', 1500),
('T02', N'Amoxicillin 500mg', 3000),
('T03', N'Panadol Extra', 2500),
('T04', N'Vitamin C 1000mg', 5000),
('T05', N'Augmentin 1g', 15000);

INSERT INTO BenhNhan (MaBN, HoTen, CCCD) VALUES 
('BN001', N'Nguyễn Văn An', '0123456789'),
('BN002', N'Trần Thị Bình', '0123456789'),
('BN003', N'Lê Hoàng Nam', '0123456789'),
('BNOO4', N'Nguyễn Trần Long', '1238023847');

INSERT INTO NhanVienYTe (MaNV, HoTen, MaKhoa) VALUES ('NV01', N'BS. Phạm Thành Long', 'K07');
INSERT INTO BacSi (MaNV, ChuyenMon, BangCap) VALUES ('NV01', N'Nội Tim Mạch', N'Tiến sĩ - Bác sĩ');

INSERT INTO NhanVienYTe (MaNV, HoTen, MaKhoa) VALUES ('NV02', N'BS. Lê Minh Hương', 'K03');
INSERT INTO BacSi (MaNV, ChuyenMon, BangCap) VALUES ('NV02', N'Nhi Khoa', N'Thạc sĩ - Bác sĩ CK I');

INSERT INTO TaiKhoan (TenDangNhap, MatKhau, MaQuyen, MaNV, MaBN) VALUES 
('admin', '123456', 'ADMIN', NULL, NULL),
('bacsi1', '123456', 'BACSI', 'NV01', NULL),
('benhnhan1', '123456', 'BENHNHAN', NULL, 'BN001');

INSERT INTO HoSoBenhAn (MaHS, MaBN) VALUES 
('HS001', 'BN001'),
('HS002', 'BN002');

INSERT INTO PhieuDangKyKham (MaPhieuDK, NgayKham, GioKham, TrangThai, MaBN, MaNV) VALUES 
('DK001', '2026-04-21', '08:00', N'Chờ Khám', 'BN001', 'NV01'),
('DK002', '2026-04-21', '08:30', N'Đã Đến', 'BN002', 'NV01'),
('DK003', '2026-04-21', '09:00', N'Khám Xong', 'BN003', 'NV02');

INSERT INTO PhieuKetQuaKhamBenh (MaPhieuKQ, NgayKham, TrieuChung, ChanDoan, MaHS, MaNV) VALUES 
('KQ001', '2026-04-20', N'Đau ngực, khó thở nhẹ', N'Rối loạn nhịp tim nhẹ', 'HS001', 'NV01');

INSERT INTO DonThuoc (MaDonThuoc, MaPhieuKQ) VALUES ('DT001', 'KQ001');
INSERT INTO ChiTietDonThuoc (MaDonThuoc, MaThuoc, SoLuong) VALUES 
('DT001', 'T01', 10),
('DT001', 'T04', 5);
GO

USE QuanLyBenhVien;
GO

INSERT INTO Khoa (MaKhoa, TenKhoa) VALUES 
('K01', N'Khoa Nội Tổng Quát'),
('K02', N'Khoa Ngoại Chấn Thương'),
('K03', N'Khoa Nhi'),
('K04', N'Khoa Sản Phụ Khoa'),
('K05', N'Khoa Tai Mũi Họng'),
('K06', N'Khoa Răng Hàm Mặt'),
('K07', N'Khoa Tim Mạch');

INSERT INTO Quyen (MaQuyen, TenQuyen) VALUES 
('ADMIN', N'Quản trị hệ thống'),
('BACSI', N'Bác sĩ chuyên khoa'),

INSERT INTO Thuoc (MaThuoc, TenThuoc, DonGia) VALUES 
('T01', N'Paracetamol 500mg', 1500),
('T02', N'Amoxicillin 500mg', 3000),
('T03', N'Panadol Extra', 2500),
('T04', N'Vitamin C 1000mg', 5000),
('T05', N'Augmentin 1g', 15000);

INSERT INTO BenhNhan (MaBN, HoTen, CCCD) VALUES 
('BN001', N'Nguyễn Văn An', '0123456789'),
('BN002', N'Trần Thị Bình', '0123456789'),
('BN003', N'Lê Hoàng Nam', '0123456789'),
('BNOO4', N'Nguyễn Trần Long', '1238023847');

INSERT INTO NhanVienYTe (MaNV, HoTen, MaKhoa) VALUES ('NV01', N'BS. Phạm Thành Long', 'K07');
INSERT INTO BacSi (MaNV, ChuyenMon, BangCap) VALUES ('NV01', N'Nội Tim Mạch', N'Tiến sĩ - Bác sĩ');

INSERT INTO NhanVienYTe (MaNV, HoTen, MaKhoa) VALUES ('NV02', N'BS. Lê Minh Hương', 'K03');
INSERT INTO BacSi (MaNV, ChuyenMon, BangCap) VALUES ('NV02', N'Nhi Khoa', N'Thạc sĩ - Bác sĩ CK I');

INSERT INTO TaiKhoan (TenDangNhap, MatKhau, MaQuyen, MaNV, MaBN) VALUES 
('admin', '123456', 'ADMIN', NULL, NULL),
('bacsi1', '123456', 'BACSI', 'NV01', NULL),

INSERT INTO HoSoBenhAn (MaHS, MaBN) VALUES 
('HS001', 'BN001'),
('HS002', 'BN002');

INSERT INTO PhieuDangKyKham (MaPhieuDK, NgayKham, GioKham, TrangThai, MaBN, MaNV) VALUES 
('DK001', '2026-04-21', '08:00', N'Chờ Khám', 'BN001', 'NV01'),
('DK002', '2026-04-21', '08:30', N'Đã Đến', 'BN002', 'NV01'),
('DK003', '2026-04-21', '09:00', N'Khám Xong', 'BN003', 'NV02');

INSERT INTO PhieuKetQuaKhamBenh (MaPhieuKQ, NgayKham, TrieuChung, ChanDoan, MaHS, MaNV) VALUES 
('KQ001', '2026-04-20', N'Đau ngực, khó thở nhẹ', N'Rối loạn nhịp tim nhẹ', 'HS001', 'NV01');

INSERT INTO DonThuoc (MaDonThuoc, MaPhieuKQ) VALUES ('DT001', 'KQ001');
INSERT INTO ChiTietDonThuoc (MaDonThuoc, MaThuoc, SoLuong) VALUES 
('DT001', 'T01', 10),
('DT001', 'T04', 5);
GO

COMMIT;