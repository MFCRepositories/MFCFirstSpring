package com.mfcspring.demo.service;

import com.mfcspring.demo.dto.IssueDto;
import com.mfcspring.demo.entity.Issue;
import com.mfcspring.demo.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    Page<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}
