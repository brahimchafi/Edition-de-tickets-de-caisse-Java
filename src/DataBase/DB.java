package DataBase;

import java.sql.*;

public class DB {
    private String url = "jdbc:mysql://localhost:3306/supermarche";
    private String username = "root";
    private String password = "mysql";

    private Connection connection ;
    private static DB instance = new DB();

    private DB (){
        try{
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection réussie à la base de donnée !");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static DB getInstance(){
        return instance;
    }

    public Connection getConnexionDBMysql(){
        return this.connection;
    }

}
