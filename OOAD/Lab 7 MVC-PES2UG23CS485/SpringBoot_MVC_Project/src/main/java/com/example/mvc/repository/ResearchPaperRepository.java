package com.example.mvc.repository;

import com.example.mvc.model.ResearchPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResearchPaperRepository extends JpaRepository<ResearchPaper, Long> {
    Optional<ResearchPaper> findByPaperTitle(String paperTitle);
}