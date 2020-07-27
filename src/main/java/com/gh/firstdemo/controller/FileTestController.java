package com.gh.firstdemo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/26 21:12
 */
@Controller
@RequestMapping("/file")
public class FileTestController {

    @RequestMapping("/uploadFile")
    public String uploadFile() {
        return "file/uploadFile";
    }

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "myFile", required = true) MultipartFile myFile) throws IOException {
        if (myFile != null && !myFile.isEmpty()) {
            // 文件上传路径
//            String path = request.getServletContext().getRealPath("/uploadFiles/");
            String path = "C:\\uploadFiles";
            // 文件名
            String fileName = myFile.getOriginalFilename();
            File filePath = new File(path, fileName);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            myFile.transferTo(filePath);
        }
        return "redirect:/file/downloadFile";
    }

    @RequestMapping("/downloadFile")
    public String downloadFile(HttpServletRequest request, Model model){
//        String path = request.getServletContext().getRealPath("/uploadFiles/");
        String path = "C:\\uploadFiles";
        File fileDir = new File(path);

        File fileList[] = fileDir.listFiles();
        model.addAttribute("filesList", fileList);
        return "file/downloadFile";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(
            HttpServletRequest request,
            @RequestParam(value = "filename", required = true) String filename) throws UnsupportedEncodingException {
        String path = "C:\\uploadFiles";
        // 读取文件保存的根位置
        File file = new File(path + File.separator + filename);
        HttpHeaders header = new HttpHeaders();
        // 设置Content-disposition=attachment（下载头）
        header.setContentDispositionFormData("attachment", filename);

        ResponseEntity<byte[]> re = null;
        try {
            re = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return re;
    }
}
