package maximbravo.com.quizapp;

import java.util.ArrayList;

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


    private static String[] q1 = {"What food makes up nearly all (around 99%) of a Giant Panda’s diet?",
            "r", "Lettuce", "Bamboo", "Carrots", "Shoots", "2"};
    private static String[] q2 = {"Check all that are mammals.",
            "c", "Dog", "Cat", "Chicken", "Bat", "124"};
    private static String[] q3 = {"Write down what key word you use in Java to indicate you want a variable to hold text. (Capitalization matters!)",
            "f", "String"};
    private static String[] q4 = {"What is the largest type of ‘big cat’ in the world?",
            "r", "Jaguar", "Puma", "Tiger", "Lion", "3"};
    private static String[] q5 = {"What is the name of the phobia that involves an abnormal fear of spiders?",
            "r", "Venustraphobia", "Anthropophobia", "Gamophobia", "Arachnophobia", "4"};
    private static String[] q6 = {"Are butterflies insects?",
            "r", "No", "Yes", "Maybe", "Maybe Not", "2"};
    private static String[] q7 = {"What is a baby elephant called? (All lowercase, please)",
            "f", "calf"};
    private static String[] q8 = {"True or false? Mice live for up to 10 years.",
            "r", "True", "False", "Apples", "Oranges", "2"};
    private static String[] q9 = {"Check all contenents where bees are found?",
            "c", "Antarctica", "Africa", "North America", "Europe", "234"};
    private static String[] q10 ={ "True or false? Cats spend an average of 13 to 14 hours a day sleeping.",
            "r", "False", "Trash", "Paper", "True", "4"};


    private static ArrayList<String[]> QAndA = new ArrayList<String[]>();
    private static String[] currentQuestion;
    private static int qNumber;


    public Questions(int qN){
        qNumber = qN - 1;
        makeQAndA();
    }

    private static void makeQAndA(){
        QAndA.add(q1);
        QAndA.add(q2);
        QAndA.add(q3);
        QAndA.add(q4);
        QAndA.add(q5);
        QAndA.add(q6);
        QAndA.add(q7);
        QAndA.add(q8);
        QAndA.add(q9);
        QAndA.add(q10);
        currentQuestion = QAndA.get(qNumber);
    }

    public static String[] getQuestionOptions(){
        if(currentQuestion[1].equals("r") || currentQuestion[1].equals("c")){
            String[] options = {
                currentQuestion[2],
                currentQuestion[3],
                currentQuestion[4],
                currentQuestion[5],
                currentQuestion[6]
            };
            return options;
        } else {
            String[] options = {
                currentQuestion[2]
            };
            return options;
        }
    }

    public static String getQuestion(){
        return currentQuestion[0];
    }
    public static String getAnswer(){
        if(getQuestionType().equals("f")){
            return currentQuestion[2];
        }
        return currentQuestion[6];
    }
    public static String getQuestionType(){
        return currentQuestion[1];
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
