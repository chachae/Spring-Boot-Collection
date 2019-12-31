package com.chachae.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.UserDAO;
import com.chachae.dao.UserInfoDAO;
import com.chachae.entity.bo.User;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.LoginDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.CaptchaService;
import com.chachae.service.LoginService;
import com.chachae.util.DateUtil;
import com.chachae.util.HttpContextUtil;
import com.chachae.util.IPUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author chachae
 * @since 2019/12/21 12:02
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserDAO, User> implements LoginService {

  @Resource private UserDAO userDAO;
  @Resource private UserInfoDAO userInfoDAO;
  @Resource private CaptchaService captchaService;

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public User getUserByLoginDTO(LoginDTO dto) {
    if (!this.captchaService.verify(dto.getCaptcha())) {
      throw ApiException.argError("验证码错误");
    }
    QueryWrapper<User> qw = new QueryWrapper<>();
    qw.lambda().eq(User::getUserName, dto.getUserName()).eq(User::getPassword, dto.getPassword());
    User user = this.userDAO.selectOne(qw);
    boolean res = ObjectUtil.isAllNotEmpty(user);
    if (res) {
      // 记录登陆IP、登陆时间并更信息信息
      HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
      String ip = IPUtil.getIpAddr(request);
      Date now = DateUtil.nowDate();
      UserInfo info = new UserInfo().setId(user.getId()).setLoginIp(ip).setLoginTime(now);
      this.userInfoDAO.updateById(info);
    }
    return res ? user : User.builder().build();
  }
}
