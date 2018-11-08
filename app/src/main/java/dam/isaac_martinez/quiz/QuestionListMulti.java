package dam.isaac_martinez.quiz;


public class QuestionListMulti {

    private static final QuestionMulti[] questions = new QuestionMulti[] {
            new QuestionMulti("Cual es la capital de España?", "Barcelona", "Madrid", "Valencia", "Mallorca", 2, R.drawable.cafe),
    };

    private static int nextQuestion = 0;

    public static boolean next(){
        if (++nextQuestion < questions.length) {
            return true;
        } else {
            nextQuestion--;
            return false;
        }
    }

    public static boolean checkAnswere(Integer anwere) {
        return questions[nextQuestion].getAnwere() == anwere;
    }

    public static void reset() {
        nextQuestion = 0;
    }

    public static String getCurrentQuestionText() {
        return questions[nextQuestion].getText();
    }

    public static int getCurrentQuestionHint() {
        return questions[nextQuestion].getHint();
    }

    public static int getNumQuestions() {
        return questions.length;
    }

    public static int getIndex() {
        return nextQuestion;
    }

    public static void setIndex(int index) {
        if (index < questions.length) {
            nextQuestion = index;
        } else {
            nextQuestion = questions.length - 1;
        }
    }
}
