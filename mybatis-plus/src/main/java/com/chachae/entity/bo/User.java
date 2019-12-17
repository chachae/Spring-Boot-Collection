package com.chachae.entity.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * @author chachae
 * @date 2019/12/16 14:38
 */
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String userName;

  private String password;

  private Integer role;
}
