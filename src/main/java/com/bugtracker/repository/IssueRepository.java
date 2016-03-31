package com.bugtracker.repository;

import com.bugtracker.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Vlados on 14.03.2016.
 */
public interface IssueRepository  extends JpaRepository<Issue, Long> {

    @Query("select i from Issue i where i.name =:name")
    Issue getByName(@Param("name") String name);
}
