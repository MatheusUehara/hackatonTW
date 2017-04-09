package hackathontw.com.br.hackathontw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by rblb on 4/8/17.
 */

public class CardQuizActivity extends AppCompatActivity {
    private CardAdapter mAdapter;
    private ArrayList<Card> mCardList;
    private SwipeFlingAdapterView mFlingContainer;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_quiz);

        populateCardList();

        mFlingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipe_frame);

        mAdapter = new CardAdapter(this, mCardList);
        mFlingContainer.setAdapter(mAdapter);
        mFlingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
            }

            @Override
            public void onLeftCardExit(Object o) {
                mCardList.remove(0);
                mAdapter.notifyDataSetChanged();
                Card card = (Card) o;
                FeedbackDialog dialog;
                if (card.getAnswer()) {
                    dialog = new FeedbackDialog(CardQuizActivity.this, false);
                    dialog.show();
                } else {
                    mScore += 1;
                    dialog = new FeedbackDialog(CardQuizActivity.this, true);
                    dialog.show();
                }
                if (mCardList.isEmpty()) {
                    Toast.makeText(CardQuizActivity.this, "Score: " + mScore, Toast.LENGTH_SHORT).show();
                    //TODO:finish level
                }
            }


            @Override
            public void onRightCardExit(Object o) {
                mCardList.remove(0);
                mAdapter.notifyDataSetChanged();
                Card card = (Card) o;
                FeedbackDialog dialog;
                if (card.getAnswer()) {
                    mScore += 1;
                    dialog = new FeedbackDialog(CardQuizActivity.this, true);
                    dialog.show();
                } else {
                    dialog = new FeedbackDialog(CardQuizActivity.this, false);
                    dialog.show();
                }
                if (mCardList.isEmpty()) {
                    Toast.makeText(CardQuizActivity.this, "Score: " + mScore, Toast.LENGTH_SHORT).show();
                    //TODO: finish level
                }
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
            }

            @Override
            public void onScroll(float scrollPercent) {
                View view = mFlingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_left).setAlpha(scrollPercent < 0 ? -scrollPercent : 0);
                view.findViewById(R.id.item_right).setAlpha(scrollPercent > 0 ? scrollPercent : 0);
            }
        });

        mFlingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                View view = mFlingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                mAdapter.notifyDataSetChanged();
            }
        });

    }

    private void populateCardList() {
        mCardList = new ArrayList<>();
        mCardList.add(new Card(R.drawable.desafio1_card1, "Meninas não podem brincar com brinquedos de meninos!", false));
        mCardList.add(new Card(R.drawable.desafio1_card2, "Meninos e meninas não podem gostas das mesmas coisas!", false));
        mCardList.add(new Card(R.drawable.desafio1_card3, "Meninas podem gostar de azul!", true));
        mCardList.add(new Card(R.drawable.desafio1_card4, "Meninas podem jogar bola!", true));
        mCardList.add(new Card(R.drawable.desafio1_card5, "Meninos podem brincar com bonecas!", true));
        mCardList.add(new Card(R.drawable.desafio1_card6, "Meninos podem brincar com coisas de meninas e vice-versa!", true));

        long seed = System.nanoTime();
        Collections.shuffle(mCardList, new Random(seed));
    }
}
