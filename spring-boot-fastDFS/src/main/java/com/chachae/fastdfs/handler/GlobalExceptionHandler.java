package com.chachae.fastdfs.handler;

import com.chachae.fastdfs.exceptions.ApiException;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author chachae
 * @since 2020/1/11 9:20
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ApiException.class)
  public String apiExceptionHandler(ApiException e, RedirectAttributes redirectAttributes) {
    log.error("【{}】", e.getMsg());
    redirectAttributes.addFlashAttribute("message", e.getMsg());
    return "redirect:/uploadStatus";
  }

  /** fastdfs 异常 */
  @ExceptionHandler(FdfsUnsupportStorePathException.class)
  public String fdfsUnsupportStorePathExceptionHandler(
      FdfsUnsupportStorePathException e, RedirectAttributes redirectAttributes) {
    log.error("【{}】", e.getMessage());
    redirectAttributes.addFlashAttribute("message", e.getMessage());
    return "redirect:/uploadStatus";
  }

  @ExceptionHandler(Exception.class)
  public String exceptionHandler(Exception e, RedirectAttributes redirectAttributes) {
    log.error("【{}】", e.getMessage());
    redirectAttributes.addFlashAttribute("message", e.getMessage());
    return "redirect:/uploadStatus";
  }
}
