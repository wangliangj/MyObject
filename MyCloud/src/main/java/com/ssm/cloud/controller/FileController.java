package com.ssm.cloud.controller;

import com.ssm.cloud.pojo.CloudFile;
import com.ssm.cloud.pojo.User;
import com.ssm.cloud.service.CloudFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private CloudFileService cloudFileService;


    @RequestMapping("list.hmtl")
    public ModelAndView list(Model model, HttpSession session,@RequestParam("id") Integer dirId) {
        User user = (User) session.getAttribute("SESSION_USER");
        List<CloudFile> fileList = cloudFileService.getFileById(user.getId(), dirId);
        return new ModelAndView("file_list", "fileList", fileList);
    }

    @RequestMapping("upload.html")
    public String fileUpload3(@RequestParam("file") CommonsMultipartFile[] file, Integer dirId, HttpSession session) {

        try {
            User user = (User) session.getAttribute("SESSION_USER");

        for (CommonsMultipartFile f : file) {
            System.out.println("fileName:" + f.getOriginalFilename());
            System.out.println("fileSize" + f.getSize());
            String path = "E:/upload/" + f.getOriginalFilename();
            File newFile = new File(path);
            f.transferTo(newFile);
            CloudFile cloudFile = new CloudFile();
            cloudFile.setDirId(dirId);
            cloudFile.setUserId(user.getId());
            cloudFile.setName(f.getOriginalFilename());
            cloudFile.setSize(f.getSize());
            //调用service.addFile()
            cloudFileService.addFile(cloudFile);

            //增加sum文件的size，更新dir的大小


        }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "file_upload";
        }


}
