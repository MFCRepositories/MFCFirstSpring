package com.mfcspring.demo.service.impl;

import com.mfcspring.demo.dto.IssueDto;
import com.mfcspring.demo.entity.Issue;
import com.mfcspring.demo.repository.IssueRepository;
import com.mfcspring.demo.service.IssueService;
import com.mfcspring.demo.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {
    private  final IssueRepository issueRepository;
    private  final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null){
            throw new IllegalArgumentException("IssueDto Date cannot be null");
        }

        Issue issueDb= modelMapper.map(issue, Issue.class);
        issueDb= issueRepository.save(issueDb) ;
        return modelMapper.map(issueDb,IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data=issueRepository.findAll(pageable);
        TPage page=new TPage<IssueDto>();
        IssueDto[] dtos =modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
