package hackathontw.com.br.hackathontw;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
                ImageView image = (ImageView) findViewById(R.id.imgHistory);
                Bitmap icon = ((BitmapDrawable)image.getDrawable()).getBitmap();

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
                try {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/temporary_file.jpg"));
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


//        Button showFeedbackDialog = (Button) findViewById(R.id.btnStart);
//        showFeedbackDialog.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                FeedbackDialog dialog = new FeedbackDialog(HistoryActivity.this, true);
//                dialog.show();
//            }
//        });

//        Button endStageDialog = (Button) findViewById(R.id.btnStart);
//        endStageDialog.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                EndStageDialog dialog = new EndStageDialog(HistoryActivity.this);
//                dialog.show();
//            }
//        });
    }
}