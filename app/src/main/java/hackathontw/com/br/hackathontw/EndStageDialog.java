package hackathontw.com.br.hackathontw;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class EndStageDialog extends Dialog {

    public EndStageDialog(final Context context)
    {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.end_stage_dialog);

        Button dialogButtonAgain = (Button) this.findViewById(R.id.dialogButtonAgain);
        dialogButtonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Repete a fase
            }
        });

        Button dialogButton = (Button) this.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Vai para a proxima fase ou menu.
            }
        });

        this.setCancelable(false);
    }
}
