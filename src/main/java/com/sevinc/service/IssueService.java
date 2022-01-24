package com.sevinc.service;

import com.sevinc.dto.IssueDto;
import com.sevinc.entity.Issue;
import com.sevinc.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {


    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issue);

    IssueDto update(Long id, IssueDto project);


}
