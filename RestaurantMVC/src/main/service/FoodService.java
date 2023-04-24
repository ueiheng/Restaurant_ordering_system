package service;

import util.DBUtil;

import java.util.List;
import java.util.Map;

public class FoodService {

    private DBUtil db;

    public FoodService() {
        db = new DBUtil();
    }

    public  List<Map<String,String>> queryFoods() {
        String sql = "select * from food join foodtype on food.type = foodtype.id";
        List<Map<String,String>> foods = db.getList(sql);
        return foods;
    }


}
