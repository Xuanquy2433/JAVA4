/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDao;
import DTO.CategoryDTO;
import Utils.GlobalFunc;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.json.Json;
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
        } else if (method.equals("PUT")) {
            System.out.println("Puttttttttttttttttttttttttttttttttttttttttttttttttttttt");
            // chuc nang update
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
            String name = cat.getName();
            String des = cat.getDescription();
            String image = cat.getImage();
            HashMap<String, Object> person = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            if (!name.equals("") && !des.equals("")) {
                CategoryDTO dto = new CategoryDTO(name, des, image);
                CategoryDao dao = new CategoryDao();
                boolean isCreate = dao.update(cat);
                System.err.println("isCreate" + isCreate);
                if (isCreate) {
                    person.put("message", "Cập nhật thành công");
                    // lay thong tin category vừa tạo
                    CategoryDTO detail = dao.getDetailByid(cat.getId());
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
            System.out.println("Deleteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            // chuc nang delete
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            HashMap<String, Object> person = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
            int id = cat.getId();

            CategoryDao dao = new CategoryDao();
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
            CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
            String name = cat.getName();
            String des = cat.getDescription();
            String image = cat.getImage();
            HashMap<String, Object> person = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            if (!name.equals("") && !des.equals("")) {
                CategoryDTO dto = new CategoryDTO(name, des, image);
                CategoryDao dao = new CategoryDao();
                int isCreate = dao.create(dto);
                if (isCreate > 0) {
                    person.put("message", "Tạo thành công");
                    // lay thong tin category vua tao
                    CategoryDTO detail = dao.getDetailByid(isCreate);
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
            System.out.println("go here" + body);
            return;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
