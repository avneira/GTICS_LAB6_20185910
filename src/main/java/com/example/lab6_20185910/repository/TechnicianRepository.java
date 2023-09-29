package com.example.lab6_20185910.repository;

import com.example.lab6_20185910.entity.Technician;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Integer> {
}