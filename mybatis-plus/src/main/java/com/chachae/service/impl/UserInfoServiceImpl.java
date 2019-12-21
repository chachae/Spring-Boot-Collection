package com.chachae.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.bean.Page;
import com.chachae.dao.UserInfoDAO;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.UserInfoDTO;
import com.chachae.entity.vo.UserInfoVO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.UserInfoService;
import com.chachae.util.DateUtil;
import com.chachae.util.HttpContextUtil;
import com.chachae.util.IPUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chachae
 * @date 2019/12/20 11:07
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDAO, UserInfo>
    implements UserInfoService {

  @Resource private UserInfoDAO userInfoDAO;

  @Override
  public IPage<UserInfoVO> selectPageVO(Page<UserInfo> page, UserInfoDTO dto) {
    return this.userInfoDAO.selectPageVO(page, dto);
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean updateById(UserInfo entity) {
    // 设置更新时间
    entity.setUpdateTime(DateUtil.nowDate());
    // 设置IP
    HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
    String ip = IPUtil.getIpAddr(request);
    entity.setLoginIp(ip);
    return super.updateById(entity);
  }
}
