package sample;

import com.jfoenix.controls.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.database.AppDatabase;
import sample.models.Match;
import sample.models.Player;
import sample.models.SelectedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Controller implements Initializable {

    int res_team_1, res_team_2;
    team_result result = new team_result();
    match_points MP = new match_points();
    String team1_selected, team2_selected;
    boolean getscore = false;
    String team1_string_goals = " ", team2_string_goals = " ";
    AppDatabase database = AppDatabase.getInstance();
    String team1_string_assisst = "", team2_string_assisst = "";

    @FXML
    private JFXButton start_button;

    @FXML
    private ComboBox<String> team_1, team_2;

    @FXML
    private Label team_score_1, team_score_2;

    public ObservableList<String> teams;

    @FXML
    private Label team1_goals, team2_goals;

    @FXML
    private ImageView team1logo, team2logo;

    @FXML
    private Label team1_assisst;

    @FXML
    private Label team2_assisst;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> Club = AppDatabase.getInstance().getAllClubs().stream().map(C -> C.getClubName()).collect(Collectors.toList());
        teams = FXCollections.observableArrayList(Club);
        team_1.setItems(teams);
        team_2.setItems(teams);
        team1_goals.setVisible(false);
        team2_goals.setVisible(false);
        team_score_1.setVisible(false);
        team_score_2.setVisible(false);
        System.out.println(Club);

        team_1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                team1_selected = newValue;
                switch (team1_selected) {
                    case "Liverpool":

                        InputStream streamLogo = null;
                        try {
                            streamLogo = new FileInputStream("src/Images/Liverpool.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo = new Image(streamLogo);
                        team1logo.setImage(imageLogo);
                        break;

                    case "Chelsea":

                        InputStream streamLogo2 = null;
                        try {
                            streamLogo2 = new FileInputStream("src/Images/Chelsea.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo2 = new Image(streamLogo2);
                        team1logo.setImage(imageLogo2);
                        break;

                    case "Tottenham":

                        InputStream streamLogo3 = null;
                        try {
                            streamLogo3 = new FileInputStream("src/Images/Tottenham.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo3 = new Image(streamLogo3);
                        team1logo.setImage(imageLogo3);
                        break;

                    case "Manchester United":
                        InputStream streamLogo4 = null;
                        try {
                            streamLogo4 = new FileInputStream("src/Images/ManchesterUnited.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo4 = new Image(streamLogo4);
                        team1logo.setImage(imageLogo4);
                        break;

                    case "Manchester City":
                        InputStream streamLogo5 = null;
                        try {
                            streamLogo5 = new FileInputStream("src/Images/ManchesterCity.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo5 = new Image(streamLogo5);
                        team1logo.setImage(imageLogo5);
                        break;

                    case "Arsenal":
                        InputStream streamLogo6 = null;
                        try {
                            streamLogo6 = new FileInputStream("src/Images/Arsenal.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo6 = new Image(streamLogo6);
                        team1logo.setImage(imageLogo6);
                        break;
                }
                System.out.println(team1_selected);

            }
        });
        team_2.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                team2_selected = newValue;
                switch (team2_selected) {
                    case "Liverpool":

                        InputStream streamLogo = null;
                        try {
                            streamLogo = new FileInputStream("src/Images/Liverpool.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo = new Image(streamLogo);
                        team2logo.setImage(imageLogo);
                        break;

                    case "Chelsea":

                        InputStream streamLogo2 = null;
                        try {
                            streamLogo2 = new FileInputStream("src/Images/Chelsea.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo2 = new Image(streamLogo2);
                        team2logo.setImage(imageLogo2);
                        break;

                    case "Tottenham":

                        InputStream streamLogo3 = null;
                        try {
                            streamLogo3 = new FileInputStream("src/Images/Tottenham.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo3 = new Image(streamLogo3);
                        team2logo.setImage(imageLogo3);
                        break;

                    case "Manchester United":
                        InputStream streamLogo4 = null;
                        try {
                            streamLogo4 = new FileInputStream("src/Images/ManchesterUnited.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo4 = new Image(streamLogo4);
                        team2logo.setImage(imageLogo4);
                        break;

                    case "Manchester City":
                        InputStream streamLogo5 = null;
                        try {
                            streamLogo5 = new FileInputStream("src/Images/ManchesterCity.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo5 = new Image(streamLogo5);
                        team2logo.setImage(imageLogo5);
                        break;

                    case "Arsenal":
                        InputStream streamLogo6 = null;
                        try {
                            streamLogo6 = new FileInputStream("src/Images/Arsenal.png");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageLogo6 = new Image(streamLogo6);
                        team2logo.setImage(imageLogo6);
                        break;
                }
                System.out.println(team2_selected);
            }
        });


    }


    @FXML
    public void start_handle() {

        start_button.setDisable(true);


        getscore = ((team1_selected.length() > 0) && (team2_selected.length() > 0));


        if (getscore) {
            res_team_1 = result.setTeam();
            res_team_2 = result.setTeam();
            team_score_1.setText("" + res_team_1 + "");
            team_score_2.setText("" + res_team_2 + "");
        }

        List<Player> team1_players = AppDatabase.getInstance().getPlayersByClub(team1_selected);
        List<Player> team2_players = AppDatabase.getInstance().getPlayersByClub(team2_selected);


        ////  Points for team 1

        for (int i = 0; i < res_team_1; i++) {
            int player_index = result.random_int();
            int assist_index = result.random_int();
            Player player = team1_players.get(player_index);
            Player assist = team1_players.get(assist_index);

            team1_string_goals += player.getFullName() + "\n";

            ////////////// goal

            player.goal_inc();
            int goal_points = MP.match_goals(player.getPosition());
            player.inc_point(goal_points);


            /////////           ASSIST

            int ass_points = MP.match_ass(assist.getPosition());
            assist.inc_point(ass_points);
            assist.ass_inc();
            team1_string_assisst += assist.getFullName() + "\n";

        }       //////  Clean Sheet
        if (res_team_2 == 0) {
            // should be for all team players  clean sheet points
            for (Player cleansheet : team1_players) {
                cleansheet.inc_point(1);
                cleansheet.inc_cleansheet();
            }
        }


        ///////  Points for team 2

        for (int i = 0; i < res_team_2; i++) {

            int player_index = result.random_int();
            int assist_index = result.random_int();
            Player player = team2_players.get(player_index);
            Player assisst = team2_players.get(assist_index);

            team2_string_goals += player.getFullName() + "\n";
            ///////////     goal

            player.goal_inc();
            int goal_points = MP.match_goals(player.getPosition());
            player.inc_point(goal_points);

            //database.update_player(player);
            /////////           ASSIST
            int ass_points = MP.match_ass(assisst.getPosition());
            assisst.inc_point(ass_points);
            team2_string_assisst += assisst.getFullName() + "\n";
            assisst.ass_inc();


        }
        //////  Clean Sheet
        if (res_team_1 == 0) {
            for (Player cleansheet : team2_players) {
                cleansheet.inc_point(1);
                cleansheet.inc_cleansheet();
            }

        }

        team1_goals.setText(team1_string_goals);
        team2_goals.setText(team2_string_goals);
        team1_assisst.setText(team1_string_assisst);
        team2_assisst.setText(team2_string_assisst);

        //TODO
        System.out.println(team1_string_goals);
        System.out.println(team2_string_goals);

        team1_goals.setVisible(true);
        team2_goals.setVisible(true);
        team_score_1.setVisible(true);
        team_score_2.setVisible(true);

        List<SelectedPlayer> selectedPlayers = AppDatabase.getInstance().getSelectedPlayers();


        System.out.println("ss 1  :  " + team1_players.size());
        System.out.println("ss 2  :  " + team1_players.size());
        team1_players = team1_players.stream().filter(player -> {
            for (SelectedPlayer selected : selectedPlayers) {
                if (player.getPictureId().equalsIgnoreCase(selected.getPlayerName())) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());

        team2_players = team2_players.stream().filter(player -> {
            for (SelectedPlayer selected : selectedPlayers) {
                if (player.getPictureId().equalsIgnoreCase(selected.getPlayerName())) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());

        System.out.println("ss 1  :  " + team1_players.size() + team1_players);
        System.out.println("ss 2  :  " + team2_players.size() + team2_players);

        for (Player save : team1_players) {
            database.update_player(save);
        }
        for (Player save : team2_players) {
            database.update_player(save);
        }

        updateUsersPoints(selectedPlayers);
        insertMatch(new Match(team1_selected,team2_selected,res_team_1 + " - " + res_team_2));
    }

    private void insertMatch(Match match) {
        AppDatabase.getInstance().insertMatch(match);
        System.out.println(match);
    }

    private void updateUsersPoints(List<SelectedPlayer> selectedPlayers) {
        Map<String, Integer> userToPlayers =
                selectedPlayers.stream().collect(
                        Collectors.groupingBy(SelectedPlayer::getUsername, Collectors.summingInt(SelectedPlayer::getPoints)));

        userToPlayers.forEach((s, integer) -> {
            AppDatabase.getInstance().updateUserPoints(s, integer);
        });
    }
}
