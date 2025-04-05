package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.Position;
import com.qlns.qlns.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    // Lấy tất cả chức vụ
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    // Lưu chức vụ
    public void save(Position position) {
        positionRepository.save(position);
    }

    // Cập nhật chức vụ
    public void updatePosition(Position position) {
        positionRepository.save(position);
    }

    // Tìm chức vụ theo id
    public Position findById(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        return position.orElse(null);
    }

    // Xóa chức vụ theo id
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }
}
