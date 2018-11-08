package com.m8.isaacmartinez.quizApp;

public class QuestionMulti {
    private String text;
    private String possibility1;
    private String possibility2;
    private String possibility3;
    private String possibility4;
    private int clue;
    private Integer answer;

    public QuestionMulti(String text, String possibility1, String possibility2, String possibility3, String possibility4, int clue, Integer answer) {
        this.text = text;
        this.possibility1 = possibility1;
        this.possibility2 = possibility2;
        this.possibility3 = possibility3;
        this.possibility4 = possibility4;
        this.clue = clue;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPossibility1() {
        return possibility1;
    }

    public void setPossibility1(String possibility1) {
        this.possibility1 = possibility1;
    }

    public String getPossibility2() {
        return possibility2;
    }

    public void setPossibility2(String possibility2) {
        this.possibility2 = possibility2;
    }

    public String getPossibility3() {
        return possibility3;
    }

    public void setPossibility3(String possibility3) {
        this.possibility3 = possibility3;
    }

    public String getPossibility4() {
        return possibility4;
    }

    public void setPossibility4(String possibility4) {
        this.possibility4 = possibility4;
    }

    public int getClue() {
        return clue;
    }

    public void setClue(int hint) {
        this.clue = hint;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
