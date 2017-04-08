package hackathontw.com.br.hackathontw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton level1,level2,level3,level4,level5,level6,level7,level8,level9;
    private ArrayList<ImageButton> levels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        level1 = (ImageButton) findViewById(R.id.level1);
        level2 = (ImageButton) findViewById(R.id.level2);
        level3 = (ImageButton) findViewById(R.id.level3);
        level4 = (ImageButton) findViewById(R.id.level4);
        level5 = (ImageButton) findViewById(R.id.level5);
        level6 = (ImageButton) findViewById(R.id.level6);
        level7 = (ImageButton) findViewById(R.id.level7);
        level8 = (ImageButton) findViewById(R.id.level8);
        level9 = (ImageButton) findViewById(R.id.level9);

        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        levels.add(level7);
        levels.add(level8);
        levels.add(level9);

        Usuario objetoUsuario = new Usuario();
        ArrayList<Level> levelsUsuario = objetoUsuario.getLevels();
        for (int i = 0 ; i < levelsUsuario.size() ; i++){

            if ( levelsUsuario.get(i).getScore() != 0 ){

                levels.get(i).setOnClickListener(this);

                if (levelsUsuario.get(i).getScore() == 1 ){
                    levels.get(i).setImageResource(R.mipmap.ic_launcher_round);
                    //levels.get(i).setImageResource(R.drawable.oneStar);
                }
                else if (levelsUsuario.get(i).getScore() == 2 ){
                    levels.get(i).setImageResource(R.mipmap.ic_launcher_round);
                    //levels.get(i).setImageResource(R.drawable.twoStars);
                }
                else{
                    levels.get(i).setImageResource(R.mipmap.ic_launcher_round);
                    //levels.get(i).setImageResource(R.drawable.threeStars);
                }
            }else{
                levels.get(i).setImageResource(R.mipmap.ic_launcher_round);
                //levels.get(i).setImageResource(R.drawable.locked);
            }
        }
    }

    @Override
    public void onClick(View v) {
        /*
        Intent history = new Intent(this, HistoryChallenger.class);
        switch (v.getId()){
            case R.id.level1:
                history.putExtra("level", 1);
                startActivity(history);
                finish();
                break;
            case R.id.level2:
                history.putExtra("level", 2);
                startActivity(history);
                finish();
                break;
            case R.id.level3:
                history.putExtra("level", 3);
                startActivity(history);
                finish();
                break;
            case R.id.level4:
                history.putExtra("level", 4);
                startActivity(history);
                finish();
                break;
            case R.id.level5:
                history.putExtra("level", 5);
                startActivity(history);
                finish();
                break;
            case R.id.level6:
                history.putExtra("level", 6);
                startActivity(history);
                finish();
                break;
            case R.id.level7:
                history.putExtra("level", 7);
                startActivity(history);
                finish();
                break;
            case R.id.level8:
                history.putExtra("level", 8);
                startActivity(history);
                finish();
                break;
            case R.id.level9:
                history.putExtra("level", 9);
                startActivity(history);
                finish();
                break;
        }
        */

        switch (v.getId()){
            case R.id.level1:
                Toast.makeText(this,"level 1", Toast.LENGTH_LONG).show();
                break;
            case R.id.level2:
                Toast.makeText(this,"level 2", Toast.LENGTH_LONG).show();
                break;
            case R.id.level3:
                Toast.makeText(this,"level 3", Toast.LENGTH_LONG).show();
                break;
            case R.id.level4:
                Toast.makeText(this,"level 4", Toast.LENGTH_LONG).show();
                break;
            case R.id.level5:
                Toast.makeText(this,"level 5", Toast.LENGTH_LONG).show();
                break;
            case R.id.level6:
                Toast.makeText(this,"level 6", Toast.LENGTH_LONG).show();
                break;
            case R.id.level7:
                Toast.makeText(this,"level 7", Toast.LENGTH_LONG).show();
                break;
            case R.id.level8:
                Toast.makeText(this,"level 8", Toast.LENGTH_LONG).show();
                break;
            case R.id.level9:
                Toast.makeText(this,"level 9", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
