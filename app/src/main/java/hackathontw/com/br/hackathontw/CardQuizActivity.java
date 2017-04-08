package hackathontw.com.br.hackathontw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

/**
 * Created by rblb on 4/8/17.
 */

public class CardQuizActivity extends AppCompatActivity {
    private CardAdapter mAdapter;
    private ArrayList<Card> mCardList;
    private SwipeFlingAdapterView mFlingContainer;

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
                if(card.getAnswer()){
                    //show dialog
                }

            }

            @Override
            public void onRightCardExit(Object o) {
                mCardList.remove(0);
                mAdapter.notifyDataSetChanged();
                Card card = (Card) o;
                if(card.getAnswer()){
                    //show dialog
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

        mFlingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener(){
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
        mCardList.add(new Card(R.drawable.card1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dignissim aliquam lectus nec aliquet. Morbi sagittis auctor nibh, dapibus suscipit nisl interdum nec. Phasellus et sapien ut turpis luctus venenatis vulputate vel ex.", true));
        mCardList.add(new Card(R.drawable.card2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dignissim aliquam lectus nec aliquet. Morbi sagittis auctor nibh, dapibus suscipit nisl interdum nec. Phasellus et sapien ut turpis luctus venenatis vulputate vel ex.", false));
        mCardList.add(new Card(R.drawable.card3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dignissim aliquam lectus nec aliquet. Morbi sagittis auctor nibh, dapibus suscipit nisl interdum nec. Phasellus et sapien ut turpis luctus venenatis vulputate vel ex.", true));
        mCardList.add(new Card(R.drawable.card4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dignissim aliquam lectus nec aliquet. Morbi sagittis auctor nibh, dapibus suscipit nisl interdum nec. Phasellus et sapien ut turpis luctus venenatis vulputate vel ex.", false));
        mCardList.add(new Card(R.drawable.card5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dignissim aliquam lectus nec aliquet. Morbi sagittis auctor nibh, dapibus suscipit nisl interdum nec. Phasellus et sapien ut turpis luctus venenatis vulputate vel ex.", true));
    }
}
