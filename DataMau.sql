USE [QuanLyBenhVien];
GO

DELETE FROM HoaDonThanhToan;
DELETE FROM ChiTietDonThuoc;
DELETE FROM DonThuoc;
DELETE FROM PhieuKetQuaKhamBenh;
DELETE FROM PhieuDangKyKham;
DELETE FROM TaiKhoan; 
DELETE FROM BacSi;
DELETE FROM NhanVienYTe;
DELETE FROM HoSoBenhAn;
DELETE FROM BenhNhan;
DELETE FROM Thuoc;
DELETE FROM Quyen;
DELETE FROM Khoa;
GO

-- Khoa & Thuốc
INSERT INTO Khoa (MaKhoa, TenKhoa, ViTri, SDT) VALUES 
('K01', N'Khoa Nội', N'Tầng 2 - Tòa A', '0243123456'),
('K02', N'Khoa Ngoại', N'Tầng 3 - Tòa B', '0243654321');

INSERT INTO Thuoc (MaThuoc, TenThuoc, DonVi, DonGia) VALUES 
('T01', N'Paracetamol 500mg', N'Viên', 2000),
('T02', N'Amoxicillin', N'Viên', 5000),
('T03', N'Vitamin C', N'Viên', 1000);

-- Quyền & Bệnh Nhân
INSERT INTO Quyen (MaQuyen, TenQuyen, MoTa) VALUES 
('ADMIN', N'Quản trị viên', N'Toàn quyền hệ thống'),
('BACSI', N'Bác sĩ', N'Khám bệnh và kê đơn'),
('LETAN', N'Lễ tân', N'Tiếp đón bệnh nhân');

INSERT INTO BenhNhan (MaBN, HoTen, CCCD, NgaySinh, GioiTinh, DiaChi, SDT, BHYT) VALUES 
('BN01', N'Nguyễn Văn A', '001200123456', '1995-05-20', N'Nam', N'Hà Nội', '0912345678', 'GD40101'),
('BN02', N'Trần Thị B', '001200654321', '1998-10-15', N'Nữ', N'Hà Nam', '0988888888', 'GD40102');

-- Nhân Viên & Bác Sĩ
INSERT INTO NhanVienYTe (MaNV, HoTen, CCCD, NgaySinh, GioiTinh, SDT, ChucVu, MaKhoa) VALUES 
('NV01', N'Trương Gia Bình', '001090123456', '1975-01-01', N'Nam', '0901112222', N'Trưởng khoa', 'K01'),
('NV02', N'Lê Thanh Hải', '001090654321', '1980-05-05', N'Nam', '0903334444', N'Bác sĩ điều trị', 'K02');

INSERT INTO BacSi (MaNV, ChuyenMon, BangCap, SoChungChiHanhNghe) VALUES 
('NV01', N'Nội tổng quát', N'Tiến sĩ', 'CCHN001'),
('NV02', N'Ngoại khoa', N'Thạc sĩ', 'CCHN002');

-- Tài Khoản & Hồ Sơ Bệnh Án
INSERT INTO TaiKhoan (TenDangNhap, MatKhau, MaQuyen, MaNV) VALUES 
('bacsi1', '123456', 'BACSI', 'NV01'),
('bacsi2', '123456', 'BACSI', 'NV02');

INSERT INTO HoSoBenhAn (MaHS, NgayTao, NhomMau, TienSuBenh, MaBN) VALUES 
('HS01', GETDATE(), 'O', N'Dị ứng hải sản', 'BN01'),
('HS02', GETDATE(), 'A', N'Không có', 'BN02');

-- E. Phiếu Đăng Ký & Phiếu Kết Quả (Nghiệp vụ khám)
INSERT INTO PhieuDangKyKham (MaPhieuDK, NgayKham, GioKham, TrangThai, MaBN, MaNV) VALUES 
('PDK01', GETDATE(), '08:30:00', N'Đã Khám', 'BN01', 'NV01'),
('PDK02', GETDATE(), '09:15:00', N'Chờ Khám', 'BN02', 'NV01');

INSERT INTO PhieuKetQuaKhamBenh (MaPhieuKQ, NgayKham, TrieuChung, ChanDoan, MaHS, MaNV) VALUES 
('PKQ01', GETDATE(), N'Sốt, ho khan', N'Viêm họng cấp', 'HS01', 'NV01');

-- Đơn Thuốc & Chi Tiết
INSERT INTO DonThuoc (MaDonThuoc, NgayKeDon, MaPhieuKQ) VALUES 
('DT01', GETDATE(), 'PKQ01');

INSERT INTO ChiTietDonThuoc (MaDonThuoc, MaThuoc, SoLuong, LieuLuong) VALUES 
('DT01', 'T01', 10, N'Ngày uống 2 lần, mỗi lần 1 viên'),
('DT01', 'T02', 14, N'Ngày uống 2 lần sau ăn');

-- Hóa Đơn
INSERT INTO HoaDonThanhToan (MaHD, TongTien, MucGiamBHYT, TrangThai, MaBN) VALUES 
('HD01', 150000, 0.8, N'Đã Thanh Toán', 'BN01');
GO

-- KIỂM TRA
SELECT * FROM TaiKhoan;
SELECT * FROM PhieuKetQuaKhamBenh;
SELECT * FROM ChiTietDonThuoc;
