package my.parsing.app.servlet;

import my.parsing.app.connection.OutDataFromSqlForPrice;
import my.parsing.app.dto.PriceFenoxDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/analysis")
public class AnalysPriceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        doPost(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String numberPage = request.getParameter("listCountPage");
        if (numberPage == null) {
            numberPage = "1";
            request.setAttribute("numberPage", numberPage);
        } else {
            request.setAttribute("numberPage", numberPage);
        }


        String filterArtFenoxSelect = request.getParameter("listArtFenox");
        if (filterArtFenoxSelect == null) {
            filterArtFenoxSelect = "";
            request.setAttribute("filterArtFenoxSelect", filterArtFenoxSelect);
        } else if (!filterArtFenoxSelect.equals("FILTER")) {
            session.setAttribute("filterArtFenoxSelect", filterArtFenoxSelect);
            request.setAttribute("filterArtFenoxSelect", filterArtFenoxSelect);
        }


        String filterGroupFenoxSelect = request.getParameter("listGroupFenox");
        if (filterGroupFenoxSelect == null) {
            filterGroupFenoxSelect = "";
            request.setAttribute("filterGroupFenoxSelect", filterGroupFenoxSelect);
        } else if (!filterGroupFenoxSelect.equals("FILTER")) {
            session.setAttribute("filterGroupFenoxSelect", filterGroupFenoxSelect);
            request.setAttribute("filterGroupFenoxSelect", filterGroupFenoxSelect);
        }


        String filterDescriptFenoxSelect = request.getParameter("listDescriptFenox");
        if (filterDescriptFenoxSelect == null) {
            filterDescriptFenoxSelect = "";
            request.setAttribute("filterDescriptFenoxSelect", filterDescriptFenoxSelect);
        } else if (!filterDescriptFenoxSelect.equals("FILTER")) {
            session.setAttribute("filterDescriptFenoxSelect", filterDescriptFenoxSelect);
            request.setAttribute("filterDescriptFenoxSelect", filterDescriptFenoxSelect);
        }


        String filterPriceFenoxSelect = request.getParameter("listPriceFenox");
        if (filterPriceFenoxSelect == null) {
            filterPriceFenoxSelect = "";
            request.setAttribute("filterPriceFenoxSelect", filterPriceFenoxSelect);
        } else if (!filterPriceFenoxSelect.equals("FILTER")) {
            session.setAttribute("filterPriceFenoxSelect", filterPriceFenoxSelect);
            request.setAttribute("filterPriceFenoxSelect", filterPriceFenoxSelect);
        }


        String filterPriceFenoxNewSelect = request.getParameter("listPriceFenoxNew");
        if (filterPriceFenoxNewSelect == null) {
            filterPriceFenoxNewSelect = "";
            request.setAttribute("filterPriceFenoxNewSelect", filterPriceFenoxNewSelect);
        } else if (!filterPriceFenoxNewSelect.equals("FILTER")) {
            session.setAttribute("filterPriceFenoxNewSelect", filterPriceFenoxNewSelect);
            request.setAttribute("filterPriceFenoxNewSelect", filterPriceFenoxNewSelect);
        }


        List<String> listFilterData = new ArrayList<>();
        listFilterData.add(filterArtFenoxSelect);
        listFilterData.add(filterGroupFenoxSelect);
        listFilterData.add(filterDescriptFenoxSelect);
        listFilterData.add(filterPriceFenoxSelect);
        listFilterData.add(filterPriceFenoxNewSelect);


        List<PriceFenoxDto> listAllOnDispley = OutDataFromSqlForPrice.outDataFromSql(request, listFilterData);


        request.setAttribute("listAllOnDispley", listAllOnDispley);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/analysisPrice.jsp");
        dispatcher.forward(request, response);


    }
}
