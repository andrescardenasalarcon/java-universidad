package org.example.holamundoglassfish;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "holaMundito", value = "/hola-mundito") //--> Podemos agregar cualquier otra ruta
public class HolaMundo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("Hola Mundo desde Servlets"); //No se recomienda usar cod htmo aqui
    }

    public void destroy() {
    }
}
