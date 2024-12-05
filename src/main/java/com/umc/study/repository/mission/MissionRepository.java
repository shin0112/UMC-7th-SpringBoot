package com.umc.study.repository.mission;

import com.umc.study.domain.Mission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("SELECT m " +
        "FROM Mission m " +
        "LEFT JOIN Store s ON m.store.id = s.id " +
        "LEFT JOIN Region r ON s.region.id = r.id " +
        "WHERE r.name = :name")
    List<Mission> findMissionsByRegionName(@Param("name") String name);

}
