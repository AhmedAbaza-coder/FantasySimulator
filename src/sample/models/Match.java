package sample.models;

public class Match {
    private String team1, team2, result;

    public Match() {
    }

    public Match(String team1, String team2, String result) {
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
