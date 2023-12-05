package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobRepository jobRepository;
    private List<org.launchcode.techjobs.persistent.models.Skill> Skill;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "MyJobs");
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");

        // Add employer and skill data to the model
        List<Employer> employers = (List<Employer>) employerRepository.findAll();
        List<Skill> skills = (List<Skill>) skillRepository.findAll();
        model.addAttribute("employers", employers);
        model.addAttribute("skills", skills);

        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model,
                                    @RequestParam int employerId,
                                    @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("newJob", newJob);
            return "add";
        }

        // Select the employer object based on the user's choice
        Optional<Employer> employerOptional = employerRepository.findById(employerId);
        if (employerOptional.isPresent()) {
            Employer selectedEmployer = employerOptional.get();
            newJob.setEmployer(selectedEmployer);
        }

        // Use the injected SkillRepository to get the skill objects based on the list of skill ids

        // Convert Iterable to List
        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);


         jobRepository.save(newJob);
        return "redirect:/";
    }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {


        Optional<Job> jobOptional = jobRepository.findById(jobId);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:/error";

        }
    }}
