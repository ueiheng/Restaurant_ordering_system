package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBUtil {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection con;
    private PreparedStatement pstmt;
    public static final long PAGE_REC_NUM = 4;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //构造方法，定义驱动程序连接用户名和密码信息
    public DBUtil(){
        driver="com.mysql.cj.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/mealsystem?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
        username="root";
        password="123456";
    }

    //加载驱动程序，得到连接对象

    private void init(){
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void setParams(String[] params){
        if(params!=null){
            for(int i=0;i<params.length;i++){
                try {
                    pstmt.setString(i+1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void closed(){
        if(pstmt!=null){
            try{
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(con!=null){
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public int update(String sql , String[] params){
        int result = 0;
        init();
        try{
            pstmt = con.prepareStatement(sql);
            setParams(params);
            result = pstmt.executeUpdate();
                }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            closed();
        }
        return result;
    }


    public List<Map<String, String>> getList(String sql) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Map<String, String>> getList(String sql, String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }
}
