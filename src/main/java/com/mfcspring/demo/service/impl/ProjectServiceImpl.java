package com.mfcspring.demo.service.impl;

import com.mfcspring.demo.entity.Project;
import com.mfcspring.demo.repository.ProjectRepository;
import com.mfcspring.demo.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
      if (project.getProjectCode()==null){
          throw new IllegalArgumentException("Project Code cannot be null");
      }
      project=projectRepository.save(project);
      return  project;
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getAllByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getAllByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
