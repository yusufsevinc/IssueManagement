package com.sevinc.service.impl;

import com.sevinc.dto.IssueHistoryDto;
import com.sevinc.entity.IssueHistory;
import com.sevinc.repository.IssueHistoryRepository;
import com.sevinc.service.IssueHistoryService;
import com.sevinc.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueHistoryServiceImpl  implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueHistoryDto save(IssueHistoryDto issueHistory) {
        IssueHistory ih = modelMapper.map(issueHistory, IssueHistory.class);
        ih = issueHistoryRepository.save(ih);
        issueHistory.setId(ih.getId());
        return issueHistory;
    }

    @Override
    public IssueHistoryDto getById(Long id) {
        IssueHistory ih = issueHistoryRepository.getOne(id);
        return modelMapper.map(ih, IssueHistoryDto.class);
    }

    @Override
    public TPage<IssueHistoryDto> getAllPageable(Pageable pageable) {
        Page<IssueHistory> data = issueHistoryRepository.findAll(pageable);
        TPage<IssueHistoryDto> respnose = new TPage<IssueHistoryDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueHistoryDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(IssueHistoryDto issueHistory) {
        issueHistoryRepository.deleteById(issueHistory.getId());
        return Boolean.TRUE;
    }
}
