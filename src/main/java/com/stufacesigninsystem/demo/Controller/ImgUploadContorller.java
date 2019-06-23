package com.stufacesigninsystem.demo.Controller;

import com.stufacesigninsystem.demo.Mapper.StudentMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RestController
public class ImgUploadContorller {
    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/imageUpload")
    @ResponseBody
    public String imageUpload(@RequestParam("file") MultipartFile file,@RequestParam("id") String id) {
        String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String filePath = "src/main/resources/static/stuface/";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        studentMapper.updatestuimg("http://localhost:8080/stuface/"+fileName,id);
        System.out.println(id);
        return "上传成功!";
    }
}
