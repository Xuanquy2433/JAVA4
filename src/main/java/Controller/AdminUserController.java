/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UserDao;
import DTO.UserDTO;
import Utils.GlobalFunc;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
public class AdminUserController extends HttpServlet {

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
        String method = request.getMethod();
        System.out.println("method" + method);
        if (method.equals("GET")) {
            try {
                // Xử lý get method
                /**
                 * b1: lay ds cat => db => dao b2 = set bien attribute => client
                 */
                HttpSession session = request.getSession();
                UserDao dao = new UserDao();

                List<UserDTO> list = new ArrayList<UserDTO>();

                list = dao.getList();
                request.setAttribute("list", list);
                System.out.println(list.size());
                System.out.println("danh sachh: " + list);
                request.getRequestDispatcher("static/pages-user.jsp").forward(request, response);
            } catch (Exception e) {

            }
        } else if (method.equals("PUT")) {
            System.out.println("Puttttttttttttttttttttttttttttttttttttttttttttttttttttt");
            // chuc nang update
            System.out.println("chk");
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            UserDTO cat = g.fromJson(body, UserDTO.class);
            String username = cat.getUserName();
            String password = cat.getPassword();
            String email = cat.getEmail();
            String role = cat.getRole();
            String name = cat.getName();

            HashMap<String, Object> person = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            if (!username.equals("") && !password.equals("")) {
                UserDTO dto = new UserDTO(username, password, email, role, name);
                UserDao dao = new UserDao();
                System.out.println("ho hia");
                boolean isCreate = dao.update(cat);
                System.err.println("isCreate" + isCreate);
                if (isCreate) {
                    System.out.println("go e");
                    person.put("message", "Cập nhật thành công");
                    // lay thong tin category vừa tạo
                    UserDTO detail = dao.getDetailByid(cat.getId());
                    person.put("data", detail);
                    String json = new Gson().toJson(person);
                    response.getWriter().write(json);
                    return;
                }

                String json = new Gson().toJson(person);
                response.getWriter().write(json);
                return;

            }
        } else if (method.equals("DELETE")) {
            // chuc nang delete
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            HashMap<String, Object> person = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            UserDTO cat = g.fromJson(body, UserDTO.class);
            int id = cat.getId();

            UserDao dao = new UserDao();
            boolean isCreate = dao.delete(id);
            System.err.println("isDelete" + isCreate);
            if (isCreate) {
                person.put("message", "Delete thành công");
                // lay thong tin category vừa tạo
                String json = new Gson().toJson(person);
                person.put("message", "Delete thành công");
                response.getWriter().write(json);
                return;
            }

            String json = new Gson().toJson(person);
            response.getWriter().write(json);
            return;

        } else {
            // case post
            /**
             * b1: parse dữ liệu từ user JSON b2 dùng Gjson convert json to
             * object b3: thêm du lieu xuong db và get status tra ve b4: tra ra
             * status ve cho nguoi dung bang json
             *
             */
            System.out.println("chk");
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            UserDTO cat = g.fromJson(body, UserDTO.class);
            String username = cat.getUserName();
            String password = cat.getPassword();
            String email = cat.getEmail();
            String role = cat.getRole();
            String name = cat.getName();

            HashMap<String, Object> person = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            if (!username.equals("") && !password.equals("")) {
                UserDTO dto = new UserDTO(username, password, email, role, name);
                UserDao dao = new UserDao();
                int isCreate = dao.createUser(dto);
                if (isCreate > 0) {
                    person.put("message", "Tạo thành công");
                    // lay thong tin category vua tao
                    UserDTO detail = dao.getDetailByid(isCreate);
                    person.put("message", "Tạo thành công");
                    person.put("data", detail);
                }
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
                return;
            } else {
                person.put("message", "invalid data");
                response.setStatus(400);
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            }
            return;

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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
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
