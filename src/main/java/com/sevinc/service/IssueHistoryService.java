package com.sevinc.service;

import com.sevinc.dto.IssueHistoryDto;
import com.sevinc.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

}
