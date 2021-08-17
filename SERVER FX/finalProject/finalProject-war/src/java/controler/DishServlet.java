/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import entity.DishCategoryFacadeLocal;
import entity.Dishes;
import entity.DishesFacadeLocal;
import entity.RestaurantsFacadeLocal;
import java.io.BufferedOutputStream;
import entity.OrderItemFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



//Fix lỗi form có chứa enctype="multipart/form-data"
    @MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
        )
public class DishServlet extends HttpServlet {
    @EJB
    private OrderItemFacadeLocal orderItemFacade;
    @EJB
    private RestaurantsFacadeLocal restaurantsFacade;
    @EJB
    private DishesFacadeLocal dishesFacade;
    @EJB
    private DishCategoryFacadeLocal dishCategoryFacade;
    
    
    private static final String UPLOAD_DIR = "image";
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            //Data ip Cloud
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "huyhuynh",
                "api_key", "186243663589179",
                "api_secret", "xIhyZNk6NYFIuMSHRhZP0srJL_k",
                "secure", true));
        if(action.equalsIgnoreCase("showPage"))
        {
            request.setAttribute("list", dishesFacade.findAll());
            request.getRequestDispatcher("showDish.jsp").forward(request, response);       
        }
        else if(action.equalsIgnoreCase("showInsert")){
            request.setAttribute("listDC", dishCategoryFacade.findAll());
            request.setAttribute("listRes", restaurantsFacade.findAll());
            request.getRequestDispatcher("insertDish.jsp").forward(request, response);
        }
        else if(action.equalsIgnoreCase("insert"))
        {
            long _category = Long.parseLong(request.getParameter("category"));
            long _res = Long.parseLong(request.getParameter("restaurant"));
            String name = request.getParameter("fullname");
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            String unit = request.getParameter("unit");
            Date dnow = new Date();
            
            
            if (dishesFacade.checkName(name) != 0 &&  dishesFacade.checkNameByCate(name)!=0 && dishesFacade.checkNameByRes(name)!=0) {
                out.print("da vao day");
                request.setAttribute("noteInsertProductPage", "Dish name already exists");
                request.getRequestDispatcher("DishServlet?action=showInsert").forward(request, response);
                return;
            } else {
                out.print("khong vao");
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
          Map upload = cloudinary.uploader().upload(f1, ObjectUtils.emptyMap());
          String url = upload.get("secure_url").toString();
          //String test = upload.get("url").toString();
          out.print(upload.get("secure_url"));
          Dishes dish = new Dishes(dnow, url, Boolean.TRUE, name, price, 1, 1F, unit, name, 1F,dishCategoryFacade.find(_category), restaurantsFacade.find(_res));
          dishesFacade.create(dish);
          request.getRequestDispatcher("DishServlet?action=showPage").forward(request, response);
        }
        
        else if(action.equalsIgnoreCase("delete"))
        {
            long id = Long.parseLong(request.getParameter("id"));
            Dishes deldish = dishesFacade.find(id);
            dishesFacade.remove(deldish);
            request.setAttribute("noteShowPage", "Delete Success!!");
            request.getRequestDispatcher("DishServlet?action=showPage").forward(request, response);
        }
        
        else if (action.equalsIgnoreCase("detail"))
        {
            long id = Long.parseLong(request.getParameter("id"));
            Dishes dishes = dishesFacade.find(id);
            request.setAttribute("listDC", dishCategoryFacade.findAll());
            request.setAttribute("listRes", restaurantsFacade.findAll());
            request.setAttribute("d", dishes);
            request.getRequestDispatcher("detailDish.jsp").forward(request, response);

        }
        else if(action.equalsIgnoreCase("update"))
        {
            String url ="";
            long id = Long.parseLong(request.getParameter("id"));
            long _category = Long.parseLong(request.getParameter("category"));
            long _res = Long.parseLong(request.getParameter("restaurant"));
            String name = request.getParameter("fullname");
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            String unit = request.getParameter("unit");
            String note = request.getParameter("note");
            Date dnow = new Date();
            boolean isActive = Boolean.parseBoolean("isActive");
            Dishes dish = dishesFacade.find(id);
            request.setAttribute("listDC", dishCategoryFacade.findAll());
            request.setAttribute("listRes",restaurantsFacade.findAll());
            request.setAttribute("d", dish);
            //up anh
            Part p = request.getPart("image");
            String filename = extractFileName(p);
            out.print("cos du lieu mhs" + p);
                String save_dir = "image";
                String app_path = request.getServletContext().getRealPath("");

                System.out.println(app_path);
                String save_path = app_path + File.separator + save_dir;
                File f = new File(save_path);
                if (!f.exists()) {
                    f.mkdir();
                }

                File f1 = new File(save_path + "/" + filename);

                FileOutputStream fos = new FileOutputStream(f1);
                BufferedOutputStream bos = new BufferedOutputStream(fos);

                String image = filename;

                byte b[] = new byte[p.getInputStream().available()];

                System.out.println(p.getInputStream().available());

                p.getInputStream().read(b);

                bos.write(b);
                bos.close();
                fos.close();

                Map upload = cloudinary.uploader().upload(f1, ObjectUtils.emptyMap());
                url = upload.get("secure_url").toString();
                //  String test = upload.get("url").toString();
                out.print(upload.get("secure_url"));
                
                 Dishes dishes = new Dishes(id, dnow, image, isActive, name, price,1, unit, note,dishCategoryFacade.find(_category), restaurantsFacade.find(_res));
                 dishesFacade.edit(dishes);
                 out.print("insert succ");
                request.setAttribute("noteShowPage", "Update Dish success!!");
                request.getRequestDispatcher("DishServlet?action=showPage").forward(request, response);
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
