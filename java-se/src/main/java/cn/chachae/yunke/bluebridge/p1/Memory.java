package cn.chachae.yunke.bluebridge.p1;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @author chachae
 * @date 2019/10/22 11:19
 */
public class Memory {
  public static void get() {
    MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
    long totalMemorySize = memoryUsage.getInit() / 1024 / 1024;
    long maxMemorySize = memoryUsage.getMax() / 1024 / 1024;
    long usedMemorySize = memoryUsage.getUsed() / 1024 / 1024;
    System.out.println(
        "初始的总内存:" + totalMemorySize + ",最大可用内存" + maxMemorySize + ",已使用的内存" + usedMemorySize);
  }
}
