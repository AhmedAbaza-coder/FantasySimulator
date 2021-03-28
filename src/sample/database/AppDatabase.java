package sample.database;

import sample.models.Club;
import sample.models.Match;
import sample.models.Player;
import sample.models.SelectedPlayer;
import sample.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppDatabase implements DAO {

    public static final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String CONNECTION_CONST = "hr";
    public static final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

    private static AppDatabase sInstance;
    private Connection connection;
    private ResultSet set;


    private AppDatabase() {
        try {
            Class.forName(CLASS_NAME);
            connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_CONST, CONNECTION_CONST);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static synchronized AppDatabase getInstance() {
        if (sInstance == null) sInstance = new AppDatabase();

        return sInstance;
    }

//    public Connection getConnection() {
//        return connection;
//    }
//
//
//    public void closeConnection() {
//        try {
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /*
        DAO
     */

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO USERS values (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getSquadName());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getGender());
            set = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getUser(String username) {
        User user = new User();
        String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            set = statement.executeQuery();
            while (set.next()) {
                user.setSquadName(set.getString(1));
                user.setFirstName(set.getString(2));
                user.setLastName(set.getString(3));
                user.setUsername(set.getString(4));
                user.setPassword(set.getString(5));
                user.setGender(set.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try {
            Statement statement = connection.createStatement();
            set = statement.executeQuery(sql);
            while (set.next()) {
                User user = new User();
                user.setSquadName(set.getString(1));
                user.setFirstName(set.getString(2));
                user.setLastName(set.getString(3));
                user.setUsername(set.getString(4));
                user.setPassword(set.getString(5));
                user.setGender(set.getString(6));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }


    @Override
    public List<Club> getAllClubs() {
        List<Club> clubs = new ArrayList<>();
        String sql = "SELECT * FROM CLUB";
        try {
            Statement statement = connection.createStatement();
            set = statement.executeQuery(sql);
            while (set.next()) {
                Club club = new Club(set.getString(2), set.getString(1), set.getString(3));
                clubs.add(club);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clubs;
    }

    @Override
    public Player getPlayer(String id) {
        Player player = null;
        String sql = "SELECT * FROM PLAYERS WHERE playerpicid = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            set = statement.executeQuery();
            while (set.next()) {
                boolean selection = set.getString(16) == "TRUE" ? true : false;
                player = new Player(set.getString(1), set.getString(2), set.getString(3),
                        set.getString(4), set.getString(5), set.getInt(6), set.getString(7),
                        set.getInt(8), set.getInt(9), set.getInt(10), set.getInt(11),
                        set.getInt(12), set.getFloat(13), selection, set.getString(14));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM PLAYERS";
        try {
            Statement statement = connection.prepareStatement(sql);
            set = statement.executeQuery(sql);
            while (set.next()) {
                boolean selection = set.getString(16) == "TRUE" ? true : false;
                Player player = new Player(set.getString(1), set.getString(2), set.getString(3),
                        set.getString(4), set.getString(5), set.getInt(6), set.getString(7),
                        set.getInt(8), set.getInt(9), set.getInt(10), set.getInt(11),
                        set.getInt(12), set.getFloat(13), selection, set.getString(14));

                players.add(player);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return players;
    }

    @Override
    public List<Player> getPlayersByPosition(String position) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM PLAYERS WHERE position = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, position);
            set = statement.executeQuery();
            while (set.next()) {
                boolean selection = set.getString(16) == "TRUE" ? true : false;
                Player player = new Player(set.getString(1), set.getString(2), set.getString(3),
                        set.getString(4), set.getString(5), set.getInt(6), set.getString(7),
                        set.getInt(8), set.getInt(9), set.getInt(10), set.getInt(11),
                        set.getInt(12), set.getFloat(13), selection, set.getString(14));

                players.add(player);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return players;
    }

    @Override
    public List<Player> getPlayersByClub(String clubName) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM PLAYERS WHERE CLUBNAME = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clubName);
            set = statement.executeQuery();
            while (set.next()) {
                boolean selection = set.getString(16) == "TRUE" ? true : false;
                Player player = new Player(set.getString(1), set.getString(2), set.getString(3),
                        set.getString(4), set.getString(5), set.getInt(6), set.getString(7),
                        set.getInt(8), set.getInt(9), set.getInt(10), set.getInt(11),
                        set.getInt(12), set.getFloat(13), selection, set.getString(14));

//                player.setClubObject(set.getString(14));
                players.add(player);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return players;
    }

    @Override
    public void confirmUser(String username, List<Player> selectedPlayers) {
        for (Player player : selectedPlayers) {
            String sql = "INSERT INTO SelectedPlayers values (?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, player.getPictureId());
                set = statement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void confirmSquadName(String username, String squadName) {

        String sql = "UPDATE users SET squadname = ? WHERE email = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, squadName);
            statement.setString(2, username);
            set = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<SelectedPlayer> getSelectedPlayers() {
        List<SelectedPlayer> players = new ArrayList<>();

        String sql = "select selectedplayers.* , players.points from selectedplayers, players where playername = playerpicid";

        try {
            Statement statement = connection.createStatement();
            set = statement.executeQuery(sql);
            while (set.next()) {
                boolean isCaptain = set.getString("CAPTAIN").equalsIgnoreCase("TRUE") ? true : false;
                boolean isStarting = set.getString("STARTING").equalsIgnoreCase("TRUE") ? true : false;
                SelectedPlayer selectedPlayer = new SelectedPlayer(set.getString("USERNAME"), set.getString("PLAYERNAME")
                        , isStarting, isCaptain, set.getInt("POINTS"));
                players.add(selectedPlayer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return players;
    }

    public void update_player(Player gg) {
        String sql = "UPDATE PLAYERS SET goals = ? , assists= ? , cleansheet=? , points = ? WHERE playerpicid=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, gg.getGoals());
            statement.setInt(2, gg.getAssists());
            statement.setInt(3, gg.getCleanSheet());
            statement.setInt(4, gg.getPoints());
            statement.setString(5, gg.getPictureId());
            set = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateUserPoints(String username, int points){
        String sql = "UPDATE USERS SET points = ? WHERE email =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, points);
            statement.setString(2, username);

            set = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertMatch(Match match){
        String sql = "INSERT INTO matches (team1, team2, result) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, match.getTeam1());
            statement.setString(2, match.getTeam2());
            statement.setString(3, match.getResult());
            ResultSet set = statement.executeQuery();
            set.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

