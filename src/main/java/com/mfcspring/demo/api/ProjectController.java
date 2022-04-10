package com.mfcspring.demo.api;

import com.mfcspring.demo.dto.ProjectDto;
import com.mfcspring.demo.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImp;

    public ProjectController(ProjectServiceImpl projectServiceImp) {
        this.projectServiceImp = projectServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        ProjectDto projectDto = projectServiceImp.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImp.save(project));

    }

}
