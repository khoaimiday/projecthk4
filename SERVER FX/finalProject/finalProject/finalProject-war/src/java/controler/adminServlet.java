/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entity.AddressFacadeLocal;
import entity.DishCategory;
import entity.DishCategoryFacadeLocal;
import entity.DishesFacadeLocal;
import entity.OffersFacadeLocal;
import entity.OrderDetailsFacadeLocal;
import entity.OrdersFacadeLocal;
import entity.RefreshTokenFacadeLocal;
import entity.RestaurantsFacadeLocal;
import entity.RolesFacadeLocal;
import entity.UsersFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.transaction.UserTransaction;


public class adminServlet extends HttpServlet {
    @EJB
    private UsersFacadeLocal usersFacade;
    @EJB
    private RolesFacadeLocal rolesFacade;
    @EJB
    private RestaurantsFacadeLocal restaurantsFacade;
    @EJB
    private RefreshTokenFacadeLocal refreshTokenFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;
    @EJB
    private OffersFacadeLocal offersFacade;
    @EJB
    private DishesFacadeLocal dishesFacade;
    @EJB
    private DishCategoryFacadeLocal dishCategoryFacade;
    @EJB
    private AddressFacadeLocal addressFacade;
    @Resource
   

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if(action.equals("insertDishCategory")){
                Long id = Long.parseLong(request.getParameter("id"));
                String name = request.getParameter("name");
                DishCategory dish = new DishCategory();
                dish.setId(id);
                dish.setName(name);
                dishCategoryFacade.create(dish);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
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
