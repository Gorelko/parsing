package my.parsing.app.connection;

import my.parsing.app.dto.PriceDto;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OutDataFromSqlForArticle {
    public static List<PriceDto> outDataFromSql(HttpServletRequest request, List<String> listFilterData, String enterPriceNew) {


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

        List<PriceDto> listAllOnDispley = new ArrayList<>();

        try {

            c = ConnectionManager.getConnection();
            statement = c.createStatement();

            String artEnter = request.getParameter("filterArtBrend1Select");

            if (!enterPriceNew.equals("")) {
                statement.executeUpdate("UPDATE pricefenox SET pricenew = " + enterPriceNew + " WHERE article='" + artEnter + "' LIMIT 100");
            }

            set = statement.executeQuery("SELECT Brend1 FROM training_db.amtel_price group by Brend1");
            List<String> listBrend1 = new ArrayList<>();
            while (set.next()) {
                listBrend1.add(set.getString(1));
            }

            request.setAttribute("listBrend1", listBrend1);


            set = statement.executeQuery("SELECT Article_brend1 FROM training_db.amtel_price group by Article_brend1");
            List<String> listArtBrend1 = new ArrayList<>();
            while (set.next()) {
                listArtBrend1.add(set.getString(1));
            }

            request.setAttribute("listArtBrend1", listArtBrend1);


            set = statement.executeQuery("SELECT Brend2 FROM training_db.amtel_price group by Brend2");
            List<String> listBrend2 = new ArrayList<>();
            while (set.next()) {
                listBrend2.add(set.getString(1));
            }

            request.setAttribute("listBrend2", listBrend2);

            set = statement.executeQuery("SELECT Article_brend2 FROM training_db.amtel_price group by Article_brend2");
            List<String> listArtBrend2 = new ArrayList<>();
            while (set.next()) {
                listArtBrend2.add(set.getString(1));
            }

            request.setAttribute("listArtBrend2", listArtBrend2);


            set = statement.executeQuery("SELECT description_art FROM training_db.amtel_price group by description_art");
            List<String> listDescription = new ArrayList<>();
            while (set.next()) {
                listDescription.add(set.getString(1));
            }

            request.setAttribute("listDescription", listDescription);


            set = statement.executeQuery("SELECT Count_dirty FROM training_db.amtel_price group by Count_dirty");
            List<String> listCountArt = new ArrayList<>();
            while (set.next()) {
                listCountArt.add(set.getString(1));
            }

            request.setAttribute("listCountArt", listCountArt);


            set = statement.executeQuery("SELECT Price_dirty FROM training_db.amtel_price group by Price_dirty");
            List<String> listPrice = new ArrayList<>();
            while (set.next()) {
                listPrice.add(set.getString(1));
            }

            request.setAttribute("listPrice", listPrice);


            set = statement.executeQuery("SELECT Stock FROM training_db.amtel_price group by Stock");
            List<String> listStock = new ArrayList<>();
            while (set.next()) {
                listStock.add(set.getString(1));
            }

            request.setAttribute("listStock", listStock);


            set = statement.executeQuery("SELECT Date_swap FROM training_db.amtel_price group by Date_swap");
            List<String> listDate = new ArrayList<>();
            while (set.next()) {
                listDate.add(set.getString(1));
            }

            request.setAttribute("listDate", listDate);


            List<String> listForFilter = new ArrayList<>();

            String filterBrend1 = request.getParameter("filterBrend1Select");
            try {
                if (!listFilterData.get(0).equals("FILTER")) {
                    filterBrend1 = listFilterData.get(0);
                    if (!filterBrend1.equals("")) {
                        listForFilter.add("Brend1=" + "'" + filterBrend1 + "'");
                    }
                } else if (!filterBrend1.equals("")) {
                    listForFilter.add("Brend1=" + "'" + filterBrend1 + "'");
                }
            } catch (Exception e) {
                //           listForFilter.add("Brend1="+ "'" +"FILTER"+ "'");
            }


            String filterArtBrend1 = request.getParameter("filterArtBrend1Select");
            try {
                if (!listFilterData.get(1).equals("FILTER")) {
                    filterArtBrend1 = listFilterData.get(1);
                    if (!filterArtBrend1.equals("")) {
                        listForFilter.add("Article_brend1=" + "'" + filterArtBrend1 + "'");
                    }
                } else if (!filterArtBrend1.equals("")) {
                    listForFilter.add("Article_brend1=" + "'" + filterArtBrend1 + "'");
                }
            } catch (Exception e) {
                //            listForFilter.add("Article_brend1="+ "'" +"FILTER"+ "'");
            }

            String filterBrend2 = request.getParameter("filterBrend2Select");
            try {
                if (!listFilterData.get(2).equals("FILTER")) {
                    filterBrend2 = listFilterData.get(2);
                    if (!filterBrend2.equals("")) {
                        listForFilter.add("Brend2=" + "'" + filterBrend2 + "'");
                    }
                } else if (!filterBrend2.equals("")) {
                    listForFilter.add("Brend2=" + "'" + filterBrend2 + "'");
                }
            } catch (Exception e) {
                //            listForFilter.add("Brend2="+ "'" +"FILTER"+ "'");
            }


            String filterArtBrend2 = request.getParameter("filterArtBrend2Select");
            try {
                if (!listFilterData.get(3).equals("FILTER")) {
                    filterArtBrend2 = listFilterData.get(3);
                    if (!filterArtBrend2.equals("")) {
                        listForFilter.add("Article_brend2=" + "'" + filterArtBrend2 + "'");
                    }
                } else if (!filterArtBrend2.equals("")) {
                    listForFilter.add("Article_brend2=" + "'" + filterArtBrend2 + "'");
                }
            } catch (Exception e) {
                //            listForFilter.add("Article_brend2="+ "'" +"FILTER"+ "'");
            }


            String filterDescription = request.getParameter("filterDescriptionSelect");
            try {
                if (!listFilterData.get(4).equals("FILTER")) {
                    filterDescription = listFilterData.get(4);
                    if (!filterDescription.equals("")) {
                        listForFilter.add("description_art=" + "'" + filterDescription + "'");
                    }
                } else if (!filterDescription.equals("")) {
                    listForFilter.add("description_art=" + "'" + filterDescription + "'");
                }
            } catch (Exception e) {
                //            listForFilter.add("description_art="+ "'" +"FILTER"+ "'");
            }


            String filterCountArt = request.getParameter("filterCountArtSelect");
            try {
                if (!listFilterData.get(5).equals("FILTER")) {
                    filterCountArt = listFilterData.get(5);
                    if (!filterCountArt.equals("")) {
                        listForFilter.add("Count_dirty=" + "'" + filterCountArt + "'");
                    }
                } else if (!filterCountArt.equals("")) {
                    listForFilter.add("Count_dirty=" + "'" + filterCountArt + "'");
                }
            } catch (Exception e) {
                //            listForFilter.add("Count_dirty=" + "'" + "FILTER" + "'");
            }


            String filterPrice = request.getParameter("filterPriceSelect");
            try {
                if (!listFilterData.get(6).equals("FILTER")) {
                    filterPrice = listFilterData.get(6);
                    if (!filterPrice.equals("")) {
                        listForFilter.add("Price_dirty=" + "'" + filterPrice + "'");
                    }
                } else if (!filterPrice.equals("")) {
                    listForFilter.add("Price_dirty=" + "'" + filterPrice + "'");
                }
            } catch (Exception e) {
                //   listForFilter.add("Price_dirty="+ "'" +"FILTER"+ "'");
            }


            String filterStock = request.getParameter("filterStockSelect");
            try {
                if (!listFilterData.get(7).equals("FILTER")) {
                    filterStock = listFilterData.get(7);
                    if (!filterStock.equals("")) {
                        listForFilter.add("Stock=" + "'" + filterStock + "'");
                    }
                } else if (!filterStock.equals("")) {
                    listForFilter.add("Stock=" + "'" + filterStock + "'");
                }
            } catch (Exception e) {
//    listForFilter.add("Stock="+ "'" +"FILTER"+ "'");
            }


            String filterDate = request.getParameter("filterDateSelect");
            try {
                if (!listFilterData.get(8).equals("FILTER")) {
                    filterDate = listFilterData.get(8);
                    if (!filterDate.equals("")) {
                        listForFilter.add("Date_swap=" + "'" + filterDate + "'");
                    }
                } else if (!filterDate.equals("")) {
                    listForFilter.add("Date_swap=" + "'" + filterDate + "'");
                }
            } catch (Exception e) {
                //     listForFilter.add("Date_swap=" + "'" + "FILTER" + "'");
            }


            List<String> listCountPage = new ArrayList<>();
            int count = 0;


            if (listForFilter.size() == 0) {


                set = statement.executeQuery("SELECT * FROM training_db.amtel_price LIMIT " + 500 + " OFFSET " + x1 + "");
                while (set.next()) {
                    listAllOnDispley.add(new PriceDto(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9), set.getString(10)));
                }

                set = statement.executeQuery("SELECT Brend1 FROM training_db.amtel_price");
                while (set.next()) {
                    count++;
                }
                int countPage = count / 500;
                for (int i = 1; i <= countPage + 1; i++) {
                    listCountPage.add(String.valueOf(i));
                }

            } else if (listForFilter.size() == 1) {


                set = statement.executeQuery("SELECT * FROM training_db.amtel_price WHERE " + listForFilter.get(0) + " LIMIT " + 500 + " OFFSET " + x1 + "");

                while (set.next()) {
                    listAllOnDispley.add(new PriceDto(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9), set.getString(10)));
                }


                set = statement.executeQuery("SELECT Brend1 FROM training_db.amtel_price WHERE " + listForFilter.get(0) + "");
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


                set = statement.executeQuery("SELECT * FROM training_db.amtel_price WHERE " + bigFilter + " LIMIT " + 500 + " OFFSET " + x1 + "");

                while (set.next()) {
                    listAllOnDispley.add(new PriceDto(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9), set.getString(10)));
                }


                set = statement.executeQuery("SELECT Brend1 FROM training_db.amtel_price WHERE " + bigFilter + "");
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