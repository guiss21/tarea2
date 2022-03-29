package com.emergentes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Visitas", urlPatterns = {"/Visitas"})
public class Visitas extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int contador=0;
       //obtener el arreglo de cookies del cliente
       Cookie[] cukis = request.getCookies();
       if(cukis != null){
       for(Cookie c:cukis){
       if(c.getName().equals("visitas")){
           //anets de la asignacion se convierte un valor en cadena
           contador= Integer.parseInt( c.getValue());
       }
       }
       } 
       if(contador==0){
            PrintWriter out = response.getWriter();
           out.println( "Bienvenido a nuestro sitio Web");
                      }
       else{
            PrintWriter out = response.getWriter();
           out.println( "Gracias por visitarnos nuevamente");
                   }
       contador++;
       Cookie c=new Cookie("visitas",Integer.toString(contador));
     c.setMaxAge(30);
     response.addCookie(c);
     //generar contenido apartir del servlet
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   } 
}
