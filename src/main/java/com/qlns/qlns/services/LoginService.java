package com.qlns.qlns.services;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Xác thực người dùng
    public NhanVien authenticate(String username, String password) {
        // Kiểm tra người dùng có tồn tại trong cơ sở dữ liệu hay không
        NhanVien nhanVien = nhanVienRepository.findByUsername(username).orElse(null);
        if (nhanVien != null && nhanVien.getPassword().equals(password)) {
            return nhanVien; // Nếu thông tin đúng, trả về nhân viên
        }
        return null; // Nếu sai thông tin, trả về null
    }
}
