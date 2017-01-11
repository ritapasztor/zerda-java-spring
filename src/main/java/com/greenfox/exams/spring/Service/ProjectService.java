package com.greenfox.exams.spring.Service;

import com.greenfox.exams.spring.Model.Project;
import com.greenfox.exams.spring.Repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rita on 2017.01.11..
 */

@Service
public class ProjectService {

    private ProjectRepo repository;

    @Autowired
    public ProjectService(ProjectRepo repository) {
        this.repository = repository;
    }

    public List<Project> listAllProjects() {
        return repository.findAll();
    }
}
