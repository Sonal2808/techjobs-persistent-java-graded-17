package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @NotBlank(message = "Location cannot be blank")
    @Size(max = 255, message = "Location cannot exceed 255 characters")
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id") // Add this line with the correct column name
    private List<Job> jobs = new ArrayList<>();

    public Employer() {
        // no-arg constructor required for Hibernate
    }

    @Override
    public void setSkills(List<Skill> skillObjs) {

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        if (jobs == null) {
            jobs = new ArrayList<>();
        }
        return jobs;
    }

    public Collection<Object> getSkills() {
        return null;
    }

    public void addSkill(Skill skill) {
    }
}
