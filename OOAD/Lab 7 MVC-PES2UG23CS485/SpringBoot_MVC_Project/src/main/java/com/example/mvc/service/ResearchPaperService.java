package com.example.mvc.service;

import com.example.mvc.model.ResearchPaper;
import com.example.mvc.repository.ResearchPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResearchPaperService {

    @Autowired
    private ResearchPaperRepository repository;

    public String savePaper(ResearchPaper paper) {
        // Validate required fields
        if (paper.getEmail() == null || paper.getEmail().isEmpty()) {
            return "Email is required!";
        }
        if (paper.getPaperTitle() == null || paper.getPaperTitle().isEmpty()) {
            return "Paper title is required!";
        }

        // Check for duplicate title
        if (repository.findByPaperTitle(paper.getPaperTitle()).isPresent()) {
            return "A paper with this title already exists!";
        }

        // Auto-generate submission date
        paper.setSubmissionDate(LocalDate.now());

        repository.save(paper);
        return "success";
    }

    public List<ResearchPaper> getAllPapers() {
        return repository.findAll();
    }
}