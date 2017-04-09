package hackathontw.com.br.hackathontw.components;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import hackathontw.com.br.hackathontw.HistoryActivity;
import hackathontw.com.br.hackathontw.Level;
import hackathontw.com.br.hackathontw.MenuActivity;
import hackathontw.com.br.hackathontw.R;
import hackathontw.com.br.hackathontw.Session;
import hackathontw.com.br.hackathontw.SharedPrefManager;

/**
 * Created by GilsonDeOliveira on 08/04/2017.
 */

public class EndStageDialog extends Dialog {

    public EndStageDialog(final Context context, int starts, final Integer level)
    {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.end_stage_dialog);

        final Integer score = starts;

        final ImageView stars = (ImageView) findViewById(R.id.imgFstStar);
        TextView titulo = (TextView) findViewById(R.id.customTitle);

        if ( score == 0){
            titulo.setText(context.getResources().getString(R.string.end_stage_fail));
            stars.setImageResource(R.drawable.icone_nop);
        }else if ( score == 1){
            stars.setImageResource(R.drawable.one_star);
        }else if ( score == 2 ){
            stars.setImageResource(R.drawable.two_stars);
        }else if ( score == 3) {
            stars.setImageResource(R.drawable.three_stars);
        }

        Button dialogButtonAgain = (Button) this.findViewById(R.id.dialogButtonAgain);
        dialogButtonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(context, HistoryActivity.class);
                menu.putExtra("level", level);
                context.startActivity(menu);
            }
        });

        Button dialogButton = (Button) this.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Level novoScore = new Level(level-1, score, false);
                Session.getUsuarioLogado().getLevels().set(level-1, novoScore);

                //Verifica se o próximo nível está bloqueado...
                if (Session.getUsuarioLogado().getLevels().get(level).getLocked() && score > 0) {
                    Level novoLevel = new Level(level, 0, false);
                    Session.getUsuarioLogado().getLevels().set(level, novoLevel);
                }

                SharedPrefManager.getInstance(getContext()).saveUserInSharedPref(Session.getUsuarioLogado());
                Intent menu = new Intent(context, MenuActivity.class);
                menu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(menu);
            }
        });

        this.setCancelable(false);
    }
}