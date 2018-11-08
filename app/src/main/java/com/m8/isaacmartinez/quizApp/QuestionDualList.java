package com.m8.isaacmartinez.quizApp;

public class QuestionDualList {

    private static final QuestionDual[] QUESTION_DUALS = new QuestionDual[] {
            new QuestionDual("Hay arsénico en el café?", true,
                    R.drawable.cafe),
            new QuestionDual("La misma película, sin cortes, dura menos en \nelevisión que en el cine?", true,
                    R.drawable.cinema),
            new QuestionDual("En el Palacio del Elíseo, en París, viven varios \nanimales. Tradicionalmente, siempre hay \nun cerdo llamado Napoleón?", false,
                    R.drawable.paris),
            new QuestionDual("Cuando hace mucho frío tomar una copa de vino hace \nentrar en calor?", false,
                    R.drawable.vino),
            new QuestionDual("El pelo y las uñas siguen creciendo después de la \nmuerte?", false,
                    R.drawable.pelo),
            new QuestionDual("Una tostada con mantequilla lanzada al aire cae por \nel lado del a mantequilla tres ce cada \ncuatro veces?", false,
                    R.drawable.tostada),
            new QuestionDual("Los esquimales utilizan 226 palabras distintas para \n designar la nieve según su estado?", false,
                    R.drawable.esquimal),
            new QuestionDual("En los hogares españoles hay más pájaros que gatos?", true,
                    R.drawable.gato),
    };

    private static int nextQuestion = 0;

    public static boolean next(){
        if (++nextQuestion < QUESTION_DUALS.length) {
            return true;
        } else {
            nextQuestion--;
            return false;
        }
    }

    public static Boolean checkAnswere(Boolean answere) {
        return QUESTION_DUALS[nextQuestion].getAnswer() == answere;
    }

    public static void reset() {
        nextQuestion = 0;
    }

    public static String getCurrentQuestionText() {
        return QUESTION_DUALS[nextQuestion].getText();
    }

    public static int getCurrentQuestionHint() {
        return QUESTION_DUALS[nextQuestion].getClue();
    }

    public static int getNumQuestions() {
        return QUESTION_DUALS.length;
    }

    public static int getIndex() {
        return nextQuestion;
    }

    public static void setIndex(int index) {
        if (index < QUESTION_DUALS.length) {
            nextQuestion = index;
        } else {
            nextQuestion = QUESTION_DUALS.length - 1;
        }
    }
}
