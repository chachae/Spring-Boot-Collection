package com.chachae.redis.session.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.chachae.redis.session.constant.Consts;
import com.chachae.redis.session.entity.User;
import com.chachae.redis.session.service.LoginService;
import com.chachae.redis.session.util.HttpContextUtil;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author chachae
 * @since 2020/1/11 14:48
 */
@Service
public class LoginServiceImpl implements LoginService {

  private static final Map<String, String> DB = Maps.newHashMap();

  // 静态块加载数据【模拟数据库】
  static {
    DB.put("userName", "admin");
    DB.put("password", "123");
  }

  @Override
  public Boolean login(User user) {
    boolean usn = ObjectUtil.equal(user.getUserName(), DB.get("userName"));
    boolean psw = ObjectUtil.equal(user.getPassword(), DB.get("password"));
    if (usn && psw) {
      HttpContextUtil.setSession(Consts.SESSION_KEY, IdUtil.fastSimpleUUID());
      return true;
    }
    return false;
  }
}
