package com.m8.isaacmartinez.quizApp;

public class QuestionMultiList {
    private static final QuestionMulti[] QUESTION_MULTIS = new QuestionMulti[]{
            new QuestionMulti("Cual es la capital de España?", "Barcelona", "Madrid", "Valencia", "Mallorca", R.drawable.cafe, 2),
    };



    private static int nextQuestion = 0;

    public static boolean next(){
        if (++nextQuestion < QUESTION_MULTIS.length) {
            return true;
        } else {
            nextQuestion--;
            return false;
        }
    }

    public static boolean checkAnswere(Integer answer) {
        if (QUESTION_MULTIS[nextQuestion].getAnswer() == answer) {
            return true;
        } else {
            return false;
        }

    }

    public static void reset() {
        nextQuestion = 0;
    }

    public static String getCurrentQuestionText() {
        return QUESTION_MULTIS[nextQuestion].getText();
    }

    public static int getCurrentQuestionHint() {
        return QUESTION_MULTIS[nextQuestion].getClue();
    }

    public static int getNumQuestions() {
        return QUESTION_MULTIS.length;
    }

    public static int getIndex() {
        return nextQuestion;
    }

    public static void setIndex(int index) {
        if (index < QUESTION_MULTIS.length) {
            nextQuestion = index;
        } else {
            nextQuestion = QUESTION_MULTIS.length - 1;
        }
    }

}
