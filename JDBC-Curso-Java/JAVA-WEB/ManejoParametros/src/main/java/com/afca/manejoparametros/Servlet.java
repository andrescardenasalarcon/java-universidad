package com.afca.manejoparametros;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servelet", value = "/Servelet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Leer los parametros del form html
        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");

        System.out.println("user = " + user);
        System.out.println("pass = " + pass);

        //Para responder al cliente
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro usuario es: " + user);
        out.print("<br/>");
        out.print("El parametro password es: " + pass);
        out.print("</body>");
        out.print("</html>");
    }

    public void destroy() {
    }
}
