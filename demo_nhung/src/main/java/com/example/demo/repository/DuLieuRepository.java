package com.example.demo.repository;

import com.example.demo.model.DuLieu;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DuLieuRepository extends JpaRepository<DuLieu, Integer> {
    @Query("SELECT dl FROM DuLieu dl")
    List<DuLieu> getAll();

    List<DuLieu> findTop6ByOrderByIdDesc();
}
