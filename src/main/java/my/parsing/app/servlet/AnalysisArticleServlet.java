package my.parsing.app.servlet;

import my.parsing.app.connection.OutDataFromSqlForArticle;
import my.parsing.app.dto.PriceDto;
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


@WebServlet("/analysisarticle")
public class AnalysisArticleServlet extends HttpServlet {

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


        String numberPage = request.getParameter("numberPage");
        if (numberPage == null) {
            numberPage = "1";
            request.setAttribute("numberPage", numberPage);
        } else {
            request.setAttribute("numberPage", numberPage);
        }


        String enterPriceNew = request.getParameter("enterPriceNew");
        if (enterPriceNew == null) {
            enterPriceNew = "";
            request.setAttribute("enterPriceNew", enterPriceNew);
        } else {
            request.setAttribute("enterPriceNew", enterPriceNew);
        }

        System.out.println(enterPriceNew);


        String filterBrend1Select = request.getParameter("listBrend1");
        if (filterBrend1Select == null) {
            filterBrend1Select = "";
            request.setAttribute("filterBrend1Select", filterBrend1Select);
        } else if (!filterBrend1Select.equals("FILTER")) {
            session.setAttribute("filterBrend1Select", filterBrend1Select);
            request.setAttribute("filterBrend1Select", filterBrend1Select);
        }

        System.out.println("В сервлете");
        System.out.println(filterBrend1Select);


        String filterArtBrend1Select = request.getParameter("filterArtBrend1Select");
        request.setAttribute("filterArtBrend1Select", filterArtBrend1Select);
        if (filterArtBrend1Select == null) {
            request.setAttribute("filterArtBrend1Select", filterArtBrend1Select);
        } else if (!filterArtBrend1Select.equals("FILTER")) {
            session.setAttribute("filterArtBrend1Select", filterArtBrend1Select);
            request.setAttribute("filterArtBrend1Select", filterArtBrend1Select);
        }


        String filterBrend2Select = request.getParameter("listBrend2");
        if (filterBrend2Select == null) {
            filterBrend2Select = "";
            request.setAttribute("filterBrend2Select", filterBrend2Select);
        } else if (!filterBrend2Select.equals("FILTER")) {
            session.setAttribute("filterBrend2Select", filterBrend2Select);
            request.setAttribute("filterBrend2Select", filterBrend2Select);
        }


        String filterArtBrend2Select = request.getParameter("listArtBrend2");
        if (filterArtBrend2Select == null) {
            filterArtBrend2Select = "";
            request.setAttribute("filterArtBrend2Select", filterArtBrend2Select);
        } else if (!filterArtBrend2Select.equals("FILTER")) {
            session.setAttribute("filterArtBrend2Select", filterArtBrend2Select);
            request.setAttribute("filterArtBrend2Select", filterArtBrend2Select);
        }


        String filterDescriptionSelect = request.getParameter("listDescription");
        if (filterDescriptionSelect == null) {
            filterDescriptionSelect = "";
            request.setAttribute("filterDescriptionSelect", filterDescriptionSelect);
        } else if (!filterDescriptionSelect.equals("FILTER")) {
            session.setAttribute("filterDescriptionSelect", filterDescriptionSelect);
            request.setAttribute("filterDescriptionSelect", filterDescriptionSelect);
        }


        String filterCountArtSelect = request.getParameter("listCountArt");
        if (filterCountArtSelect == null) {
            filterCountArtSelect = "";
            request.setAttribute("filterCountArtSelect", filterCountArtSelect);
        } else if (!filterCountArtSelect.equals("FILTER")) {
            session.setAttribute("filterCountArtSelect", filterCountArtSelect);
            request.setAttribute("filterCountArtSelect", filterCountArtSelect);
        }


        String filterPriceSelect = request.getParameter("listPrice");
        if (filterPriceSelect == null) {
            filterPriceSelect = "";
            request.setAttribute("filterPriceSelect", filterPriceSelect);
        } else if (!filterPriceSelect.equals("FILTER")) {
            session.setAttribute("filterPriceSelect", filterPriceSelect);
            request.setAttribute("filterPriceSelect", filterPriceSelect);
        }


        String filterStockSelect = request.getParameter("listStock");
        if (filterStockSelect == null) {
            filterStockSelect = "";
            request.setAttribute("filterStockSelect", filterStockSelect);
        } else if (!filterStockSelect.equals("FILTER")) {
            session.setAttribute("filterStockSelect", filterStockSelect);
            request.setAttribute("filterStockSelect", filterStockSelect);
        }


        String filterDateSelect = request.getParameter("listDate");
        if (filterDateSelect == null) {
            filterDateSelect = "";
            request.setAttribute("filterDateSelect", filterDateSelect);
        } else if (!filterDateSelect.equals("FILTER")) {
            session.setAttribute("filterDateSelect", filterDateSelect);
            request.setAttribute("filterDateSelect", filterDateSelect);
        }

        List<String> listFilterData = new ArrayList<>();
        listFilterData.add(filterBrend1Select);
        listFilterData.add(filterArtBrend1Select);
        listFilterData.add(filterBrend2Select);
        listFilterData.add(filterArtBrend2Select);
        listFilterData.add(filterDescriptionSelect);
        listFilterData.add(filterCountArtSelect);
        listFilterData.add(filterPriceSelect);
        listFilterData.add(filterStockSelect);
        listFilterData.add(filterDateSelect);

        List<PriceDto> listAllOnDispley = OutDataFromSqlForArticle.outDataFromSql(request, listFilterData, enterPriceNew);


        request.setAttribute("listAllOnDispley", listAllOnDispley);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/analysisArticle.jsp");
        dispatcher.forward(request, response);

    }
}
