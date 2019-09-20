package com.elife.util;

public class FileUtil {

    // 图片允许的后缀扩展名
    public static String[] IMAGE_FILE_EXTD = new String[] { "jpg", "png", "bmp", "jpeg" };

    public static boolean isFileAllowed(String fileName) {
        for (String ext : IMAGE_FILE_EXTD) {
            if (ext.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

}
