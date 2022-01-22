package com.sevinc.service;

import com.sevinc.dto.IssueDto;
import com.sevinc.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issueDto);

    Issue getById(Long id);

    Page<Issue> getAllPageable(Pageable pageable);

    Boolean delete(Long id);


}
