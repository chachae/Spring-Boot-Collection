package com.chachae.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.chachae.entity.bo.Department;
import com.chachae.entity.bo.Role;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author chachae
 * @date 2019/12/20 11:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
  // 头像地址
  private String avatar;
  // QQ号
  private String qqNumber;
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
  // 部门信息
  private Department department;
  // 角色信息
  private List<Role> roles;
}
