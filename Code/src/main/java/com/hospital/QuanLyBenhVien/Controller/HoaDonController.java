package com.hospital.QuanLyBenhVien.Controller;

// ĐÂY CHÍNH LÀ CÁC THƯ VIỆN BỊ THIẾU LÀM CODE ĐỎ:
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// (Lưu ý: Bạn vẫn cần Alt+Enter 2 dòng dưới này để nó tự tìm đúng đường dẫn file của bạn nhé)
import com.hospital.QuanLyBenhVien.repository.HoaDonRepository;
import com.hospital.QuanLyBenhVien.entity.HoaDonThanhToan;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonRepository repo;

    @GetMapping
    public List<HoaDonThanhToan> getAll() {
        return repo.findAll();
    }
}