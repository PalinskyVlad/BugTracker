package com.bugtracker.repository;

import com.bugtracker.entity.ProjectVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Vlados on 14.03.2016.
 */
public interface ProjectVersionRepository extends JpaRepository<ProjectVersion, Long> {

    @Query("select p from ProjectVersion p where p.name =:name")
    ProjectVersion getByName(@Param("name") String name);
}
