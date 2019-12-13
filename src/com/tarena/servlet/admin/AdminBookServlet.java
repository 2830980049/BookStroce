package com.tarena.servlet.admin;
import com.tarena.entity.Admin;
import com.tarena.entity.Admin_Book;
import com.tarena.service.impl.AdminServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addBooks.do")
public class AdminBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Admin_Book admin_book = new Admin_Book();
        response.setCharacterEncoding("UTF-8");
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
        File linshi = new File("F:\\images");//当超过500K的时候，存到一个临时文件夹中
        factory.setRepository(linshi);
        upload.setSizeMax(1024 * 1024 * 5);//设置上传的文件总的大小不能超过5M
        try {
            // 1. 得到 FileItem 的集合 items
            List<FileItem> items = upload.parseRequest(request);

            // 2. 遍历 items:
            for (FileItem item : items) {
                // 若是一个一般的表单域, 打印信息
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    if(name.equals("isbn"))
                        admin_book.setIsbn(item.getString("UTF-8"));
                    if(name.equals("title"))
                        admin_book.setTitle(item.getString("UTF-8"));
                    if(name.equals("author"))
                        admin_book.setAuthor(item.getString("UTF-8"));
                    if(name.equals("prices"))
                        admin_book.setPrice(Double.parseDouble(item.getString("UTF-8")));
                    if(name.equals("press"))
                        admin_book.setPress(item.getString("UTF-8"));
                    if(name.equals("edition"))
                        admin_book.setEdition(Integer.parseInt(item.getString("UTF-8")));
                    if(name.equals("published"))
                        admin_book.setPublished(Date.valueOf(item.getString("UTF-8")));
                    if(name.equals("pages"))
                        admin_book.setPages(Integer.parseInt(item.getString("UTF-8")));
                    if(name.equals("words"))
                        admin_book.setWords(Integer.parseInt(item.getString("UTF-8")));
                    if(name.equals("packaging"))
                        admin_book.setPackaging(item.getString("UTF-8"));
                    if(name.equals("gg"))
                        admin_book.setFromat(item.getString("UTF-8"));
                    if(name.equals("form"))
                        admin_book.setForm(item.getString("UTF-8"));
                }
                // 若是文件域则把文件保存到 e:\\files 目录下.
                else {
                    File file  = new File("D:\\Document\\IdeaProjects\\BookStorePro\\out\\artifacts\\BookStorePro_war_exploded\\user\\img\\goods\\"+admin_book.getIsbn());
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    File file1  = new File("D:\\Document\\IdeaProjects\\BookStorePro\\web\\user\\img\\goods\\"+admin_book.getIsbn());
                    if(!file1.exists()){
                        file1.mkdirs();
                    }
                    String url = "D:\\Document\\IdeaProjects\\BookStorePro\\out\\artifacts\\BookStorePro_war_exploded\\user" + admin_book.getIsbn() + "\\";
                    String urls = "D:\\Document\\IdeaProjects\\BookStorePro\\web\\user\\img\\goods\\" + admin_book.getIsbn() + "\\";
                    String fileName = item.getName();
                    String fileName1 = fileName;
                    //String path = item.getString("UTF-8");
                    long sizeInBytes = item.getSize();
                    //String uploadPath = getServletContext().getRealPath(url);
                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    //fileName = "f:\\Javawed 实训\\ShiXun\\out\\artifacts\\ShiXun_war_exploded\\user\\img\\goods\\" + fileName;//文件最终上传的位置
                    //String path=item.getName()getServletContext().getRealPath(url);
                    fileName = url + fileName;//文件最终上传的位置
                    //System.out.println(fileName+admin_book.getIsbn());
                    OutputStream out = new FileOutputStream(fileName);
                    fileName1 = urls + fileName1;//文件最终上传的位置
                    //System.out.println(fileName+admin_book.getIsbn());
                    OutputStream outs = new FileOutputStream(fileName1);
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                        outs.write(buffer, 0, len);
                    }
                    out.close();
                    outs.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        AdminServiceImpl service = new AdminServiceImpl();
        boolean flag;
        //System.out.println(admin_book.getPages()+" "+admin_book.getEdition()+" "+admin_book.getWords()+" "+admin_book.getPrice()+" "+admin_book.getIsbn());
        flag = service.insertBooks(admin_book);
        if(flag){
            HttpSession session=request.getSession();
            List<Admin_Book> list = (List<Admin_Book>)request.getAttribute("list");
            //list.add(admin_book);
        }
        response.sendRedirect("product-add.jsp");
    }
}
