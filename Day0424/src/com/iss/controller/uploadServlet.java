package com.iss.controller;

import com.iss.dao.IFile;
import com.iss.dao.INCDC;
import com.iss.po.Files;
import com.iss.po.Ncdc;
import com.iss.util.DBUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String path = "";
        String str = "";
        try {
            SqlSession sqlSession = DBUtil.getSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            INCDC incdc = sqlSession.getMapper(INCDC.class);

            //物理文件存放路径
            path = getServletContext().getRealPath("/uploads");


            //定义一个文件对象
            File tempFile = new File(path);

            tempFile.mkdir();//需要手动创建目录

            DiskFileItemFactory factory = new DiskFileItemFactory();


            //设定临时存放路径
            factory.setRepository(tempFile);

            //设置单次文件读取大小
            factory.setSizeThreshold(1024 * 1024);//1k

            //根据文件工厂，上传文件
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setHeaderEncoding("UTF-8");
            upload.setFileSizeMax(1024 * 1024 * 10);//单个文件最大10M
            upload.setSizeMax(1024 * 1024 * 10);//一批上传的文件，不能大于10M

            //接受客户端上传的文件列表
            List<FileItem> formItems = upload.parseRequest(request);

            Files sf = new Files();
            //处理上传文件
            for (FileItem item : formItems) {
                String id = UUID.randomUUID().toString().replace("-", "");
                File f = new File(item.getName());

                String newFileName = id + item.getName().split("\\.")[1];
                String ns[] = item.getName().split("\\.");
                File storeFile = new File(path + "\\" + id);

                //将上传文件的信息保存到数据库中  开始
                sf.setFid(id);
                sf.setFname(item.getName());
                sf.setFpath(path);
                sf.setFtype(ns[ns.length - 1]);//文件扩展名
                sf.setFsize(String.valueOf(item.getSize()));

                iFile.addFile(sf);
                //将上传文件的信息保存到数据库中  结束
                item.write(storeFile);
                //读取op文件，将里面接过插入到数据库中
                BufferedReader br = new BufferedReader(new FileReader(storeFile));

                String line = "";
                br.readLine();
                Ncdc ncdc = null;
                while ((line = br.readLine()) != null) {
                    ncdc = new Ncdc();

                    ncdc.setStn(line.substring(0,6));
                    ncdc.setWban(line.substring(7,12));
                    ncdc.setYeaRs(line.substring(14,18));
                    incdc.addInfo(ncdc);
                }

                br.close();


            }
            sqlSession.commit();
            str = "上传成功！";
        } catch (Exception e) {
            str = e.getMessage();
            e.printStackTrace();
        }
        out.print(str);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
