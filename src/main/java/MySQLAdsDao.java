import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads{
    Connection connection;
    Statement statement;

    public MySQLAdsDao() throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUser(),
                Config.getPassword()
        );
        this.statement = connection.createStatement();
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        ResultSet rs;
        try {
            rs = statement.executeQuery("SELECT * FROM ads ORDER BY id");
            while(rs.next()){
                Ad ad = new Ad(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
            return ads;
        } catch (SQLException e) {
            return null;
        }
    }
    @Override
    public Long insert(Ad ad) throws SQLException {
        String query = "INSERT INTO ads(user_id, title, description) VALUES (" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "');";
        return (long) statement.executeUpdate(query, statement.RETURN_GENERATED_KEYS);
    }
}
