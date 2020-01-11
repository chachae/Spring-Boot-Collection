package com.chachae.redis.session.controller;

import com.chachae.redis.session.constant.Consts;
import com.chachae.redis.session.entity.User;
import com.chachae.redis.session.service.LoginService;
import com.chachae.redis.session.util.HttpContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/1/11 14:45
 */
@Controller
public class LoginController {

  @Resource private LoginService loginService;

  @GetMapping({"/", "/page/login"})
  public String loginPage() {
    return "/login";
  }

  @GetMapping("/page/index")
  public ModelAndView indexPage() {
    ModelAndView mv = new ModelAndView();
    String token = (String) HttpContextUtil.getSession(Consts.SESSION_KEY);
    mv.addObject("token", token);
    mv.setViewName("index");
    return mv;
  }

  @PostMapping("/login")
  public String login(User entity) {
    Boolean res = this.loginService.login(entity);
    return res ? "redirect:/page/index" : "redirect:/page/login";
  }

  @GetMapping("/logout")
  public String logout() {
    HttpContextUtil.removeSession(Consts.SESSION_KEY);
    return "redirect:/page/login";
  }
}
