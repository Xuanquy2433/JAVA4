/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDao;
import DAO.ProductDao;
import DTO.CategoryDTO;
import DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author XuanQuy
 */
public class ShopController extends HttpServlet {

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
            out.println("<title>Servlet ShopController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ProductDao productDao = new ProductDao();
        CategoryDao catDao = new CategoryDao();

        List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
        listCat = catDao.getList();
        request.setAttribute("listCat", listCat);

        String id = request.getParameter("id");
        String idCate = request.getParameter("idCate");

        if (id != null) {
            //detail page
            System.out.println("okokok");
            ProductDTO detail = productDao.getDetailByid(Integer.parseInt(id));
            CategoryDTO catDetail = catDao.getDetailByid(detail.getCategoryId());

            request.setAttribute("detail", detail);
            request.setAttribute("catDetail", catDetail);
            System.out.println("123213123" + detail);

            request.getRequestDispatcher("ShopDetail.jsp").forward(request, response);

        } else if (idCate != null) {
            //category page
            System.out.println("category page");
            List<ProductDTO> listCate = productDao.getListCategory(Integer.parseInt(idCate));

            System.out.println("categpry page list" + listCate);
            request.setAttribute("listCategory", listCate);
            request.getRequestDispatcher("ShopCategory.jsp").forward(request, response);

        } else {
            List<ProductDTO> list = new ArrayList<ProductDTO>();
            list = productDao.getList();

            request.setAttribute("listProduct", list);

            request.getRequestDispatcher("shop.jsp").forward(request, response);
        }
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
