package dam.isaac_martinez.quiz;


public class QuestionListDual {

    private static final QuestionDual[] questions = new QuestionDual[] {
            new QuestionDual("Hay arsénico en el café?", true,
                    R.drawable.cafe),
            new QuestionDual("La misma película, sin cortes, dura menos en televisión que en el cine?", true,
                    R.drawable.cinema),
            new QuestionDual("En el Palacio del Elíseo, en París, viven varios animales. Tradicionalmente, siempre hay un cerdo llamado Napoleón?", false,
                    R.drawable.paris),
            new QuestionDual("Cuando hace mucho frío tomar una copa de vino hace entrar en calor?", false,
                    R.drawable.chupito),
            new QuestionDual("El pelo y las uñas siguen creciendo después de la muerte?", false,
                    R.drawable.pelo),
            new QuestionDual("Una tostada con mantequilla lanzada al aire cae por el lado del a mantequilla tres ce cada cuatro veces?", false,
                    R.drawable.tostada),
            new QuestionDual("Los esquimales utilizan 226 palabras distintas para designar la nieve según su estado?", false,
                    R.drawable.esquimal),
            new QuestionDual("En los hogares españoles hay más pájaros que gatos?", true,
            R.drawable.gato),
            new QuestionDual("La Gran Muralla China es la única obra construida por el hombre visible a simple vista desde el espacio?", false,
                    R.drawable.muralla),
            new QuestionDual("El ser humano pierde aproximadamente el 75% de calor corporal por la cabeza. Es por ello que en época de bajas temperaturas las personas tienen la tendencia a cubrirse bien la cabeza con algún tipo de prenda?", false,
                    R.drawable.gorro),
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

    public static boolean checkAnswere(boolean answere) {
        return questions[nextQuestion].getCorrectAnswer() == answere;
    }

    public static void reset() {
        nextQuestion = 0;
    }

    public static String getCurrentQuestionText() {
        return questions[nextQuestion].getQuestionText();
    }

    public static int getCurrentQuestionHint() {
        return questions[nextQuestion].getClue();
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
