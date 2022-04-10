package com.mfcspring.demo.service;

import com.mfcspring.demo.dto.ProjectDto;
import com.mfcspring.demo.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProjectService {
    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete (Project project);
}
