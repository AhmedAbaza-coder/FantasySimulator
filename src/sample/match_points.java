package sample;

public class match_points {


    public int match_goals(String position)
    {
        if(position.equals("FW"))
        {
           return 3;
        }
        else if (position.equals("MID"))
        {
            return 4;
        }
        else if (position.equals("DEF"))
        {
            return 7;
        }
        else if (position.equals("GK")) {
        return 10;
        }

        else return 0;
    }
    public int match_ass(String position)
    {
        if(position.equals("FW"))
        {
            return 4;
        }
        else if (position.equals("MID"))
        {
            return 3;
        }
        else if (position.equals("DEF"))
        {
            return 5;
        }
        else if (position.equals("GK")) {
            return 7;
        }
        else return 0;
    }
    public int clean_sheet(String position)
    {
        if(position.equals("FW"))
        {
            return 1;
        }
        else if (position.equals("MID"))
        {
            return 2;
        }
        else if (position.equals("DEF"))
        {
            return 4;
        }
        else if (position.equals("GK")) {
            return 3;
        }
        else return 0;
    }
}
