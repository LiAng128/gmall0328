package com.liang.gmall.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MyUploadUtils {

    public static String uploadImg(MultipartFile file){

        String path = MyUploadUtils.class.getClassLoader().getResource("tracker.conf").getPath();

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

        StorageClient storageClient = new StorageClient(connection, null);

        String originalFilename = file.getOriginalFilename();

        int lastIndexOf = originalFilename.lastIndexOf(".");

        String ext_name = originalFilename.substring(lastIndexOf + 1);

        String[] jpgs = null;
        try {
            jpgs = storageClient.upload_file(file.getBytes(), ext_name, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        String url = "http://192.168.91.100";

        for (String jpg : jpgs) {

            url = url + "/" + jpg;

        }

        return url;

    }

}
