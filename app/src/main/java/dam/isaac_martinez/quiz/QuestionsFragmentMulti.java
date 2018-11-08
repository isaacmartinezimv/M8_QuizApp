package dam.isaac_martinez.quiz;


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

public class QuestionsFragmentMulti extends Fragment {

    public static final String TAG = "QuestionFragment";

    private QuestionsFragmentListener listener;

    private TextView questionText;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private Button restart_btn;
    private ImageButton hint_btn;

    public QuestionsFragmentMulti() {
        // Required empty public constructor
    }

    public static QuestionsFragmentMulti newInstance() {
        return new QuestionsFragmentMulti();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View questionsView = inflater.inflate(R.layout.questions_multi, container,false);

        questionText = questionsView.findViewById(R.id.message);
        questionText.setText("");

        answer1 = questionsView.findViewById(R.id.answer1);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(true));
            }
        });

        answer2 = questionsView.findViewById(R.id.answer2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(false));
            }
        });

        answer3 = questionsView.findViewById(R.id.answer3);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(false));
            }
        });

        answer4 = questionsView.findViewById(R.id.answer4);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(false));
            }
        });

        restart_btn = questionsView.findViewById(R.id.restart_btn);
        restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionListDual.reset();
                listener.restartGame();

                answer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionText.setText(listener.compareAnswere(true));
                    }
                });

                answer2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionText.setText(listener.compareAnswere(false));
                    }
                });
                Toast.makeText(listener.getApplicationContext(),
                        "Quiz Restarted", Toast.LENGTH_SHORT)
                        .show();

                questionText.setText(QuestionListDual.getCurrentQuestionText());
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
        if (context instanceof QuestionsFragmentListener) {
            listener = (QuestionsFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface QuestionsFragmentListener {
        String compareAnswere(boolean answereGiven);
        Context getApplicationContext();
        void restartGame();
        void startHint();
    }

}

