package dam.isaac_martinez.quiz;

public class QuestionDual {
    private String questionText;
    private Boolean correctAnswer;
    private int clue;

    public QuestionDual(String questionText, Boolean correctAnswer, int clue) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.clue = clue;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setClue(int clue) {
        this.clue = clue;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public Boolean getCorrectAnswer() {
        return this.correctAnswer;
    }

    public int getClue() {
        return clue;
    }
}

