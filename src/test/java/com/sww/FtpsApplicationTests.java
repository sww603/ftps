package com.sww;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FtpsApplicationTests {

  @Test
  public void contextLoads() {
    //ftp://39.106.140.104/home/test/gjc/
    Ftp f = new Ftp();
    f.setIpAddr("39.106.140.104");
    f.setUserName("test");
    f.setPwd("test");
    f.setPath("/home/test/sww/");
    f.setPort(21);
    try {
      FtpUtil.connectFtp(f);
    } catch (Exception e) {
      e.printStackTrace();
    }
    File file = new File("D:/images/774f52b29bc191f5b916d9405b7b0904_1.jpg");
    try {
      FtpUtil.upload(file);//把文件上传在ftp上
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("上传文件完成。。。。");
  }
}
