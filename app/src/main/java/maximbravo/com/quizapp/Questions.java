package maximbravo.com.quizapp;

import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wendy on 6/15/2016.
 */

/*
    What food makes up nearly all (around 99%) of a Giant Panda’s diet?
    True or false? Mice live for up to 10 years.
    What is the name of the phobia that involves an abnormal fear of spiders?
    What is the largest type of ‘big cat’ in the world?
    True or false? Crocodiles have no sweat glands so they use their mouths to release heat.
    Are butterflies insects?
    What are female elephants called?
    True or false? Bats are mammals.
    Bees are found on every continent of earth except for one, which is it?
     True or false? Cats spend an average of 13 to 14 hours a day sleeping.
     What is the fastest land animal in the world?
     A ‘doe’ is what kind of animal?
     True or false? Cougar’s are herbivores.
     Groups of lions are known as what?
     Is a dolphin a mammal?
     What is the largest land animal in the world?
     True of false? Snakes have slimy skin.
     What is the only continent on earth where Giraffes live in the wild?
     How many pairs of wings does a bee have?
     What type of animal is the largest primate in the world?
 */
public class Questions {
    private static String q1 = "What food makes up nearly all (around 99%) of a Giant Panda’s diet?";
    private static String q2 = "True or false? Mice live for up to 10 years.";
    private static String q3 = "What is the name of the phobia that involves an abnormal fear of spiders?";
    private static String q4 = "What is the largest type of ‘big cat’ in the world?";
    private static String q5 = "True or false? Crocodiles have no sweat glands so they use their mouths to release heat.";
    private static String q6 = "Are butterflies insects?";
    private static String q7 = "What are female elephants called?";
    private static String q8 = "True or false? Bats are mammals.";
    private static String q9 = "Bees are found on every continent of earth except for one, which is it?";
    private static String q10 = "True or false? Cats spend an average of 13 to 14 hours a day sleeping.";
    private static String[] questions = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

    private static String[] a1 = {"Lettuce", "Bamboo", "Carrots", "Shoots", "2"};
    private static String[] a2 = {"True", "False", "Apples", "Oranges", "2"};
    private static String[] a3 = {"Venustraphobia", "Anthropophobia", "Gamophobia", "Arachnophobia", "4"};
    private static String[] a4 = {"Jaguar", "Puma", "Tiger", "Lion", "3"};
    private static String[] a5 = {"True", "False", "Owl", "Bear", "1"};
    private static String[] a6 = {"No", "Yes", "Maybe", "Maybe Not", "2"};
    private static String[] a7 = {"Shrimp", "Cows", "Goats", "Chimps", "2"};
    private static String[] a8 = {"Dog", "No", "True", "False", "3"};
    private static String[] a9 = {"Antarctica", "Africa", "Arcitc", "South Pole", "1"};
    private static String[] a10 = {"False", "Trash", "Paper", "True", "4"};
    private static ArrayList<String[]> answers = new ArrayList<String[]>();

    private static boolean addedAnswers = false;

    public static void makeAnswers(){
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        answers.add(a5);
        answers.add(a6);
        answers.add(a7);
        answers.add(a8);
        answers.add(a9);
        answers.add(a10);
    }

    public static String[] getEntry(int qN){
        int qNumber = qN - 1;
        if(!addedAnswers){
            makeAnswers();
            addedAnswers = true;
        }
        String[] ret = new String[6];
        String[] options = answers.get(qNumber);
        // Adds question
        ret[0] = questions[qNumber];
        // first option
        ret[1] = options[0];
        // second option
        ret[2] = options[1];
        // third option
        ret[3] = options[2];
        // fourth option
        ret[4] = options[3];
        // right answer
        ret[5] = options[4];
        return ret;
    }
//    public static int correctAnswer(int qN){
//        String[] options = answers.get(qN - 1);
//        if(options[5].equals("1")){
//            return 1;
//        }
//        if(options[5].equals("2")){
//            return 2;
//        }
//        if(options[5].equals("3")){
//            return 3;
//        }
//        if(options[5].equals("4")){
//            return 4;
//        } else {
//            return 5;
//        }
//    }


}
