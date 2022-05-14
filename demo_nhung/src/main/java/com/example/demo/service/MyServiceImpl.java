package com.example.demo.service;

import com.example.demo.model.DuLieu;
import com.example.demo.repository.DuLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService{
    @Autowired
    DuLieuRepository duLieuRepository;

    @Override
    public List<DuLieu> getAllData() {
        return duLieuRepository.getAll();
    }

    @Override
    public List<DuLieu> getData() {
        List<DuLieu> list = duLieuRepository.findTop6ByOrderByIdDesc();
        return list;
    }

    @Override
    public boolean addValue(DuLieu duLieu) {
        duLieuRepository.save(duLieu);
        return true;
    }
}
