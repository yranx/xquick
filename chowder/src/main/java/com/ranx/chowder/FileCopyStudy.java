package com.ranx.chowder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author ranx
 * @create 2018-08-31 14:25
 **/
public class FileCopyStudy {

    public static void main(String args[]) {
        String path = "F:/ranx.txt";

        String toPath = "F:/myfile";

        FileOutputStream fos = null;
        FileInputStream fis = null;

        try{
            fos = new FileOutputStream(path);

            File fi = new File(toPath);
            if (fi.exists()) {
            } else {
                fi.mkdir();
            }

            toPath = "F:/myfile/my.txt";
            String words = "my heart will go on";

            fos.write(words.getBytes());
            fis = new FileInputStream(path);

            fos.flush();;
            fos.close();

            fos = new FileOutputStream(toPath);

            byte[] bys = new byte[fis.available()];
            while (fis.read(bys) != -1) {
                fis.read(bys);
                fos.write(bys, 0 ,bys.length);
            }

            fis.close();

            fis = new FileInputStream(toPath);
            fis.read(bys);
            for (byte b : bys) {
                System.out.println((char)b);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
