package sample.models;

public class SelectedPlayer {

    String username,playerName;
    Boolean isStarting, isCaptain;
    int points;

    public SelectedPlayer() {
    }

    public SelectedPlayer(String username, String playerName, Boolean isStarting, Boolean isCaptain, int points) {
        this.username = username;
        this.playerName = playerName;
        this.isStarting = isStarting;
        this.isCaptain = isCaptain;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Boolean getStarting() {
        return isStarting;
    }

    public void setStarting(Boolean starting) {
        isStarting = starting;
    }

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return username + " " + playerName + " " + points;
    }
}
