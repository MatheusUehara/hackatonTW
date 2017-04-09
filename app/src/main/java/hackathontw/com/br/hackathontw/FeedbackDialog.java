package hackathontw.com.br.hackathontw;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class FeedbackDialog extends Dialog {

    public FeedbackDialog(final Context context, boolean isCorrectAnswer)
    {
        super(context);
        this.setContentView(R.layout.feedback_dialog);

        ImageView image = (ImageView) this.findViewById(R.id.image);
        if(isCorrectAnswer) {
            this.setTitle("Parabéns, você acertou!");

            image.setImageResource(R.drawable.icone_yay);
        }
        else {
            this.setTitle("Que pena, não foi dessa vez...");

            image.setImageResource(R.drawable.icone_nop);
        }

        TextView content = (TextView) this.findViewById(R.id.content);
        content.setText("lorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsum.");

        Button dialogButton = (Button) this.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackDialog.this.dismiss();
            }
        });
        //dialog.getWindow().setBackgroundDrawableResource(R.color.colorCorrectAnswer);
        //dialog.getWindow().setBackgroundDrawableResource(R.color.colorPrimary);
        this.setCancelable(false);
    }
}
