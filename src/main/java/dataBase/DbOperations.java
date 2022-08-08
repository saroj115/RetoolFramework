package dataBase;

import java.sql.*;
import java.util.logging.Logger;

// function to connect to db;
public class DbOperations {
    public String myFunction="";
    public Connection getConnection(String environment){
        myFunction="getConnection";
        try{
            String dbClass="com.mysql.jdbc.Driver";
            String dbUrl=null;
            String username=null;
            String password=null;
            if(environment.equalsIgnoreCase("Staging")){
                dbUrl = "jdbc:mysql://staging-db.intranet.parcelpoint.com.au:3306/parcelpoint_prod";
                username="rootdb";
                password="notroot123";
            }else if(environment.equalsIgnoreCase("Prod")){
                dbUrl = "jdbc:mysql://prod-db.intranet.parcelpoint.com.au:3306/parcelpoint_prod";
                username="rootdb";
                password="650a67aef6";
            }else{
                dbUrl = "jdbc:mysql://"+"10.0.21.225"+":3306/parcelpoint_staging";
                username="rootdb";
                password="notroot";
            }
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection (dbUrl,username,password);
            return con;

        }catch (ClassNotFoundException e ) {
            e.printStackTrace();
        } catch (  SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    // to execute query
    public ResultSet getResultSet(Connection con, String query){
        myFunction="getResultSet";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // to close the connection
    public void closeConnection(Connection con){
        myFunction="closeConnection";
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
