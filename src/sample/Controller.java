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
import sample.database.AppDatabase;
import sample.models.Player;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Controller implements Initializable {
    int res_team_1, res_team_2;
    team_result result = new team_result();
    match_points MP =new match_points();
    String team1_selected, team2_selected;
    boolean getscore = false;
String team1_string=" " ,team2_string=" ";
AppDatabase database = AppDatabase.getInstance();
    @FXML
    private JFXButton start_button;

    @FXML
    private ComboBox<String> team_1;

    @FXML
    private ComboBox<String> team_2;

    @FXML
    private Label team_score_1;

    @FXML
    private Label team_score_2;
    public ObservableList<String> teams;
    @FXML
    private Label team1_goals;

    @FXML
    private Label team2_goals;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> Club = AppDatabase.getInstance().getAllClubs().stream().map(C -> C.getClubName()).collect(Collectors.toList());
        teams = FXCollections.observableArrayList(Club);
        team_1.setItems(teams);
        team_2.setItems(teams);
        System.out.println(Club);

            team_1.valueProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    team1_selected = newValue;
                    System.out.println(team1_selected);

                }
            });
            team_2.valueProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    team2_selected = newValue ;
                    System.out.println(team2_selected);
                }
            });


    }



    public void start_handle() {

        start_button.setDisable(true);


        getscore = ((team1_selected.length() > 0) && (team2_selected.length() > 0));


        if (getscore)
        {
            res_team_1 = result.setTeam();
            res_team_2 = result.setTeam();
            team_score_1.setText("" + res_team_1 + "");
            team_score_2.setText("" + res_team_2 + "");
        }

        List<Player> team1_players = AppDatabase.getInstance().getPlayersByClub(team1_selected);
        List<Player> team2_players = AppDatabase.getInstance().getPlayersByClub(team2_selected);

        System.out.println("Team 1"+team1_players);
        System.out.println("\n\nTeam 2"+team2_players);
       ////  Points for team 1

        for (int i = 0; i < res_team_1; i++)
        {
            int player_index = result.random_int();
            int assist_index = result.random_int();
            Player player = team1_players.get(player_index);
            Player ASS = team1_players.get(assist_index);

            team1_string+= player.getFullName()+ "\n";

            ////////////// goal

            player.goal_inc();
            int  goal_points= MP.match_goals(player.getPosition());
            player.inc_point(goal_points);


            /////////           ASSIST

            int ass_points = MP.match_ass(ASS.getPosition());
            ASS.inc_point(ass_points);
            ASS.ass_inc();
            
        }       //////  Clean Sheet
        if(res_team_2==0)
        {
            // should be for all team players  clean sheet points
            for(Player cleansheet : team1_players )
            {
                cleansheet.inc_point(1);
                cleansheet.inc_cleansheet();
            }
        }



        ///////  Points for team 2

        for (int i = 0; i < res_team_2; i++)
        {

            int player_index = result.random_int();
            int assist_index = result.random_int();
            Player player = team2_players.get(player_index);
            Player ASS = team2_players.get(assist_index);

            team2_string+= player.getFullName()+ "\n";
            ///////////     goal

            player.goal_inc();
            int  goal_points= MP.match_goals(player.getPosition());
            player.inc_point(goal_points);

            //database.update_player(player);
            /////////           ASSIST
            int ass_points = MP.match_ass(ASS.getPosition());
            ASS.inc_point(ass_points);

            ASS.ass_inc();
            System.out.println(ASS.getFullName());

        }
        //////  Clean Sheet
        if (res_team_1==0)
        {
            for(Player cleansheet : team2_players )
            {
                cleansheet.inc_point(1);
                cleansheet.inc_cleansheet();
            }

        }
        System.out.println("Team 1"+team1_players);
        System.out.println("\n\nTeam 2"+team2_players);
        team1_goals.setText(team1_string);
        team2_goals.setText(team2_string);
        System.out.println(team1_string);
        System.out.println(team2_string);

        for(Player save : team1_players)
        {
            database.update_player(save);
        }
        for(Player save : team2_players)
        {
            database.update_player(save);
        }
    }
}
