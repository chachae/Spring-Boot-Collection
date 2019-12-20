package com.chachae.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.bean.Page;
import com.chachae.dao.UserInfoDAO;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.UserInfoDTO;
import com.chachae.entity.vo.UserInfoVO;
import com.chachae.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
