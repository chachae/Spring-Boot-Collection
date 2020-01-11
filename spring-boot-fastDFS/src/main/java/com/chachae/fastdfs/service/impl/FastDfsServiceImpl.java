package com.chachae.fastdfs.service.impl;

import cn.hutool.core.util.StrUtil;
import com.chachae.fastdfs.constant.Consts;
import com.chachae.fastdfs.exceptions.ApiException;
import com.chachae.fastdfs.service.FastDfsService;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author chachae
 * @since 2020/1/11 9:14
 */
@Service
public class FastDfsServiceImpl implements FastDfsService {

  @Resource private FastFileStorageClient storageClient;
  @Resource private FdfsWebServer webServer;

  @Override
  public String upload(MultipartFile file) {
    // 文件的原始文件名
    String filename = file.getOriginalFilename();

    // 校验文件类型
    String type = file.getContentType();
    if (!Consts.CONTENT_TYPES.contains(type)) {
      throw ApiException.argError(filename + " 文件类型非法");
    }

    // 校验文件内容
    try {
      BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
      if (bufferedImage == null) {
        throw ApiException.argError(filename + " 文件内容非法");
      }

      // 保存到FastDFS 服务器中
      String ext = StrUtil.subAfter(filename, '.', true);
      StorePath storePath =
          this.storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
      // 实际开发【可能】会将全路径存入数据库中，此时不使用serverPath() 方法拼接web 服务器的路径
      // return storePath.getFullPath()
      return serverPath(storePath.getFullPath());
    } catch (IOException e) {
      throw ApiException.systemError("服务器异常");
    }
  }

  @Override
  public Boolean delete(String path) {
    this.storageClient.deleteFile(path);
    return Boolean.TRUE;
  }

  /**
   * web 服务器地址获取
   *
   * @return web 服务器地址
   */
  private String serverPath() {
    return this.webServer.getWebServerUrl();
  }

  private String serverPath(String fullPath) {
    return this.webServer.getWebServerUrl() + fullPath;
  }
}
