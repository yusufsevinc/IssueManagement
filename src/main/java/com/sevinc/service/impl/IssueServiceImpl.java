package com.sevinc.service.impl;

import com.sevinc.dto.IssueDto;
import com.sevinc.entity.Issue;
import com.sevinc.repository.IssueRepository;
import com.sevinc.service.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {
        if (issueDto.getDate() == null){
            throw  new IllegalArgumentException("Issue date cannot be null");
        }

        Issue issue = modelMapper.map(issueDto ,Issue.class);
        issue = issueRepository.save(issue);
        return modelMapper.map(issue ,IssueDto.class);
    }

    @Override
    public Issue getById(Long id) {
        return issueRepository.getById(id);
    }

    @Override
    public Page<Issue> getAllPageable(Pageable pageable) {
        return issueRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
