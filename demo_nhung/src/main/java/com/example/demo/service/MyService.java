package com.example.demo.service;

import com.example.demo.model.DuLieu;

import java.util.List;

public interface MyService {
    List<DuLieu> getAllData();
    List<DuLieu> getData();
    boolean addValue(DuLieu duLieu);
}
