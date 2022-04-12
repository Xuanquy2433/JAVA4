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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ProductDao productDao = new ProductDao();
        CategoryDao catDao = new CategoryDao();

        List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
        listCat = catDao.getList();
        request.setAttribute("listCat", listCat);

        String id = request.getParameter("id");
        String idCate = request.getParameter("idCate");
        String idSreach = request.getParameter("idSearch");

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("vao roiii yeahhhhhh");

        if (null != request.getParameter("button_search_clicked")) {
            ProductDao productDao = new ProductDao();
            //category page
            System.out.println("serach here");
            String name = request.getParameter("searchBox");

            List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
            CategoryDao catDao = new CategoryDao();
            listCat = catDao.getList();
            request.setAttribute("listCat", listCat);

            System.out.println("value " + name);
            List<ProductDTO> listSearch = productDao.search("%" + name + "%");

            System.out.println("size: " + listSearch.size());

            System.out.println("categpry page list" + listSearch);
            request.setAttribute("listSearch", listSearch);
            request.setAttribute("nameSearch", name);
            request.setAttribute("size", listSearch.size());
            request.setAttribute("messageSearch", listSearch.size() + " results for  " + " \" " + name + " \"" + ".");

            request.getRequestDispatcher("ShopSearch.jsp").forward(request, response);
        } // do 'A' stuff
        else if (null != request.getParameter("button_sort_clicked")) {
            System.out.println("vao sort roi okoko");
            ProductDao productDao = new ProductDao();
            List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
            CategoryDao catDao = new CategoryDao();
            listCat = catDao.getList();
            List<ProductDTO> listSortAsc = productDao.getListSortAsc();

            System.out.println("list sort " + listSortAsc);
            request.setAttribute("listSort", listSortAsc);
            request.setAttribute("listCat", listCat);

            request.getRequestDispatcher("ShopSort.jsp").forward(request, response);

        } else if (null != request.getParameter("button_sortDesc_clicked")) {
            System.out.println("vao sort roi okoko");
            ProductDao productDao = new ProductDao();
            List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
            CategoryDao catDao = new CategoryDao();
            listCat = catDao.getList();
            List<ProductDTO> listSortDesc = productDao.getListSortDesc();

            System.out.println("list sort " + listSortDesc);
            request.setAttribute("listSort", listSortDesc);
            request.setAttribute("listCat", listCat);

            request.getRequestDispatcher("ShopSort.jsp").forward(request, response);

        } else if (null != request.getParameter("button_sortName_clicked")) {
            System.out.println("vao sort roi okoko");
            ProductDao productDao = new ProductDao();
            List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
            CategoryDao catDao = new CategoryDao();
            listCat = catDao.getList();
            List<ProductDTO> listSortName = productDao.getListSortName();

            System.out.println("list sort " + listSortName);
            request.setAttribute("listSort", listSortName);
            request.setAttribute("listCat", listCat);

            request.getRequestDispatcher("ShopSort.jsp").forward(request, response);

        } else {

            ProductDao productDao = new ProductDao();
            //category page
            System.out.println("serach here");
            String name = request.getParameter("searchBox");

            List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
            CategoryDao catDao = new CategoryDao();
            listCat = catDao.getList();
            request.setAttribute("listCat", listCat);

            System.out.println("value " + name);
            List<ProductDTO> listSearch = productDao.search("%" + name + "%");

            System.out.println("size: " + listSearch.size());

            System.out.println("categpry page list" + listSearch);
            request.setAttribute("listSearch", listSearch);
            request.setAttribute("nameSearch", name);
            request.setAttribute("size", listSearch.size());
            request.setAttribute("messageSearch", listSearch.size() + " results for  " + " \" " + name + " \"" + ".");

            request.getRequestDispatcher("ShopSearch.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("sort");
        request.getRequestDispatcher("login.jsp").forward(request, response);

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
