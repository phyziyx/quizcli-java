package com.company;

public abstract class AQuiz {
    final int MAX_TOPICS = 3;

    public void printSeparator() {
        System.out.println("\n------------------------------");
    }

    public void displayRules() {
        printSeparator();
        System.out.println("Rules:");
        System.out.println("1.  For every correct answer, your score is +1");
        System.out.println("2.  For every incorrect answer, your score is -0.5");
        System.out.println("3.  You can choose to skip any question by pressing  '0'  as answer");
        System.out.println("4.  You can select the topic");
        printSeparator();
    }
}
