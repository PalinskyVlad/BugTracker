package com.bugtracker.repository;

import com.bugtracker.entity.ProjectVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectVersionRepository extends JpaRepository<ProjectVersion, Long> {

    @Query("select p from ProjectVersion p where p.name =:name")
    ProjectVersion findByName(@Param("name") String name);

    @Query("select p from ProjectVersion p where p.id =:id")
    ProjectVersion findById(@Param("id") long id);
}
