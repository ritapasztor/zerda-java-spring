package com.greenfox.exams.spring.Controllers;

import com.greenfox.exams.spring.Model.Feedback;
import com.greenfox.exams.spring.Service.FeedbackService;
import com.greenfox.exams.spring.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2017.01.11..
 */

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {

    FeedbackService feedbackService;
    ProjectService projectService;
    String errorMessage;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, ProjectService projectService) {
        this.feedbackService = feedbackService;
        this.projectService = projectService;
    }


    @GetMapping(value = {"", "/", "/welcome"})
    public String index(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "welcome";
    }

    @PostMapping(value = "/create")
    public String validateAndSaveFeedback(Model model, @ModelAttribute Feedback feedback) {
        if (feedbackService.validateExperience(feedback) && feedbackService.validateEmail(feedback) &&
                feedbackService.validateScale(feedback)) {
            feedbackService.saveNewFeedback(feedback);
            model.addAttribute("projects", projectService.listAllProjects());
            return "projects";
        }
        errorMessage = "Please fill in correctly";
        model.addAttribute("error", errorMessage);
        return "welcome";
    }
}
