package core.db;

import core.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperate {
    Connection conn = DBConnection.getConnInstance();

    public void addUser(User user) throws SQLException {
        PreparedStatement stmt;
        stmt = conn.prepareStatement("INSERT INTO user VALUES(?, ?, ?)");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getPwd());
        stmt.setInt(3, user.getAge());

        stmt.executeUpdate();
        stmt.close();
    }

    public ResultSet showUsers() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS");
        ResultSet rs = statement.executeQuery();
        return rs;
    }
}
