package com.example.mvc.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ResearchPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorName;

    @Column(nullable = false)
    private String email;

    @Column(unique = true)
    private String paperTitle;

    private String researchDomain;

    private LocalDate submissionDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPaperTitle() { return paperTitle; }
    public void setPaperTitle(String paperTitle) { this.paperTitle = paperTitle; }

    public String getResearchDomain() { return researchDomain; }
    public void setResearchDomain(String researchDomain) { this.researchDomain = researchDomain; }

    public LocalDate getSubmissionDate() { return submissionDate; }
    public void setSubmissionDate(LocalDate submissionDate) { this.submissionDate = submissionDate; }
}