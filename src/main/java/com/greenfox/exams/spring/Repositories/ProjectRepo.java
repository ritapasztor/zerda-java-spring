package com.greenfox.exams.spring.Repositories;

import com.greenfox.exams.spring.Model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rita on 2017.01.11..
 */

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
    List<Project> findAll();
}
