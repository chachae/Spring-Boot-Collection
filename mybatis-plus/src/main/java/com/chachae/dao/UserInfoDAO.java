package com.chachae.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.UserInfoDTO;
import com.chachae.entity.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;

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
  IPage<UserInfoVO> selectPageVO(Page<UserInfo> page, @Param("dto") UserInfoDTO dto);
}
