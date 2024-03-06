package com.projets.Defitech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projets.Defitech.Models.Demand;

public interface DemandRepository extends JpaRepository<Demand, Long> {

}
