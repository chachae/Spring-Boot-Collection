package com.chachae.fastdfs.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author chachae
 * @since 2020/1/11 9:11
 */
public interface FastDfsService {

  /**
   * 文件上传服务
   *
   * @param file MultipartFile
   * @return 文件访问地址
   */
  String upload(MultipartFile file);

  /**
   * 文件删除
   *
   * @param path 文件路径(groupName/path)
   * @return Boolean.TRUE
   */
  Boolean delete(String path);
}
