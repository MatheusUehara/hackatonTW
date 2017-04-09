package hackathontw.com.br.hackathontw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{

    private Integer avatar = 0;
    private TextView nome;
    private ImageButton boyAvatar , girlAvatar;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (TextView) findViewById(R.id.nomeValue);
        boyAvatar = (ImageButton) findViewById(R.id.boyAvatar);
        girlAvatar = (ImageButton) findViewById(R.id.girlAvatar);
        cadastrar = (Button) findViewById(R.id.cadastrar);

        boyAvatar.setOnClickListener(this);
        girlAvatar.setOnClickListener(this);
        cadastrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boyAvatar:
                avatar = 1;
                Log.d("ESCOLHEU O " , " AVATAR 1");
                break;
            case R.id.girlAvatar:
                Log.d("ESCOLHEU O " , " AVATAR 2");
                avatar = 2;
                break;
            case R.id.cadastrar:
                String nomeValue = nome.getText().toString();
                if ( !nomeValue.equals("") && avatar != 0 ){
                    Usuario user = new Usuario();
                    user.setAvatar(avatar);
                    user.setNome(nome.getText().toString());
                    SharedPrefManager.getInstance(getApplicationContext()).saveUserInSharedPref(user);
                    Session.setUsuarioLogado(user);
                    startActivity(new Intent(this, MenuActivity.class));
                    finish();
                }else{
                    if ( nomeValue.equals("") && avatar == 0 ){
                        Toast.makeText(this, "Você precisa digitar seu nome e escolher seu avatar !", Toast.LENGTH_LONG).show();
                    }else  if (nomeValue.equals("")){
                        Toast.makeText(this, "Você precisa digitar seu nome !", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this, "Você precisa escolher seu avatar !", Toast.LENGTH_LONG).show();
                    }
                }
        }
    }
}
