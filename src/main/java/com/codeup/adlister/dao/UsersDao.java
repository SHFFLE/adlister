package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class UsersDao implements Users {
    private Connection connection = null;


    public UsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ?;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()){
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return user;
            } else {
                return null;
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public Long insert(User user){
        try {
            PreparedStatement stmt = createInsertQuery(user);
            stmt.executeUpdate();
            Long userID = (DaoFactory.getUsersDao().findByUsername(user.getUsername()).getId());
            return userID;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
    private PreparedStatement createInsertQuery(User user) throws SQLException{
        String template = "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(template);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());
        return stmt;
    }
}
