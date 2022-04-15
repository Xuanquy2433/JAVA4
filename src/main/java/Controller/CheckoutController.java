/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.OrderDao;
import DTO.Cart;
import DTO.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author XuanQuy
 */
public class CheckoutController extends HttpServlet {

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
        String method = request.getMethod();
        if (method.equals("POST")) {
            System.err.println("go here post");
            String nameCustomer = request.getParameter("customerName");
            String nameCustomerLast = request.getParameter("customerNameLast");
            String phone = request.getParameter("phone");
            String addressShip = request.getParameter("addressShip");
            System.out.println("thong tin " + nameCustomer + " " + phone + " " + addressShip);
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                // thêm product
                //int userId, String customerName, String addressShip, String phone, float total, String status, ArrayList<Item> items, Date createAt
                OrderDTO order = new OrderDTO();
                order.setCustomerName(nameCustomer + " " + nameCustomerLast);
                order.setAddressShip(addressShip);
                order.setPhone(phone);
                order.setUserId(0);
                order.setStatus("PENDING");
                order.setItems(cart.getCart());
                order.setTotal(cart.getTongTien());
                java.util.Date utilDate = new java.util.Date();
                order.setCreateAt(utilDate);
                OrderDao dao = new OrderDao();
                dao.insert(order);
                System.out.println("NAME: " + order.getCustomerName());

                session.removeAttribute("cart");
                response.sendRedirect("SuccessController");
            } else {
                response.sendRedirect("ShopController");
            }

        } else {
            // get
            response.sendRedirect("checkout.jsp");
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
