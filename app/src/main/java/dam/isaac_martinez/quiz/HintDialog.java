package dam.isaac_martinez.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class HintDialog extends DialogFragment {

    private ImageView viewHint;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.content_hint, null);
        viewHint = view.findViewById(R.id.viewHint);
        viewHint.setImageResource(QuestionListDual.getCurrentQuestionHint());

        builder.setView(view)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("#################################### CLOSE");
                    }
                });

        return builder.create();
    }
}
