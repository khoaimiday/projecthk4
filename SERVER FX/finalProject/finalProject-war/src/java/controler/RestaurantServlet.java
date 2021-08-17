/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import entity.AddressFacadeLocal;
import entity.Restaurants;
import entity.RestaurantsFacadeLocal;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import jdk.nashorn.internal.parser.TokenType;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class RestaurantServlet extends HttpServlet {
    @EJB
    private AddressFacadeLocal addressFacade;
    @EJB
    private RestaurantsFacadeLocal restaurantsFacade;

   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {    
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("showInsert"))
            {
                request.setAttribute("listAd", addressFacade.findAll());
               request.getRequestDispatcher("insertRestaurant.jsp").forward(request, response);
            } 
            
            else if (action.equalsIgnoreCase("showPage"))
            {
                request.setAttribute("list", restaurantsFacade.findAll());
                request.getRequestDispatcher("showRestaurant.jsp").forward(request, response);
            }
            
            else if(action.equalsIgnoreCase("insert"))
            {
                Date ndate = new Date();
                String nameRes = request.getParameter("fullname");
                String phone = request.getParameter("phoneNumber");
                String email = request.getParameter("email");
                long address = Long.parseLong(request.getParameter("address"));
                 if (restaurantsFacade.checkNameRes(nameRes) != 0) {
                out.print("da vao day");
                request.setAttribute("noteInsertCatePage", "Restaurant name already exists");
                request.getRequestDispatcher("RestaurantServlet?action=showInsert").forward(request, response);
                return;
            }
                  //up anh
                    String save_dir="image";
                    String app_path= request.getServletContext().getRealPath("");
                    Part p = request.getPart("image");
                    String filename = extractFileName(p);
                    System.out.println("--"+app_path);
                    String save_path = app_path+File.separator+save_dir;
                    File f =new File(save_path);
                    if(!f.exists())
                    {
                        f.mkdir();
                    }
                    File f1 = new File(save_path+"/"+filename);
                    FileOutputStream fos = new FileOutputStream(f1);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);

                    String image = filename;

                    byte b[] = new byte[p.getInputStream().available()];

                    System.out.println("-"+p.getInputStream().available());

                    p.getInputStream().read(b);

                    bos.write(b);
                    bos.close();
                    fos.close();
                    System.out.println(f1);  
                    String url =f1.toString();

                    Restaurants res = new Restaurants(ndate, email, nameRes, url, Boolean.TRUE, phone,1F, 1F);
                    restaurantsFacade.create(res);
                    request.getRequestDispatcher("RestaurantServlet?action=showPage").forward(request, response);

                    }
            
            else if(action.equalsIgnoreCase("detail"))
                       {
                        long id = Long.parseLong(request.getParameter("id"));
                        Restaurants res = restaurantsFacade.find(id);
                        request.setAttribute("d",res);
                        request.getRequestDispatcher("detailRestaurant.jsp").forward(request, response);
                
                        }
            else if(action.equalsIgnoreCase("delete"))
            {
            long id = Long.parseLong(request.getParameter("id"));
            Restaurants delres = restaurantsFacade.find(id);
            restaurantsFacade.remove(delres);
            request.setAttribute("noteShowPage", "Delete Success!!");
            request.getRequestDispatcher("RestaurantServlet?action=showPage").forward(request, response);
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
    private String extractFileName(Part part) {
   // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
  }

    private Object getFolderUpload() {
         File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
    if (!folderUpload.exists()) {
      folderUpload.mkdirs();
    }
    return folderUpload;
    }
}
