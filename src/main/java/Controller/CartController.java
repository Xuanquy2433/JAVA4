/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ProductDao;
import DTO.Cart;
import DTO.Item;
import DTO.ProductDTO;
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
public class CartController extends HttpServlet {

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
        String action = request.getParameter("cart");
        String quantity = request.getParameter("quantity");
        if (quantity == null) {
            quantity = "1";
        }

        System.out.println("quantity " + quantity);
        HttpSession session = request.getSession();
        if (action != null) {
            // lay cart ra
            // lay id ra
            Cart cart = (Cart) session.getAttribute("cart");
            String id = request.getParameter("id");
            if (id != null) {
                // lay detail product
                ProductDao dao = new ProductDao();
                ProductDTO product = dao.getDetailByid(Integer.parseInt(id));
                System.out.println("product" + product.getId());
                //create Item
                // public Item(int maSP, int soluong, String title, float price, String image)
                Item item = new Item(product.getId(),
                        Integer.parseInt(quantity), product.getName(),
                        product.getPrice(), product.getImage());
                System.out.println("go here");
                if (action.equals("add")) {
                    // them
                    // kiem tra xem da co cart item chua
                    if (cart == null) {
                        cart = new Cart();
                    }
                    cart.add(item, Integer.parseInt(quantity));
                } else if (action.equals("remove")) {
                    System.out.println("xóaaaaaaaaaaaa");
                    if (cart.getSize() == 1) {
                        System.out.println("sttt" + cart.getSize());
                        cart.remove(item);
                    }
                    cart.removeQuantity(item);

                } else {
                    cart.remove(item);
                }
                // set lay cart session
                session.setAttribute("cart", cart);
                response.sendRedirect("cart.jsp");
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
