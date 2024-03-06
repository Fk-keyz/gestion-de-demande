package com.projets.Defitech.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projets.Defitech.Models.Incident;
public interface IncidentRepository extends JpaRepository<Incident, Long> {

}
