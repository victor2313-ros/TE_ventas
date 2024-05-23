package com.emergentes.controlador;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
             Usuario usr= new Usuario();
             int id;
             UsuarioDAO dao=new  UsuarioDAOimpl();
             String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
             switch(action){
                 case "add":
                     request.setAttribute("usuario", usr);
                     request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                     break;
                 case "edit":
                     id = Integer.parseInt(request.getParameter("id"));
                     usr = dao.getById(id);
                     request.setAttribute("usuario", usr);
                     request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                     break;
                 case "delete":
                     id = Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("UsuarioControlador");
                     break;
                 case "view":
                     List<Usuario> lista = dao.getAll();
                     request.setAttribute("usuario", lista);
                     request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                     break;
             }
         }catch(Exception e){
             System.out.println("Error" +e.getMessage());
         }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres= request.getParameter("nombres");
        String apellidos= request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password=request.getParameter("password");
        Usuario usr= new Usuario();
        UsuarioDAO dao=new  UsuarioDAOimpl();
        usr.setId(id);
        usr.setNombres(nombres);
        usr.setApellidos(apellidos);
        usr.setCorreo(email);
        usr.setPassword(password);
        if (id == 0){
            try{
            dao.insert(usr);
        }catch (Exception ex){
             System.out.println("Error al insertar" +ex.getMessage());
        }
           
        }else{
            try{
                dao.update(usr);
            } catch (Exception ex) {
                System.out.println("Error al editar" +ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
    }

}
