package hackathontw.com.br.hackathontw;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class FeedbackDialog extends Dialog {

    public FeedbackDialog(final Context context, boolean isCorrectAnswer)
    {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.feedback_dialog);

        TextView customTitle = (TextView) this.findViewById(R.id.customTitle);
        ImageView image = (ImageView) this.findViewById(R.id.image);
        LinearLayout dialogPanel = (LinearLayout) this.findViewById(R.id.dialogPanel);
        if(isCorrectAnswer) {
            customTitle.setText("Parabéns, você acertou!");

            image.setImageResource(R.drawable.card1);

            dialogPanel.setBackgroundResource(R.color.colorCorrectAnswer);
        }
        else {
            customTitle.setText("Que pena, não foi dessa vez...");

            image.setImageResource(R.drawable.card2);

            dialogPanel.setBackgroundResource(R.color.colorWrongAnswer);
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
