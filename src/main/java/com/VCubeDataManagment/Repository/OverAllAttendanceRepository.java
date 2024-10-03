package com.VCubeDataManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.OverAllAttendance;

@Repository
public interface OverAllAttendanceRepository extends JpaRepository<OverAllAttendance, Long>{

}
