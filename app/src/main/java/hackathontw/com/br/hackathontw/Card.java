package hackathontw.com.br.hackathontw;

/**
 * Created by rblb on 4/8/17.
 */

public class Card {
    private int mResDrawableCard;
    private String mText;
    private boolean mAnswer;

    public Card(int resDrawableCard, String text, boolean answer){
        mResDrawableCard = resDrawableCard;
        mText = text;
        mAnswer =  answer;
    }

    public int getResDrawableCard(){
        return mResDrawableCard;
    }

    public String getText(){
        return mText;
    }

    public boolean getAnswer(){
        return mAnswer;
    }
}
