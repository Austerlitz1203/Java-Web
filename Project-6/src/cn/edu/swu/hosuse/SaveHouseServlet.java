package cn.edu.swu.hosuse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet("/saveHouse")
public class SaveHouseServlet extends HttpServlet {

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
//        String owner = request.getParameter("owner");
//        String price = request.getParameter("price");
//        String ownerPhone=request.getParameter("ownerPhone");
//        String describe = request.getParameter("describe");
//
//        House house = new House();
//        house.setName(name);
//        house.setOwner(owner);
//        house.setPrice(Float.valueOf(price));
//        house.setOwnerPhone(ownerPhone);
//        house.setDescribe(describe);
//        System.out.println(String.format("%s, %s, %s,%s, %s", name, owner, ownerPhone,price, describe));

        House house=null;
        try {
            house = this.getHouseFromRequest(request);
        } catch (Exception e) {
            throw new IOException(e);
        }


        String message = null;
        try {
            HouseRepo.getInstance().saveHouse(house);
            message = "提交信息保存成功！";
        } catch (SQLException e) {
            e.printStackTrace();
            message = "提交信息保存失败！";
        }

        response.setContentType("text/html; charset=UTF-8");
        try(Writer writer = response.getWriter()) {
            String html = "<center style=‘margin-top:5em’><h1>%s</h1><br><br>" +
                    "<a href='./submit-house.html'>再 次 录 入</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "<a href='./admin.html'>返 回 首 页</a>" +
                    "</center>";
            writer.write(String.format(html, message));
        }
    }


    private House getHouseFromRequest(HttpServletRequest request) throws Exception {
        if (!ServletFileUpload.isMultipartContent(request)) {
            return null;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));


        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("UTF-8");


        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath(".") + File.separator + UPLOAD_DIRECTORY;
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        List<FileItem> formItems = upload.parseRequest(request);

        House house = new House();

        if (formItems != null && formItems.size() > 0) {
            for (FileItem item : formItems) {
                // 处理不在表单中的字段
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    fileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);
                    // 在控制台输出文件的上传路径
                    System.out.println(filePath);
                    // 保存文件到硬盘
                    item.write(storeFile);
                    house.setPicture(fileName);

                } else {
                    String encoding = "UTF-8";
                    if (item.getFieldName().equals("id")) {
                        String id = item.getString(encoding);
                        if ( id != null) {
                            house.setId(Long.valueOf(id));
                        }
                    } else if (item.getFieldName().equals("name")) {
                        house.setName(item.getString(encoding));
                    } else if (item.getFieldName().equals("owner")) {
                        house.setOwner(item.getString(encoding));
                    }else if (item.getFieldName().equals("ownerPhone")) {
                        house.setOwnerPhone(item.getString(encoding));
                    }else if (item.getFieldName().equals("describe")) {
                        house.setDescribe(item.getString(encoding));
                    }else if (item.getFieldName().equals("price")) {
                        if (item.getString() != null) {
                            house.setPrice(Float.valueOf(item.getString(encoding)));
                        }
                    }
                }
            }
        }

        return house;
    }


}
