package com.mfcspring.demo.service.impl;

import com.mfcspring.demo.dto.ProjectDto;
import com.mfcspring.demo.entity.Project;
import com.mfcspring.demo.repository.ProjectRepository;
import com.mfcspring.demo.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null) throw new IllegalArgumentException("Project Code Already Exist ");
        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getAllByProjectCode(String projectCode) {
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
