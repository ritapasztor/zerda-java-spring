package com.greenfox.exams.spring.Repositories;

import com.greenfox.exams.spring.Model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rita on 2017.01.11..
 */

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
}
