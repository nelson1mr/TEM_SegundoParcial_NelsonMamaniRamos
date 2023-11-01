
package com.emergentes.controlador;

import com.emergentes.dao.LibroDAO;
import com.emergentes.dao.LibroDAOimpl;
import com.emergentes.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibroController", urlPatterns = {"/LibroController"})
public class LibroController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LibroDAO dao = new LibroDAOimpl();
        Libro lib = new Libro();
        int id;
      
       String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
       switch (action){
           case "add":
               request.setAttribute("libro", lib);
               request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
               break;
           case "edit":
               id = Integer.parseInt(request.getParameter("id"));
            
                try {
                    lib = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro");
                }
            
               request.setAttribute("libro", lib);
               request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
               
               break;

           case "delete":
               id = Integer.parseInt(request.getParameter("id"));
               try {
                   dao.delete(id);
               } catch (Exception ex) {
                   System.out.println("Error al eliminar: "+ ex.getMessage());
               }
               response.sendRedirect("LibroController");
               break;
           case "view":
               List<Libro> lista = new ArrayList<Libro>();
            try {
                lista = dao.getAll();
            } catch (Exception ex) {
                System.out.println("Error al listar "+ex.getMessage());
            }
               request.setAttribute("libros", lista);
               request.getRequestDispatcher("libros.jsp").forward(request, response);
               break;
            default:
                break; 
                   
       } 
 System.out.println("******Iniciando..*******");
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      int id= Integer.parseInt(request.getParameter("id"));
      String titulo = request.getParameter("titulo");
      String autor = request.getParameter("autor");
      String disponible = request.getParameter("disponible");
      String categoria = request.getParameter("categoria");
      
      Libro lib = new Libro();
      
      lib.setId(id);
      lib.setTitulo(titulo);
      lib.setAutor(autor);
      lib.setDisponible(disponible);
      lib.setCategoria(categoria);
      
      LibroDAO dao = new LibroDAOimpl();
      
      if (id==0){
          try {
              dao.insert(lib);
          } catch (Exception ex) {
              System.out.println("Error al insertar "+ex.getMessage());
          }
          
      }
      else{
          try {
              dao.update(lib);
          } catch (Exception ex) {
              
              System.err.println("Error al editar "+ ex.getMessage());
          }
      }
      response.sendRedirect("LibroController");
    }
}
