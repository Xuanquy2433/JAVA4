/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UserDao;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author XuanQuy
 */
public class RegisterController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("usernameRes");
        String password = request.getParameter("passwordRes");
        String role = request.getParameter("role");
        String email = request.getParameter("emailRes");
        String name = request.getParameter("nameRes");

        UserDTO user = new UserDTO(0, username, password, email, "user", name);
        System.out.println("user" + user);
        UserDao userDao = new UserDao();

        if (userDao.isExist(username)) {
            try ( PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet HomeServlet</title>");

                out.println("</head>");
                out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");

                out.println("<script type=\"text/javascript\">");
                out.println("alert('UserName is exist !');");
                out.println("location='/ASM-JAVA4/login.jsp';");
                out.println("</script>");

                out.println("</div>");

                out.println("</body>");
                out.println("</html>");
            }
        } else {
            boolean register = userDao.create2(user);

            HttpSession session = request.getSession();

            if (register) {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet HomeServlet</title>");
                    // out.println("<a>ádasd<a/>");

                    out.println("</head>");
                    out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Register success');");
                    out.println("location='/ASM-JAVA4/login.jsp';");
                    out.println("</script>");

                    out.println("</div>");

                    out.println("</body>");
                    out.println("</html>");
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet HomeServlet</title>");
                    // out.println("<a>ádasd<a/>");

                    out.println("</head>");
                    out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Register fail');");
                    out.println("location='/ASM-JAVA4/login.jsp';");
                    out.println("</script>");

                    out.println("</div>");

                    out.println("</body>");
                    out.println("</html>");
                }
            }
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
