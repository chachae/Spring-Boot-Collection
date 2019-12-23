package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.UserInfoDTO;
import com.chachae.entity.vo.UserInfoVO;
import com.chachae.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author chachae
 * @date 2019/12/20 11:13
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

  @Resource private UserInfoService userInfoService;

  /**
   * 模糊查询
   *
   * @param page 分页参数
   * @param dto 模糊条件
   * @return 分页结果
   */
  @GetMapping("/list")
  public Result<UserInfoVO> list(Page<UserInfo> page, UserInfoDTO dto) {
    IPage<UserInfoVO> result = this.userInfoService.pageVO(page, dto);
    return Result.ok(result);
  }

  @GetMapping("/{userName}")
  public Result<UserInfoVO> userInfo(@PathVariable String userName) {
    UserInfoVO vo = this.userInfoService.getVoByUserName(userName);
    return Result.ok(vo);
  }

  @PutMapping("/update")
  public Result<Boolean> update(@Valid UserInfo userInfo) {
    boolean res = this.userInfoService.updateById(userInfo);
    return Result.ok(res);
  }
}
