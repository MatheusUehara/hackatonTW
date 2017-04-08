package hackathontw.com.br.hackathontw;

/**
 * Created by Uehara on 08/04/2017.
 */

public class Level {

    private Integer level;
    private Integer score;

    public Level(){}

    public Level(Integer level, Integer score){
        this.level = level;
        this.score = score;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
