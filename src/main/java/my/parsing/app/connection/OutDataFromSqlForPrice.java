package my.parsing.app.connection;

import my.parsing.app.dto.PriceFenoxDto;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OutDataFromSqlForPrice {
    public static List<PriceFenoxDto> outDataFromSql(HttpServletRequest request, List<String> listFilterData) {

        String numberPage = request.getParameter("listCountPage");
        int x1;
        try {
            x1 = (Integer.parseInt(numberPage) - 1) * 500;
        } catch (Exception e) {
            x1 = 0;
        }


        Connection c = null;
        Statement statement = null;
        ResultSet set = null;

        List<PriceFenoxDto> listAllOnDispley = new ArrayList<>();

        try {

            c = ConnectionManager.getConnection();
            statement = c.createStatement();


            set = statement.executeQuery("SELECT id FROM training_db.pricefenox group by id");
            List<String> listId = new ArrayList<>();
            while (set.next()) {
                listId.add(set.getString(1));
            }

            request.setAttribute("listId", listId);


            set = statement.executeQuery("SELECT article FROM training_db.pricefenox group by article");
            List<String> listArtFenox = new ArrayList<>();
            while (set.next()) {
                listArtFenox.add(set.getString(1));
            }

            request.setAttribute("listArtFenox", listArtFenox);

            set = statement.executeQuery("SELECT groupfenox FROM training_db.pricefenox group by groupfenox");
            List<String> listGroupFenox = new ArrayList<>();
            while (set.next()) {
                listGroupFenox.add(set.getString(1));
            }

            request.setAttribute("listGroupFenox", listGroupFenox);

            set = statement.executeQuery("SELECT description FROM training_db.pricefenox group by description");
            List<String> listDescriptFenox = new ArrayList<>();
            while (set.next()) {
                listDescriptFenox.add(set.getString(1));
            }

            request.setAttribute("listDescriptFenox", listDescriptFenox);


            set = statement.executeQuery("SELECT price FROM training_db.pricefenox group by price");
            List<String> listPriceFenox = new ArrayList<>();
            while (set.next()) {
                listPriceFenox.add(set.getString(1));
            }

            request.setAttribute("listPriceFenox", listPriceFenox);


            set = statement.executeQuery("SELECT pricenew FROM training_db.pricefenox group by pricenew");
            List<String> listPriceFenoxNew = new ArrayList<>();
            while (set.next()) {
                listPriceFenoxNew.add(set.getString(1));
            }

            request.setAttribute("listPriceFenoxNew", listPriceFenoxNew);


            List<String> listForFilter = new ArrayList<>();


            String filterArtFenox = request.getParameter("filterArtFenoxSelect");
            try {
                if (!listFilterData.get(0).equals("FILTER")) {
                    filterArtFenox = listFilterData.get(0);
                    if (!filterArtFenox.equals("")) {
                        listForFilter.add("article=" + "'" + filterArtFenox + "'");
                    }
                } else if (!filterArtFenox.equals("")) {
                    listForFilter.add("article=" + "'" + filterArtFenox + "'");
                }
            } catch (Exception e) {

            }


            String filterGroupFenox = request.getParameter("filterGroupFenoxSelect");
            try {
                if (!listFilterData.get(1).equals("FILTER")) {
                    filterGroupFenox = listFilterData.get(1);
                    if (!filterGroupFenox.equals("")) {
                        listForFilter.add("groupfenox=" + "'" + filterGroupFenox + "'");
                    }
                } else if (!filterGroupFenox.equals("")) {
                    listForFilter.add("groupfenox=" + "'" + filterGroupFenox + "'");
                }
            } catch (Exception e) {

            }

            String filterDescriptFenox = request.getParameter("filterDescriptFenoxSelect");
            try {
                if (!listFilterData.get(2).equals("FILTER")) {
                    filterDescriptFenox = listFilterData.get(2);
                    if (!filterDescriptFenox.equals("")) {
                        listForFilter.add("description=" + "'" + filterDescriptFenox + "'");
                    }
                } else if (!filterDescriptFenox.equals("")) {
                    listForFilter.add("description=" + "'" + filterDescriptFenox + "'");
                }
            } catch (Exception e) {

            }


            String filterPriceFenox = request.getParameter("filterPriceFenoxSelect");
            try {
                if (!listFilterData.get(3).equals("FILTER")) {
                    filterPriceFenox = listFilterData.get(3);
                    if (!filterPriceFenox.equals("")) {
                        listForFilter.add("price=" + "'" + filterPriceFenox + "'");
                    }
                } else if (!filterPriceFenox.equals("")) {
                    listForFilter.add("price=" + "'" + filterPriceFenox + "'");
                }
            } catch (Exception e) {

            }


            String filterPriceFenoxNew = request.getParameter("filterPriceFenoxNewSelect");
            try {
                if (!listFilterData.get(4).equals("FILTER")) {
                    filterPriceFenoxNew = listFilterData.get(4);
                    if (!filterPriceFenoxNew.equals("")) {
                        listForFilter.add("pricenew=" + "'" + filterPriceFenoxNew + "'");
                    }
                } else if (!filterPriceFenoxNew.equals("")) {
                    listForFilter.add("pricenew=" + "'" + filterPriceFenoxNew + "'");
                }
            } catch (Exception e) {

            }


            List<String> listCountPage = new ArrayList<>();
            int count = 0;


            if (listForFilter.size() == 0) {


                set = statement.executeQuery("SELECT * FROM training_db.pricefenox LIMIT " + 500 + " OFFSET " + x1 + "");
                while (set.next()) {
                    listAllOnDispley.add(new PriceFenoxDto(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6)));
                }

                set = statement.executeQuery("SELECT article FROM training_db.pricefenox");
                while (set.next()) {
                    count++;
                }
                int countPage = count / 500;
                for (int i = 1; i <= countPage + 1; i++) {
                    listCountPage.add(String.valueOf(i));
                }

            } else if (listForFilter.size() == 1) {


                set = statement.executeQuery("SELECT * FROM training_db.pricefenox WHERE " + listForFilter.get(0) + " LIMIT " + 500 + " OFFSET " + x1 + "");

                while (set.next()) {
                    listAllOnDispley.add(new PriceFenoxDto(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6)));
                }


                set = statement.executeQuery("SELECT article FROM training_db.pricefenox WHERE " + listForFilter.get(0) + "");
                while (set.next()) {
                    count++;
                }
                int countPage = count / 500;
                for (int i = 1; i <= countPage + 1; i++) {
                    listCountPage.add(String.valueOf(i));
                }


            } else if (listForFilter.size() > 1) {


                String bigFilter = "";
                for (String text : listForFilter) {
                    if (bigFilter == "") {
                        bigFilter = text;
                    } else {
                        bigFilter = bigFilter + " AND " + text;
                    }
                }

                set = statement.executeQuery("SELECT * FROM training_db.pricefenox WHERE " + bigFilter + " LIMIT " + 500 + " OFFSET " + x1 + "");

                while (set.next()) {
                    listAllOnDispley.add(new PriceFenoxDto(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6)));
                }


                set = statement.executeQuery("SELECT id FROM training_db.pricefenox WHERE " + bigFilter + "");
                while (set.next()) {
                    count++;
                }
                int countPage = count / 500;
                for (int i = 1; i <= countPage + 1; i++) {
                    listCountPage.add(String.valueOf(i));
                }

            }


            request.setAttribute("listCountPage", listCountPage);


        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(c, statement, set);
        }


        return listAllOnDispley;

    }
}