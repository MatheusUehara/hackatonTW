package hackathontw.com.br.hackathontw;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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

    public FeedbackDialog(final Context context, boolean isCorrectAnswer, final int stars, final int currentLevel)
    {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.feedback_dialog);

        TextView customTitle = (TextView) this.findViewById(R.id.customTitle);
        ImageView image = (ImageView) this.findViewById(R.id.image);
        LinearLayout dialogPanel = (LinearLayout) this.findViewById(R.id.dialogPanel);
        if(isCorrectAnswer) {
            customTitle.setText(context.getResources().getString(R.string.feedback_success));

            image.setImageResource(R.drawable.icone_yay);

            dialogPanel.setBackgroundResource(R.color.colorCorrectAnswer);
        }
        else {
            customTitle.setText(context.getResources().getString(R.string.feedback_fail));

            image.setImageResource(R.drawable.icone_nop);

            dialogPanel.setBackgroundResource(R.color.colorWrongAnswer);
        }

        TextView content = (TextView) this.findViewById(R.id.content);
        content.setText("lorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsum.");

        Button dialogButton = (Button) this.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackDialog.this.dismiss();
                if(stars != -1){
                    Log.d("STARS" , stars+"");
                    EndStageDialog endStage = new EndStageDialog(context, stars, currentLevel);
                    endStage.show();
                }
            }
        });

        this.setCancelable(false);
    }
}