package com.company;

import java.util.ArrayList;
import java.util.List;

public class Topic implements ITopic {
    private String name;
    List<Question> questions = new ArrayList<Question>();

    Topic(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addQuestion(String question, int answer, String answer1, String answer2, String answer3, String answer4) {
        questions.add(new Question(question, answer, answer1, answer2, answer3, answer4));
    }

    @Override
    public List<Question> getQuestions() {
        return questions;
    }
}
