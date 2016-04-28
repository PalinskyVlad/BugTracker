package com.bugtracker.repository;

import com.bugtracker.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IssueRepository  extends JpaRepository<Issue, Long> {

    @Query("select i from Issue i where i.name =:name")
    Issue findByName(@Param("name") String name);

    @Query("select i from Issue i where i.id =:id")
    Issue findById(@Param("id") long id);
}
