package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToMany
    @JoinTable(
            name = "job_skill",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills = new ArrayList<>();

    // Constructors, toString, and other methods

    // Constructor with employer and skills
    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    public Job() {
        
    }

    // Getters and setters

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }
}
