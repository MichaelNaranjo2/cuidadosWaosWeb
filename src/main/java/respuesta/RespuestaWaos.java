/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package respuesta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RespuestaWaos", urlPatterns = {"/RespuestaWaos"})
public class RespuestaWaos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head> "
                + "<meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Total Waos</title>");
        out.println("<link rel=\"stylesheet\" href=\"estilazos.css\">");
        out.println("<body class=\"tablita\">\n");
        out.println("<div class=\"contenedor2\">");
        
                
        /*int grandeS=request.getIntHeader("grande");
        int medS=request.getIntHeader("mediano");
        int peqS=request.getIntHeader("pequeño");
        int horaS=request.getIntHeader("horas");*/
        
        String grandeS = request.getParameter("grande");
        String medS = request.getParameter("mediano");
        String peqS = request.getParameter("pequeno");
        String horaS = request.getParameter("horas");
        
        if (numeroPos(grandeS)&&numeroPos(medS)&&numeroPos(peqS)&&numeroPos(horaS)) {
            
            if (grandeS.length()<=10 && medS.length()<=10 && peqS.length()<=10 && horaS.length()<=24 &&
                Integer.parseInt(grandeS)<=10 && Integer.parseInt(medS)<=10 && Integer.parseInt(peqS)<=10 &&
                Integer.parseInt(horaS)<=24) {
                
                int cantG=Integer.parseInt(grandeS);
                int cantM=Integer.parseInt(medS);
                int cantP=Integer.parseInt(peqS);
                int cantH=Integer.parseInt(horaS);
                int cantTotal=cantG+cantM+cantP;
                
                int precioG=cantG*10000*cantH;
                int precioM=cantM*5000*cantH;
                int precioP=cantP*3000*cantH;

                int precioT = (cantG*10000*cantH)+(cantM*5000*cantH)+(cantP*3000*cantH);
                
                if (cantTotal>1) {
                    
                    out.println("<p class=\"columna\">Total perros grandes: $"+precioG+"</p>");
                    out.println("<p class=\"columna\">Total perros medianos: $"+precioM+"</p>");
                    out.println("<p class=\"columna\">Total perros pequeños: $"+precioP+"</p>");

                    out.println("<p class=\"tituloF\">Total a pagar con 10% de descuento es: $"+(precioT-(precioT*0.1))+"</p>");
                    out.println("<a href=\"index.html\"><input type=\"submit\" value=\"volver\" class=\"botoncito\"></a><br>\n");
                    out.println("<img src=\"imagenes\\amongus-bailando.gif\" alt=\"\" class=\"waos\"\n");
                    
                } else {
                    out.println("<p class=\"columna\">Total perros grandes: $"+precioG+"</p>");
                    out.println("<p class=\"columna\">Total perros medianos: $"+precioM+"</p>");
                    out.println("<p class=\"columna\">Total perros pequeños: $"+precioP+"</p>");

                    out.println("<p class=\"tituloF\">Total a pagar: $"+precioT+"</p>");
                    out.println("<a href=\"index.html\"><input type=\"submit\" value=\"volver\" class=\"botoncito\"></a><br>\n");
                    out.println("<img src=\"imagenes\\amongus-bailando.gif\" alt=\"\" class=\"waos\"\n");
                }
                
            } else {
                out.println("<p class=\"tituloF\">ERROR, datos no válidos, ingrese maximo 10 perros por categoría y maximo 24 horas</p>");
                
        }
        }
            
            
            //int precio2=((grandeS*10000)+(medS*5000)+(peqS*3000))*horaS;

            
         else {
            out.println("<p class=\"tituloF\">ERROR, datos no válidos, ingrese unicamente datos numericos en todos los campos</p>");
            out.println("<a href=\"index.html\"><input type=\"submit\" value=\"volver\" class=\"botoncito\"></a><br>\n");
            
            out.println("<img src=\"imagenes/doraemonSad.gif\" alt=\"\"/>");
        }
        
        
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        processRequest(request, response);
    }
    
    
    
    private boolean numeroPos(String str){
        try {
            int numero = Integer.parseInt(str);
            return numero >= 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
