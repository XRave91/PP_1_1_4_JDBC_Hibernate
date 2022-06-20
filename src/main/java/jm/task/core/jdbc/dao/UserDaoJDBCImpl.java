package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import  jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection conn;

    public UserDaoJDBCImpl() {

    }
    public void setConn(){
        try {
            conn = new Util().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUsersTable() {
        try {
            conn.createStatement().execute("CREATE TABLE if not exists Users (ID int PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "lastname VARCHAR(255)," +
                    "age TINYINT );");
        } catch (SQLException e) {

        }
    }

    public void dropUsersTable() {
        try {
            conn.prepareStatement("drop table Users;").execute();
        } catch (SQLException e) {

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Users (name , lastname, age) VALUES (?,?,?)");
            stm.setString(1,name);
            stm.setString(2,lastName);
            stm.setInt(3, age);
            stm.execute();
        } catch (SQLException e) {

        }
    }

    public void removeUserById(long id) {
        try {
            conn.prepareStatement("delete from Users where ID=" + id + ";").execute();
        } catch (SQLException e) {

        }
    }

    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        try {
            ResultSet result = conn.createStatement().executeQuery("Select * from Users;");
            while(result.next()){
                User tmpUser =new User(result.getString("name"),
                        result.getString("lastname"),
                        result.getByte("age"));
                tmpUser.setId(result.getLong("ID"));
                resultList.add(tmpUser);
            }
            return resultList ;
        } catch (SQLException e) {

        }

        return null;
    }

    public void cleanUsersTable() {
        try {
            conn.prepareStatement("TRUNCATE TABLE Users;").execute();
        } catch (SQLException e) {

        }
    }
}
