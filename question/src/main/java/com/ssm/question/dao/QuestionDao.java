package com.ssm.question.dao;

import com.ssm.question.pojo.Question;

import java.util.List;

public interface QuestionDao {
    void addQuestion(Question question);

    List<Question> getQuestionList(Question question);

    Question getQuestionById(int id);

    Question getQuestionByIdWithAnswer(int id);

    void updateCountAndTime(Question question);


}
