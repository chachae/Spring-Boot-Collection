package com.chachae.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chachae.entity.UserInfo;
import com.chachae.entity.dto.UserInfoDTO;
import com.chachae.entity.vo.UserInfoVO;

/**
 * @author chachae
 * @date 2019/12/20 11:06
 */
public interface UserInfoDAO extends BaseMapper<UserInfo> {

  /**
   * 分页查询
   *
   * @param page 分页数据
   * @param dto 模糊搜索条件
   * @return 分页包装结果对象
   */
  IPage<UserInfoVO> selectPageVO(Page<UserInfo> page, UserInfoDTO dto);

  /**
   * 通过用户名查询用户信息
   *
   * @param userName 用户名
   * @return 用户详细信息
   */
  UserInfoVO selectVoByUserName(String userName);
}
