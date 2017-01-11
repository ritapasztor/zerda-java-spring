package com.greenfox.exams.spring.Service;

import com.greenfox.exams.spring.Model.Feedback;
import com.greenfox.exams.spring.Repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rita on 2017.01.11..
 */

@Service
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void saveNewFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }



    public boolean validateExperience(Feedback feedback) {
        ArrayList<String> niceWords = new ArrayList<>(Arrays.asList("amazing", "awesome", "blithesome",
                "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible",
                "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart",
                "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"));
        int numberOfNiceWords = 0;
        for (String goodWords : niceWords) {
            if (feedback.getExperience().contains(goodWords)) {
                numberOfNiceWords = +1;
            }
        }
        return numberOfNiceWords > 3;
    }

    public boolean validateScale(Feedback feedback) {
        return feedback.getScale() >= 5;
    }

    public boolean validateEmail(Feedback feedback) {
        return feedback.getEmail().contains("@");
    }
}
