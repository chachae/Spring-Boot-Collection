package com.chachae.security.base;

import cn.hutool.core.collection.CollUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

/**
 * 用户信息上下文抽象类
 *
 * @author chachae
 * @since 2020/4/21 22:01
 */
public abstract class BaseEmployeeInfo {

  private Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  public String getUsername() {
    Object obj = getAuthentication().getPrincipal();
    if (ObjectUtils.isEmpty(obj)) {
      return null;
    } else {
      if (obj instanceof UserDetails) {
        UserDetails res = (UserDetails) obj;
        return res.getUsername();
      } else {
        return obj.toString();
      }
    }
  }

  public List<String> getPermissions() {
    Collection<? extends GrantedAuthority> authorities = getAuthentication().getAuthorities();
    if (CollUtil.isNotEmpty(authorities)) {
      GrantedAuthority[] permissions = authorities.toArray(new GrantedAuthority[0]);
      return Stream.of(permissions).map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList());
    } else {
      return new ArrayList<>();
    }
  }
}
