/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.dao.ContactoDAO;
import Modelo.dto.ContactoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin Sandoval
 */
public class ContactoCTO extends HttpServlet {
        ContactoDAO objDAO = new ContactoDAO();

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
        String accion = request.getParameter("accion");
        System.out.println(accion);
        switch (accion) {
            case "crear": {
                //Recuperamos los valores
                String nombre = request.getParameter("txtnombre");
                String correo = request.getParameter("txtemail");
                String asunto = request.getParameter("txtasunto");
                String descripcion = request.getParameter("txtdescripcion");

                ContactoDTO objComentario = new ContactoDTO();

                objComentario.setNombre(nombre);
                objComentario.setCorreo(correo);
                objComentario.setAsunto(asunto);
                objComentario.setDescripcion(descripcion);
                boolean enviado = objDAO.crear(objComentario);
                if (enviado) {
                    PrintWriter out = response.getWriter();
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>respuesta</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>Datos enviados con éxito</h1>");
//                    out.println("<a href='ContactoCTO?accion=listar'>Listar</a>");
//                    out.println("<a href='index.jsp'>Volver</a>");
//                    out.println("</body>");
//                    out.println("</html>");
                     request.getRequestDispatcher("ContactoCTO?accion=listar").forward(request, response); //redirecciona a una página

                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>respuesta</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Error al enviar la información</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }

                break;
            }
            case "listar": {

                List<ContactoDTO> lista = objDAO.readAll();
                
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>respuesta</title>");
                out.println("</head>");
                out.println("<body>");
                System.out.println(lista);
                for (ContactoDTO contacto : lista) {
                    out.println("<p>" + contacto + "</p>");
                }
                out.println("<a href='index.jsp'>Volver</a>");

                out.println("</body>");
                out.println("</html>");
                break;
            }
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
        processRequest(request, response);

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
