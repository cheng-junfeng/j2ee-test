package core.service;

import core.db.DBOperate;
import core.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();

        try {
            DBOperate dbOperate = new DBOperate();
            ResultSet rs = dbOperate.showUsers();

            while (rs.next()) {
                String name = rs.getString("username");
                String pwd = rs.getString("password");
                int age = rs.getInt("db");
                User user = new User(name, pwd, age);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
