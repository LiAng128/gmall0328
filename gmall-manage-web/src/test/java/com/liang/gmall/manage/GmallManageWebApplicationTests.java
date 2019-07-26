package com.liang.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

	@Test
	public void contextLoads() {

		String path = GmallManageWebApplicationTests.class.getClassLoader().getResource("tracker.conf").getPath();

		try {
			ClientGlobal.init(path);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}

		TrackerClient trackerClient = new TrackerClient();

		TrackerServer connection = null;
		try {
			connection = trackerClient.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		StorageClient storageClient = new StorageClient();

		String[] jpgs = null;
		try {
			jpgs = storageClient.upload_file("C:/Users/Liangjianjun/Pictures/imgs/1.jpg", "jpg", null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}

		String url = "http://192.168.91.100";

		for (String jpg : jpgs) {

			url = url + "/" + jpg;

		}

		System.err.println(url);

	}

}
