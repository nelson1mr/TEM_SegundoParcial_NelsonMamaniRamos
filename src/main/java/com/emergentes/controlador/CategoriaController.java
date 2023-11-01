
package com.emergentes.controlador;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.modelo.Categoria;
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

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriaDAO dao = new CategoriaDAOimpl();
        Categoria cat = new Categoria();
        int id;
      
       String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
       switch (action){
           case "add":
               request.setAttribute("categoria", cat);
               request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
               break;
           case "edit":
               id = Integer.parseInt(request.getParameter("id"));
            
                try {
                    cat = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro");
                }
            
               request.setAttribute("categoria", cat);
               request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
               
               break;

           case "delete":
               id = Integer.parseInt(request.getParameter("id"));
               try {
                   dao.delete(id);
               } catch (Exception ex) {
                   System.out.println("Error al eliminar: "+ ex.getMessage());
               }
               response.sendRedirect("CategoriaController");
               break;
           case "view":
               List<Categoria> lista = new ArrayList<Categoria>();
            try {
                lista = dao.getAll();
            } catch (Exception ex) {
                System.out.println("Error al listar "+ex.getMessage());
            }
               request.setAttribute("categorias", lista);
               request.getRequestDispatcher("categorias.jsp").forward(request, response);
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
      String categoria = request.getParameter("categoria");
      
      Categoria cat = new Categoria();
      
      cat.setId(id);
      cat.setCategoria(categoria);
      
      CategoriaDAO dao = new CategoriaDAOimpl();
      
      if (id==0){
          try {
              dao.insert(cat);
          } catch (Exception ex) {
              System.out.println("Error al insertar "+ex.getMessage());
          }
          
      }
      else{
          try {
              dao.update(cat);
          } catch (Exception ex) {
              
              System.err.println("Error al editar "+ ex.getMessage());
          }
      }
      response.sendRedirect("CategoriaController");
    }
}
