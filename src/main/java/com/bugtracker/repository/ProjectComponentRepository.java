package com.bugtracker.repository;

import com.bugtracker.entity.ProjectComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Vlados on 14.03.2016.
 */
public interface ProjectComponentRepository extends JpaRepository<ProjectComponent, Long> {

    @Query("select p from ProjectComponent p where p.name =:name")
    ProjectComponent getByName(@Param("name") String name);

    @Query("select p from ProjectComponent p where p.id =:id")
    ProjectComponent getById(@Param("id") long id);
}
