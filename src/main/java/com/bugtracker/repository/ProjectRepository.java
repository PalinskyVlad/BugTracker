package com.bugtracker.repository;

import com.bugtracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Vlados on 14.03.2016.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.name =:name")
    Project findByName(@Param("name") String name);
}
