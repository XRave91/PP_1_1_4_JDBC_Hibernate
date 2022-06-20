package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;


public class Main {
    static UserServiceImpl srv = new UserServiceImpl();
    public static void main(String[] args) {
        srv.createUsersTable();
        srv.saveUser("dimon","lastdimon", (byte) 15);
        System.out.println("User с именем – dimon добавлен в базу данных");
        srv.saveUser("egor","poplevailo", (byte) 115);
        System.out.println("User с именем – egor добавлен в базу данных");
        srv.saveUser("biba","lupin", (byte) 45);
        System.out.println("User с именем – biba добавлен в базу данных");
        srv.saveUser("boba","pupin", (byte) 35);
        System.out.println("User с именем – boba добавлен в базу данных");
        List<User> lst =  srv.getAllUsers();
        if (lst != null) {
            for (User u : lst) {
                System.out.println(u.toString());
            }
        }
        srv.dropUsersTable();
    }
}
