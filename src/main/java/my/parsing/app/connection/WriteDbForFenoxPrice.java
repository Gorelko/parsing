package my.parsing.app.connection;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WriteDbForFenoxPrice {

    public void writeInDB(HashMap<Integer, Object> map) {

        Connection c = null;
        Statement statement = null;
        ResultSet set = null;


        try {
            System.out.println(111);
            c = ConnectionManager.getConnection();
            System.out.println(222);
            statement = c.createStatement();
            System.out.println(333);

            statement.executeUpdate("TRUNCATE TABLE pricefenox");

            for (Map.Entry<Integer, Object> mapEntry : map.entrySet()) {


                String arrFenox[] = Arrays.toString((Object[]) mapEntry.getValue()).split(";");


                String name = "INSERT INTO pricefenox(article, groupfenox, description, price) VALUES(?, ?, ?, ?)";

                PreparedStatement preparedStatement = c.prepareStatement(name);
                preparedStatement.setString(1, arrFenox[0].replaceAll("[\\[\\](){}]", ""));
                preparedStatement.setString(2, arrFenox[1]);
                preparedStatement.setString(3, arrFenox[2]);
                preparedStatement.setString(4, arrFenox[3].replaceAll("[\\[\\](){}]", ""));

                preparedStatement.executeUpdate();

            }


        } catch (
                SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(c, statement, set);
        }

    }
}