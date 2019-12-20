package com.chachae.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author chachae
 * @date 2019/12/20 11:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoVO extends Model<UserInfoVO> {

  // 用户id
  private Long id;
  // 用户名
  private String userName;
  // 邮箱地址
  private String email;
  // 手机号码
  private String mobile;
  // 是否为管理员
  private Boolean admin;
  // 性别
  private Integer gender;
  // 部门id
  private Integer departmentId;
  // 头像地址
  private String avatar;
  // QQ号
  private Integer qqNumber;
  // 微信id
  private String wechatId;
  // 个人主页
  private String site;
  // 个人介绍
  private String description;
  // 创建时间
  private Date createTime;
  // 更新时间
  private Date updateTime;
  // 登陆时间
  private Date loginTime;
  // 登录IP
  private String loginIp;
}
