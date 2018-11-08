package com.m8.isaacmartinez.quizApp;

public class QuestionDual {
    private String text;
    private Boolean answer;
    private int clue;

    public QuestionDual(String text, Boolean answer, int clue) {
        this.text = text;
        this.answer = answer;
        this.clue = clue;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public void setClue(int clue) {
        this.clue = clue;
    }

    public String getText() {
        return this.text;
    }

    public Boolean getAnswer() {
        return this.answer;
    }

    public int getClue() {
        return clue;
    }
}
