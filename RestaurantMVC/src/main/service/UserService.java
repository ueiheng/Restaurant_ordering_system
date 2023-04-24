package service;

import util.DBUtil;

import java.util.List;
import java.util.Map;

public class UserService {
    private DBUtil db;

    public UserService() {
        db = new DBUtil();
    }

    public boolean login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        List<Map<String,String>> users = db.getList(sql, username, password);
        if (users.size() > 0) {
            return true;
        }
        return false;
    }

}
