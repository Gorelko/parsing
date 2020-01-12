package my.parsing.app.servlet;

import my.parsing.app.parsing.emex.ParserOpenEmex;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import my.parsing.app.parsing.amtel.ParserOpenAmtel;
import my.parsing.app.outFilesOnDosk.FilesOnDisk;

@WebServlet("/parsing")
public class ParsingServletJava extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        FilesOnDisk filesOnDisk = new FilesOnDisk();
        String[] arrFilesOnDisk = filesOnDisk.outFilesOnDisk(request);
        request.setAttribute("arrFilesOnDisk", arrFilesOnDisk);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/parsing.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String linkUploadFile = request.getParameter("uploadFileEnd");
        System.out.println("Вывод");
        System.out.println(linkUploadFile);
        if (linkUploadFile == null) {
            doGet(request, response);
        }


        String site = request.getParameter("siteSelect");
        System.out.println(site);
        if (site == null) {
            doGet(request, response);
        }

        String email = request.getParameter("email");
        System.out.println(email);


        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("upload\\" + linkUploadFile);
        System.out.println(appPath);


        if (site.equals("Amtel")) {

            try {
                ParserOpenAmtel.parsing(appPath, email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (site.equals("Emex")) {

            try {
                ParserOpenEmex.parsing(appPath, email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/main.jsp");
        dispatcher.forward(request, response);

    }
}



