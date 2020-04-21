package com.chachae.security.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

/**
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
}
