package com.davidhuang.services;

import com.davidhuang.models.Question;
import com.davidhuang.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public List<Question> getAll() {
        List<Question> questions = convertToList(questionRepository.findAll());

        if (questions.isEmpty()) {
            populateDatabase();
            return getAll();
        }

        return questions;
    }

    private <T> List<T> convertToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T t : iterable) {
            list.add(t);
        }
        return list;
    }

    private void populateDatabase() {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Question q = new Question(i, i, "TEST_QUESTION_" + i);
            questions.add(q);
        }
        questionRepository.saveAll(questions);
    }

}
