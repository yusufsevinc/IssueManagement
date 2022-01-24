package com.sevinc.repository;

import com.sevinc.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
