package my.parsing.app.connection;

import java.sql.*;
import java.util.List;

public class WriteInDb {

    public void writeInDB(List<List<String>> list) {

        Connection c = null;
        Statement statement = null;
        ResultSet set = null;


        try {

            c = ConnectionManager.getConnection();
            statement = c.createStatement();


            for (List<String> product : list) {

                System.out.println(product);


                String name = "INSERT INTO amtel_price(Brend1, Article_brend1, Brend2, Article_brend2, description_art, Count_dirty, Price_dirty, Stock, Date_swap) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = c.prepareStatement(name);
                preparedStatement.setString(1, product.get(0));
                preparedStatement.setString(2, product.get(1));
                preparedStatement.setString(3, product.get(2));
                preparedStatement.setString(4, product.get(3));
                preparedStatement.setString(5, product.get(4));
                preparedStatement.setString(6, product.get(5));
                preparedStatement.setString(7, product.get(6));
                preparedStatement.setString(8, product.get(7));
                preparedStatement.setString(9, product.get(8));
                preparedStatement.executeUpdate();


            }


        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(c, statement, set);
        }

    }
}