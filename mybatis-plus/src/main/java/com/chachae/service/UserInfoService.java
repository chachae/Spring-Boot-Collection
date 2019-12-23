package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.bean.Page;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.UserInfoDTO;
import com.chachae.entity.vo.UserInfoVO;

/**
 * @author chachae
 * @date 2019/12/20 11:06
 */
public interface UserInfoService extends IService<UserInfo> {

  /**
   * 分页模糊查询
   *
   * @param page 分页信息
   * @param dto 模糊搜索条件
   * @return IPage对象
   */
  IPage<UserInfoVO> pageVO(Page<UserInfo> page, UserInfoDTO dto);

  /**
   * 通过用户名查询用户详细信息
   *
   * @param userName 用户名
   * @return 用户详细信息
   */
  UserInfoVO getVoByUserName(String userName);
}
