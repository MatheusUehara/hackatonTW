package hackathontw.com.br.hackathontw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class HistoryActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final Button btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Uri imageUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.drawable.history01);

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");

                share.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(share, "Share Image"));
            }
        });

//        final Button btnStart = (Button) findViewById(R.id.btnStart);
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Intent tela2 = new Intent(HistoryActivity.this, MainActivity.class);
//                startActivity(tela2);
//            }
//        });


        Button showFeedbackDialog = (Button) findViewById(R.id.btnStart);
        showFeedbackDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

//                final Dialog dialog = new Dialog(HistoryActivity.this);
//                dialog.setContentView(R.layout.feedback_dialog);
//                dialog.setTitle("Title...");
//
//                ImageView image = (ImageView) dialog.findViewById(R.id.image);
//                image.setImageResource(R.drawable.card1);
//
//                TextView content = (TextView) dialog.findViewById(R.id.content);
//                content.setText("lorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsum.");
//
//                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
//                dialogButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//                //dialog.getWindow().setBackgroundDrawableResource(R.color.colorCorrectAnswer);
//                //dialog.getWindow().setBackgroundDrawableResource(R.color.colorPrimary);
//                dialog.setCancelable(false);
//                dialog.show();

                FeedbackDialog dialog = new FeedbackDialog(HistoryActivity.this, true);
                dialog.show();
            }
        });
    }
}