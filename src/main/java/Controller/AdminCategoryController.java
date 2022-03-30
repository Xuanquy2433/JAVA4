/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDao;
import DTO.CategoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author XuanQuy
 */
public class AdminCategoryController extends HttpServlet {

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

        String method = request.getMethod();
        System.out.println("method" + method);
        if (method.equals("GET")) {
            try {
                // Xử lý get method
                /**
                 * b1: lay ds cat => db => dao b2 = set bien attribute => client
                 */
                HttpSession session = request.getSession();
                CategoryDao dao = new CategoryDao();
                List<CategoryDTO> list = new ArrayList<CategoryDTO>();
                list = dao.getList();
                request.setAttribute("list", list);
                System.out.println(list.size());
                session.setAttribute("view", "static/pages-category.jsp");
                request.getRequestDispatcher("static/pages-category.jsp").forward(request, response);
            } catch (Exception e) {

            }
        } else {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name").toString();
            String image = request.getParameter("image");
            String desc = request.getParameter("desc");

            if (!name.equals("")) {
                System.out.println("image" + image);
                System.out.println("name:    " + name);
                CategoryDTO dto = new CategoryDTO(name, desc, image);
                CategoryDao dao = new CategoryDao();
                boolean isCreate = dao.create(dto);

                if (isCreate) {
                    try ( PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet HomeServlet</title>");

                        out.println("</head>");
                        out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");

                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Add category sucsess');");
                        out.println("location='/ASM-JAVA4/AdminCategoryController';");
                        out.println("</script>");

                        out.println("</div>");

                        out.println("</body>");
                        out.println("</html>");
                    }
                } else {
                    try ( PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet HomeServlet</title>");

                        out.println("</head>");
                        out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");

                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Add category fails');");
                        out.println("location='/ASM-JAVA4/AdminCategoryController';");
                        out.println("</script>");

                        out.println("</div>");

                        out.println("</body>");
                        out.println("</html>");
                    }
                }
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
