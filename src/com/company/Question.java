package com.company;

public class Question {
    public final int MAX_ANSWERS = 4;

    private String question;
    private int    answer;
    private String[] answers = new String[MAX_ANSWERS];

    Question(String question, int answer, String answer1, String answer2, String answer3, String answer4) {
        this.question = question;
        this.answer = answer;

        this.answers[0] = answer1;
        this.answers[1] = answer2;
        this.answers[2] = answer3;
        this.answers[3] = answer4;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public String[] getAnswers() {
        return answers;
    }
}