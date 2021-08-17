
package controler;

import entity.DishCategory;
import entity.DishCategoryFacadeLocal;
import entity.DishesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HUYNH HUY
 */
public class DishCategoryServlet extends HttpServlet {
    @EJB
    private DishesFacadeLocal dishesFacade;
    @EJB
    private DishCategoryFacadeLocal dishCategoryFacade;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String action = request.getParameter("action");
           if (action.equalsIgnoreCase("showInsert")) {
                request.getRequestDispatcher("insertDishCategory.jsp").forward(request, response);
                
           }else if (action.equalsIgnoreCase("insert")) {
            String nameDC = request.getParameter("name").trim();
            if (dishCategoryFacade.checkNameCate(nameDC) != 0) {
                out.print("da vao day");
                request.setAttribute("noteInsertCatePage", "Category name already exists");
                request.getRequestDispatcher("DishCategoryServlet?action=showInsert").forward(request, response);
                return;

            }
                   DishCategory dishcategory = new DishCategory( nameDC);
                   dishCategoryFacade.create(dishcategory);
                   request.setAttribute("noteShowPage", "Insert Category Success!!");
                   out.print("insert thanh cong");
                   request.getRequestDispatcher("DishCategoryServlet?action=showPage").forward(request, response);
                    
        }else if (action.equalsIgnoreCase("showPage")) {
            request.setAttribute("list", dishCategoryFacade.findAll());
            request.getRequestDispatcher("showDishCategory.jsp").forward(request, response);
        
        }else if (action.equalsIgnoreCase("delete")) {
            long id = Long.parseLong(request.getParameter("id"));
            DishCategory delCate = dishCategoryFacade.find(id);
            if (dishesFacade.getDishByCate(id).size() == 0 ) {
                dishCategoryFacade.remove(delCate);
                request.setAttribute("noteShowPage", "Delete Category Success!!");
            }else{
                 request.setAttribute("list", dishCategoryFacade.findAll());
                 request.getRequestDispatcher("showDishCategory.jsp").forward(request, response);
            }
                     
           
                        
        }else if (action.equalsIgnoreCase("detail")) {
                Long id = Long.parseLong(request.getParameter("id")) ;
                DishCategory dCate = dishCategoryFacade.find(id);
                request.setAttribute("d", dCate);
                request.getRequestDispatcher("detailsDishCategory.jsp").forward(request, response);
            
        }else if (action.equalsIgnoreCase("update")) {
               Long id = Long.parseLong(request.getParameter("id")) ;
               String name = request.getParameter("name").trim();
               DishCategory CateO  = dishCategoryFacade.find(id);
                if (dishCategoryFacade.checkNameCate(name) != 0) {
                request.setAttribute("noteInsertCatePage", "Category name already exists");
                request.setAttribute("d",CateO);
                request.getRequestDispatcher("detailsDishCategory.jsp").forward(request, response);
                return;
        }else {
                out.print("khong vao");
            }    
                DishCategory dis = new DishCategory(id, name);
                dishCategoryFacade.edit(dis);
                request.setAttribute("noteShowPage", "Update Category Success!!");
                request.getRequestDispatcher("DishCategoryServlet?action=showPage").forward(request, response);
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
