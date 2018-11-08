package com.m8.isaacmartinez.quizApp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsMultiFragment extends Fragment {

    public static final String TAG = "QuestionFragment";

    private QuestionsFragmentListenerTwo listener;

    private TextView questionText;
    private Button first_btn;
    private Button second_btn;
    private Button third_btn;
    private Button fourth_btn;
    private Button restart_btn;
    private ImageButton hint_btn;

    public QuestionsMultiFragment() {
        // Required empty public constructor
    }

    public static QuestionsMultiFragment newInstance() {
        return new QuestionsMultiFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View questionsView = inflater.inflate(R.layout.questions_fragments_multi, container,false);

        questionText = questionsView.findViewById(R.id.message);
        questionText.setText(listener.compareAnswere(1));

        first_btn = questionsView.findViewById(R.id.first_btn);
        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(1));
            }
        });

        second_btn = questionsView.findViewById(R.id.false_btn);
        second_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(2));
            }
        });

        restart_btn = questionsView.findViewById(R.id.restart_btn);
        restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionDualList.reset();
                listener.restartGame();

                first_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionText.setText(listener.compareAnswere(1));
                    }
                });

                second_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionText.setText(listener.compareAnswere(2));
                    }
                });
                Toast.makeText(listener.getApplicationContext(),
                        "Quiz Restarted", Toast.LENGTH_SHORT)
                        .show();

                questionText.setText(QuestionDualList.getCurrentQuestionText());
            }
        });

        hint_btn = questionsView.findViewById(R.id.hint_btn);
        hint_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.startHint();
            }
        });

        return questionsView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof QuestionsMultiFragment.QuestionsFragmentListenerTwo) {
            listener = (QuestionsMultiFragment.QuestionsFragmentListenerTwo) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface QuestionsFragmentListenerTwo {
        String compareAnswere(Integer answereGiven);
        Context getApplicationContext();
        void restartGame();
        void startHint();
    }

}
