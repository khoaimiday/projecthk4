/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entity.Address;
import entity.AddressFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddressServlet extends HttpServlet {
    @EJB
    private AddressFacadeLocal addressFacade;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("showPage")){
                request.setAttribute("list",addressFacade.findAll());
                request.getRequestDispatcher("showAddress.jsp").forward(request, response);
            }else if(action.equalsIgnoreCase("insert"))
            {
                Date dnow = new Date();
                String street = request.getParameter("street");
                String ward = request.getParameter("ward");
                String district = request.getParameter("district");
                String cities = request.getParameter("city");   
                float longtitude = Float.parseFloat(request.getParameter("longtitude"));
                float latitude = Float.parseFloat(request.getParameter("latitude"));
                //Address address = new Address(dnow, cities, district, street, ward, longtitude, latitude);
                //addressFacade.create(address);
                request.getRequestDispatcher("AddressServlet?action=showPage").forward(request, response);
            }
            else if(action.equalsIgnoreCase("showInsert"))
            {
                request.getRequestDispatcher("insertAddress.jsp").forward(request, response);
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
