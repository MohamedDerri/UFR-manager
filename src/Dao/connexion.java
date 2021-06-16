package Dao;

import com.company.Etudiant;

import java.sql.*;
import java.util.ArrayList;

public class connexion {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Connection getConnect() {
        return this.connect;
    }

    public void readDataBase(ArrayList<Etudiant> list) {

        try {
            Class.forName("mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException c) {
            c.getStackTrace();
        }

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "root", "saidderri");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from javaDB.etudiant");
            while (resultSet.next()) {
                list.add(new Etudiant(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("email"),
                        resultSet.getString("password"), resultSet.getString("role")));
                 /*System.out.println(resultSet.getInt("id") + " | " + resultSet.getString("nom") + " | " +
                 resultSet.getString("email") + " | " + resultSet.getString("password"));*/
            }
        }
        catch (SQLException e) {
            e.getStackTrace();
        }
    }
}