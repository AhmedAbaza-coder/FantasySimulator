package sample;
import java.util.Random;

public class team_result {

    Random rand = new Random();

    public int setTeam() {

        int team = rand.nextInt(6);
        return team;
    }
    public boolean draw_check(int x,int y)
    {
        if (x==y)
        {
            return true;
        }
        else return false;
    }
    public void add_points(int x,int y)
    {
        // team point +3

    }
    public int random_int()
    {
        return rand.nextInt(11);
    }

}
