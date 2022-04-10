package com.mfcspring.demo.service;

import com.mfcspring.demo.dto.IssueDto;
import com.mfcspring.demo.entity.Issue;
import com.mfcspring.demo.entity.Project;
import com.mfcspring.demo.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}
