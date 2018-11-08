package com.m8.isaacmartinez.quizApp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements QuestionsDualFragment.QuestionsFragmentListener {

    private int answers = 0;
    private boolean gameFinished = false;

    private SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        sharedPreferences();

        QuestionsDualFragment questionsDualFragment = QuestionsDualFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, questionsDualFragment)
                .commit();

    }

    private void sharedPreferences() {
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.my_preferences), Context.MODE_PRIVATE);

        answers = preferences.getInt(getString(R.string.saved_answers), 0);

        gameFinished = preferences.getBoolean(getString(R.string.saved_game_state), false);

        QuestionDualList.setIndex(
                preferences.getInt(getString(R.string.saved_next_question), 0));

        prefEditor = preferences.edit();
    }

    private void saveSharedPreferences() {
        prefEditor.putInt(getString(R.string.saved_answers), answers);
        prefEditor.putBoolean(getString(R.string.saved_game_state), gameFinished);
        prefEditor.putInt(getString(R.string.saved_next_question), QuestionDualList.getIndex());
        prefEditor.commit();
    }

    @Override
    public String compareAnswere(Boolean answerGiven) {
        String res = "Game Finished (" + answers + " answers of " +
                QuestionDualList.getNumQuestions() + " questions).";

        if (!gameFinished) {

            String toastMessage = getString(R.string.toast_incorrect);
            if (QuestionDualList.checkAnswere(answerGiven)) {
                toastMessage = getString(R.string.toast_correct);
                answers++;
            }

            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

            gameFinished = !QuestionDualList.next();

            if (!gameFinished)
                res = QuestionDualList.getCurrentQuestionText();
        }

        saveSharedPreferences();
        return res;
    }

    @Override
    public void restartGame() {
        answers = 0;
        gameFinished = false;
        saveSharedPreferences();
    }

    @Override
    public void startHint() {
        if (!gameFinished) {
            DialogFragment hint = new Clue();

            hint.show(getSupportFragmentManager(), "Hint");
        }
    }
}
