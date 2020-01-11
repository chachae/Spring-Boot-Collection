package com.chachae.fastdfs.controller;

import com.chachae.fastdfs.service.FastDfsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/1/11 9:10
 */
@Controller
public class TestController {

  @Resource FastDfsService fastDfsService;

  @GetMapping("/")
  public String uploadPage() {
    return "upload";
  }

  @GetMapping("/uploadStatus")
  public String uploadStatusPage() {
    return "uploadStatus";
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
    String res = fastDfsService.upload(file);
    String msg = "上传成功";
    model.addAttribute("path", res);
    model.addAttribute("message", msg);
    return "uploadStatus";
  }

  @PostMapping("/delete")
  public String deleteFile(String path, Model model) {
    Boolean res = fastDfsService.delete(path);
    String msg = "删除成功";
    model.addAttribute("path", res);
    model.addAttribute("message", msg);
    return "uploadStatus";
  }
}
