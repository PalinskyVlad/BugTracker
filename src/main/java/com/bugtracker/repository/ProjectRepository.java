package com.bugtracker.repository;

import com.bugtracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.name =:name")
    Project findByName(@Param("name") String name);

    @Query("select p from Project p where p.id =:id")
    Project findById(@Param("id") long id);

    @Query("select p.name from Project as p")
    List<String> findAllNames();
}
