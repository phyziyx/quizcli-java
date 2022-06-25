package com.company;

import java.util.Scanner;

public class Quiz extends AQuiz {
    Scanner lineScanner = new Scanner(System.in);
    Scanner intScanner  = new Scanner(System.in);

    User    user        = new User();

    Topic[] topics = new Topic[MAX_TOPICS];
    int topic      = -1;

    Quiz() {
        topics[0] = new Topic("Space");
        topics[0].addQuestion("The day on which the Sun’s direct rays cross the celestial equator is called:", 0, "the equinox", "the aphelion", "the solstice", "the ecliptic");
        topics[0].addQuestion("Who invented the telescope?", 0, "Hans Lippershey", "Johannes Kepler", "Hypatia", "Galileo");
        topics[0].addQuestion("Which of these objects is the farthest from the Sun?", 0, "90377 Sedna", "Saturn", "Neptune", "Kuiper belt");
        topics[0].addQuestion("What term describes the alignment of three celestial bodies?", 0, "syzygy", "symbology", "suzerainty", "sizzle");
        topics[0].addQuestion("What is the smallest planet in the solar system by mass?", 0, "Mercury", "Mars", "Jupiter", "Earth");

        topics[1] = new Topic("World History");
        topics[1].addQuestion("First Country to sign Peace Treaty (1917)", 1, "England", "Russia", "USA", "Germany");
        topics[1].addQuestion("In which year USA joined Second World War", 1, "1940", "1941", "1939", "1942");
        topics[1].addQuestion("Axis powers in World War II?", 1, "Poland, Germany, Japan", "Italy, Germany, Japan", "France, Germany, Italy", "Italy, Japan, Britain");
        topics[1].addQuestion("On which side Japan fought First World War", 1, "Neutral", "UK", "Germany", "Russia");
        topics[1].addQuestion("First UK King during First World War?", 1, "John VII", "George V", "Anarew VIII", "Philip I");

        topics[2] = new Topic("Video Games");
        topics[2].addQuestion("Who made Skyrim?", 2, "CD Projekt Red", "Valve", "Bethesda", "Santa Monica Studios");
        topics[2].addQuestion("Which is the most played Valve game?", 2, "Team Fortress 2", "Call of Duty", "Counter Strike GO", "Battlefield");
        topics[2].addQuestion("The Last of Us video game has sold this many copies:", 2, "4M", "2M", "6M", "8M");
        topics[2].addQuestion("Who made GTA V?", 2, "Electronic Arts", "Naughty Dog", "Rockstar", "Activision");
        topics[2].addQuestion("What is the main colour of Sonic?", 2, "Red", "Purple", "Blue", "Yellow");

        System.out.println("Quiz System");

        displayRules();
        displayMenu();
    }

    private void displayList() {
        printSeparator();
        topic = -1;

        System.out.printf("| %-2s| %-16s |\n", "#", "Topic");
        for (int i = 0; i != MAX_TOPICS; i ++) {
            System.out.printf("| %-2d| %-16s |\n", i+1, topics[i].getName());
        }

        while (topic == -1) {
            System.out.print("Please select your topic: ");
            topic = intScanner.nextInt() - 1;

            if (topic >= 0 && topic < MAX_TOPICS) {
                System.out.println("You selected topic " + topics[topic].getName());
                start();
            } else {
                System.out.println("Invalid topic entered!");
                topic = -1;
            }
        }

        printSeparator();
    }

    private void displayMenu() {
        System.out.println("Please insert your username: ");
        user.setName(lineScanner.nextLine());
        System.out.println("Welcome, " + user.getName() + "!");
        displayList();
    }

    private void start() {
        user.setScore(0);
        System.out.println("Total questions: " + topics[topic].getQuestions().size() + "");

        for (Question question:
                topics[topic].getQuestions()) {

            printSeparator();

            System.out.println("Question: " + question.getQuestion());
            System.out.println("Answers:");

            for (int i = 0; i != question.getAnswers().length; i ++) {
                System.out.println(i+1 + ") " + question.getAnswers()[i]);
            }

            int input = -1;
            while (input == -1) {
                System.out.println("Insert your answer: ");
                input = intScanner.nextInt();
                if (input < 0 || input > question.getAnswers().length) {
                    input = -1;
                    System.out.println("Invalid answer entered!");
                }
            }

            if (input == 0) {
                System.out.println("You chose to skip the question!  Unchanged score: " + user.getScore());
            } else if (input - 1 == question.getAnswer()) {
                user.giveScore();
                System.out.println("Correct answer!  New score: " + user.getScore());
            } else {
                user.takeScore();
                System.out.println("Incorrect answer!  New score: " + user.getScore());
            }
        }

        System.out.println("Your final score is " + user.getScore());

        printSeparator();

        promptTryAgain();
    }

    private void promptTryAgain() {
        System.out.println("Do you want to play again?  Type 'Y' for Yes and 'N' for No");
        String line = lineScanner.nextLine();
        if (line.equalsIgnoreCase("Y")) {
            displayList();
        } else {
            System.out.println("You chose to exit the quiz.");
        }

    }
}
