package com.afca.manejoformilarioshtml.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/servelet")
public class Servelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocuapcion = request.getParameter("ocupacion");
        String musicas[] = request.getParameterValues("musica");
        String comentario = request.getParameter("comentarios");

        out.println("<!DOCTYPE html>");
        out.println("<head>");
        out.println("<title>Resultado Servelet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Parametros procesados por el Servlet: </h1>");
        out.println("<table border='1'>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(user);
        out.print("</td>");
        out.print("</tr>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(pass);
        out.print("</td>");
        out.print("</tr>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Tecnologias");
        out.print("</td>");
        out.print("<td>");

        for (String tec : tecnologias) {
            out.println(tec);
            out.println(" / ");
        }
        out.print("</td>");
        out.print("</tr>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Género");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Ocupación");
        out.print("</td>");
        out.print("<td>");
        out.print(ocuapcion);
        out.print("</td>");
        out.print("</tr>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Musicas");
        out.print("</td>");
        out.print("<td>");
        if (musicas != null) {
            for (String music : musicas) {
                out.println(music);
                out.println(" / ");
            }
        }else {
            out.println("Musica no seleccionada");
        }
        out.print("</td>");
        out.print("</tr>");

        out.println("<tr>");
        out.print("<td>");
        out.print("Comentario");
        out.print("</td>");
        out.print("<td>");
        out.print(comentario);
        out.print("</td>");
        out.print("</tr>");


        out.print("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}
