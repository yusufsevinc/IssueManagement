package com.sevinc.service;

import com.sevinc.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCodeContains);

    Boolean delete(Long id);

}
