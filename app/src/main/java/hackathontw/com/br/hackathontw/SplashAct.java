package hackathontw.com.br.hackathontw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Uehara on 08/04/2017.
 */
public class SplashAct extends AppCompatActivity implements Runnable {

    private final static int SHOW_TIME = 1300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        Handler handler = new Handler();
        handler.postDelayed(this, SHOW_TIME);
    }

    @Override
    public void run() {
        Usuario user = SharedPrefManager.getInstance(getApplicationContext()).getUserFromSharedPref();
        if ( user != null ) {
            Session.setUsuarioLogado(user);
            startActivity(new Intent(this, MenuActivity.class));
            finish();
        }else{
            startActivity(new Intent(this, CadastroActivity.class));
            finish();
        }
    }

}