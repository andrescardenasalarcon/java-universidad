package com.afca.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/ServletHeaders")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String metodoHttp = req.getMethod();
        out.println("<html>");
        out.println("<head>");
        out.print("<title>Headers HTTP</title>");
        out.println("</head>");
        out.println("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.println("Metodo Http: " + metodoHttp);

        String uri = req.getRequestURI();
        out.println("<br/>");
        out.println("Uri solicitada: " + uri);

        out.println("</br>");
        out.println("</br>");
        //Imprimimos todos los cabeceros disponibles
        Enumeration cabeceros = req.getHeaderNames();
        while (cabeceros.hasMoreElements()) {
            String nombreCabecero = (String) cabeceros.nextElement();
            out.println("<b>" + nombreCabecero + "</b>");
            out.println(req.getHeader(nombreCabecero));
            out.println("<br/>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
