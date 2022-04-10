package com.mfcspring.demo.repo;

import com.mfcspring.demo.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
