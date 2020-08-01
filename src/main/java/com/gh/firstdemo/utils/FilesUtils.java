package com.gh.firstdemo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/27 10:35
 */
public class FilesUtils {
    public static void main(String[] args) {
        String path = "C:\\uploadFiles";
        getFiles(path);
    }

    public static List<String> getFiles(String path) {
        List<String> list = new ArrayList<>();
        File fileDir = new File(path);
        // 判断是否是文件夹
        if (fileDir.isDirectory()) {
            File fileList[] = fileDir.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory()) {
                    list.addAll(getFiles(path));
                } else {
                    System.err.println(fileList[i].getPath());
                    list.add(fileList[i].getName());
                }
            }
        }
        return list;
    }
}
