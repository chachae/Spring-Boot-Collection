package cn.chachae.design.factory;

import cn.chachae.design.enums.RoleConsts;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * polymerize all role operate factory method
 *
 * @author chachae
 * @date 2019/12/10 9:48
 */
public class RoleFactory {

  private static Map<Integer, UserService> map = Maps.newHashMap();

  /* Use static block to init the value.
   * key: role code
   * value: correspondence role operate method
   *  */
  static {
    map.put(1, new SuperAdminServiceImpl(RoleConsts.ROLE_SUPER_ADMIN));
    map.put(2, new AdminServiceImpl(RoleConsts.ROLE_ADMIN));
    map.put(3, new NormalServiceImpl(RoleConsts.ROLE_NORMAL));
  }

  /**
   * A simple factory method
   *
   * @param roleCode role code
   * @see RoleConsts
   * @return value
   */
  public static UserService get(Integer roleCode) {
    return map.get(roleCode);
  }
}
