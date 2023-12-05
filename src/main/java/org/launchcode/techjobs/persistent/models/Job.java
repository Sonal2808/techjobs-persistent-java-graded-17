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
    @JoinColumn(name = "skills_id")
    private List<Skill> skills = new ArrayList<>();
    public Job() {

    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public void setSkills(List<Skill> skills) {

    }

    // Constructor with employer and skills
    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
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
    public void addSkill(Skill skills){
        this.skills.add(skills);
    }

}
