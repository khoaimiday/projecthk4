/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entity.Users;
import entity.UsersFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserServlet extends HttpServlet {
    @EJB
    private UsersFacadeLocal usersFacade;

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("showPage")){
                request.setAttribute("list", usersFacade.findAll());
                request.getRequestDispatcher("showUser.jsp").forward(request, response);
            }else if(action.equalsIgnoreCase("detailLogin"))
            {
            HttpSession session = request.getSession();
            Users loginedInfo
                    = (Users) session.getAttribute("acc");
            request.setAttribute("d", loginedInfo);
            request.getRequestDispatcher("detailUser.jsp").forward(request, response);
            }else if (action.equalsIgnoreCase("update"))
            {
                long id = Long.parseLong(request.getParameter("id"));
                String currentPass = request.getParameter("uCurrentPass").trim();
                Users user = usersFacade.find(id);
                if (!currentPass.equalsIgnoreCase(user.getPassword())) {
                request.setAttribute("noteInsertEmpPage", "Password does not exist");
                request.getRequestDispatcher("UserServlet?action=detail").forward(request, response);                
            }else{
                Date dNow = new Date();
                String email = request.getParameter("email");
                String name = request.getParameter("fullname");               
                String pass = request.getParameter("password");
                String phone = request.getParameter("phoneNumber");
                
                user.setCreatedAt(dNow);
                user.setEmail(email);
                user.setFullName(name);
                user.setPassword(pass);
                user.setPhoneNumber(phone);
      
                
                
                usersFacade.edit(user);
                HttpSession session = request.getSession();
                Users acc = usersFacade.find(id);
                session.setAttribute("acc", acc);
                request.getRequestDispatcher("UserServlet?action=showPage").forward(request, response);
                
                }           
            }else if (action.equalsIgnoreCase("insert"))
                        {
                            Date dnow = new Date();
                            String username = request.getParameter("userName");
                            String password = request.getParameter("password");
//                            if (usersFacade.checkUserName(username) != 0) {
//                                out.print("da vao day");
//                                request.setAttribute("noteInsertCatePage", "UserName already exists");
//                                request.getRequestDispatcher("UserServlet?action=showInsert").forward(request, response);
//                                return;
//                            }
                            Users user = new Users(dnow, password, username);
                            usersFacade.create(user);
                            request.setAttribute("noteShowPage", "Insert Success!!");
                            request.getRequestDispatcher("UserServlet?action=showPage").forward(request, response);
                        }
            else if(action.equalsIgnoreCase("showInsert"))
            {
                request.getRequestDispatcher("insertUser.jsp").forward(request, response);
            }else if(action.equalsIgnoreCase("detail"))
            {
                long id = Long.parseLong(request.getParameter("id"));
                Users user = usersFacade.find(id);
                request.setAttribute("d", user);
                request.getRequestDispatcher("detailUser.jsp").forward(request, response);
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
