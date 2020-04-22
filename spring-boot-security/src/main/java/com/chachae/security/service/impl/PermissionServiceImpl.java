package com.chachae.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.security.dao.PermissionDAO;
import com.chachae.security.entity.Permission;
import com.chachae.security.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @author chachae
 * @since 2020/4/22 13:55
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDAO, Permission> implements
    PermissionService {



}
