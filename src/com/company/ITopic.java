package com.company;

import java.util.List;

public interface ITopic {
    String getName();
    void   setName(String name);
    void   addQuestion(String question, int answer, String answer1, String answer2, String answer3, String answer4);
    List<Question> getQuestions();
}
