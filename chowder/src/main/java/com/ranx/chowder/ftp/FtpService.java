package com.ranx.chowder.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description ftp服务
 * @author ranx
 * @date 2018年11月19日 下午3:19:13
 *
 * 主要用的是 commons-net
 */
public class FtpService {
    private final static Logger logger = LoggerFactory.getLogger(FtpService.class);
    //	@Value("${ftp.host}")
    private String host = "172.16.16.107";
    //	@Value("${ftp.port}")
    private Integer port = 21;
    //	@Value("${ftp.username}")
    private String username = "linkFTP";
    //	@Value("${ftp.password}")
    private String password = "linkFTP";

    private FTPClient ftpClient = null;

    // 初始化ftp服务器
    public void initFtpClient() {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            logger.info("connecting...Ftp Server:" + this.host + ":" + this.port);
            if (port == null) {
                port = 21;
            }
            // 连接ftp服务器
            ftpClient.connect(host, port);
            // 登陆
            ftpClient.login(username, password);
            // 是否成功登录
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("connecting...Ftp Server:" + this.host + ":" + this.port + " Failed");
                ftpClient.disconnect();
            }
            System.out.println("connecting...Ftp Server:" + this.host + ":" + this.port + " Successed");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     *
     * @param pathName       ftp服务保存地址
     * @param filaName       上传到ftp的文件名
     * @param originfileName 待上传文件的名称（绝对地址）
     * @return
     */
    public boolean uploadFile(String pathName, String filaName, String originfileName) {
        boolean flag = false;
        InputStream inputStream = null;
        try {
            logger.info("Start Upload File.");
            inputStream = new FileInputStream(new File(originfileName));
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathName);
            ftpClient.makeDirectory(pathName);
            ftpClient.changeWorkingDirectory(pathName);
            ftpClient.storeFile(filaName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("Upload File Success.");
            logger.info("Upload File Success.");
        } catch (Exception e) {
            System.out.println("Upload File fail.");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 上传文件
     *
     * @param pathName    ftp服务保存地址
     * @param filaName    上传到ftp的文件名
     * @param inputStream 输入文件流
     * @return
     */
    public boolean uploadFileStream(String pathName, String filaName, InputStream inputStream) {
        boolean flag = false;
        try {
            logger.info("Start Upload File.");
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathName);
            ftpClient.makeDirectory(pathName);
            ftpClient.changeWorkingDirectory(pathName);
            ftpClient.storeFile(filaName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("Upload File Success.");
            logger.info("Upload File Success.");
        } catch (Exception e) {
            System.out.println("Upload File fail.");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 下载文件
     *
     * @param pathName  FTP服务器文件目录
     * @param fileName  文件名称
     * @param localPath 下载后文件地址
     * @return
     */
    public boolean downloadFile(String pathName, String fileName, String localPath) {
        boolean flag = false;
        OutputStream os = null;
        try {
            logger.info("Start Download File.");
            initFtpClient();
//			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 切换FTP目录
            ftpClient.changeWorkingDirectory(pathName);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile ftpFile : ftpFiles) {
                if (fileName.equalsIgnoreCase(ftpFile.getName())) {
                    File localFile = new File(localPath + "/" + ftpFile.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(ftpFile.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            System.out.println("DownLoad File Success.");
            logger.info("DownLoad File Success.");
        } catch (Exception e) {
            System.out.println("DownLoad File fail.");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * 删除文件
     *
     * @param pathName
     * @param fileName
     * @return
     */
    public boolean deleteFile(String pathName, String fileName) {
        boolean flag = false;
        try {
            logger.info("Start Download File.");
            initFtpClient();
            // 切换FTP目录
            ftpClient.changeWorkingDirectory(pathName);
            // 删除
            ftpClient.dele(fileName);
            ftpClient.logout();
            flag = true;
            System.out.println("Delete File Success.");
            logger.info("Delete File Success.");
        } catch (Exception e) {
            System.out.println("Delete File fail.");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return flag;
    }

    /**
     * 移动文件
     * @param pathName
     * @param fileName
     * @return
     */
    public boolean removeFile(String pathName, String fileName, String newPath) {
        boolean flag = false;
        try {
            logger.info("Start Remove File.");
            initFtpClient();
            /* 注意，移动文件要在同一级目录*/
            CreateDirecroty(newPath);
            // 切换FTP根目录（传过来目录的同一父目录？）
            ftpClient.changeWorkingDirectory("/");
            // 移动
//			ftpClient.sendCommand(FTPCmd.RNFR,pathName+ "/"+ fileName);
//			ftpClient.sendCommand(FTPCmd.RNTO,newPath+"/"+ fileName);
            ftpClient.rename(pathName+ "/"+ fileName, newPath + "/"+ fileName);
            ftpClient.logout();
            flag = true;
            System.out.println("Remove File Success.");
            logger.info("Remove File Success.");
        } catch (Exception e) {
            System.out.println("Remove File fail.");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return flag;
    }

    /**
     * 创建多层目录文件，如果ftp服务器已存在该文件，则不创建;如果无，则创建
     *
     * @return
     */
    private boolean CreateDirecroty(String remote) throws Exception {
        boolean success = true;
        String directory = remote + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!"/".equalsIgnoreCase(directory) && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    /**
     * 改变目录路径
     */
    private boolean changeWorkingDirectory(String directory) {
        boolean flag = true;
        try {
            // Change the current working directory of the FTP session.
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("进入文件夹" + directory + " 成功！");
            } else {
                System.out.println("进入文件夹" + directory + " 失败！ 开始创建文件夹");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    // 判断ftp服务器是否存在
    private boolean existFile(String path) throws Exception {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    // 创建目录
    private boolean makeDirectory(String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");
            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    // 获取ftp上文件的最后修改时间
    public String getFileLastModifiedTime(String path) {
        Date lastModifiedDate = null;
        initFtpClient();
        // 获取ftp上path路径下的文件
        FTPFile[] fileList;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        try {
            fileList = ftpClient.listFiles(path);
            for (int i = 0; i < fileList.length; i++) {
                lastModifiedDate = fileList[i].getTimestamp().getTime();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dateFormat.format(lastModifiedDate);
    }

    public Map getAllFileLastModifiedTime(String path) {
        Date lastModifiedDate = null;
        initFtpClient();
        // 获取ftp上path路径下的文件
        FTPFile[] fileList;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        try {
            fileList = ftpClient.listFiles(path);
            Map map = new HashMap(fileList.length);
            for (int i = 0; i < fileList.length; i++) {
                lastModifiedDate = fileList[i].getTimestamp().getTime();
                map.put(fileList[i].getName(), dateFormat.format(lastModifiedDate));
            }
            return map;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        FtpService ftp = new FtpService();
//         ftp.uploadFile("ftpFile/data", "ftpTest.txt", "D://logs//elink-ivpn-openapi//info.log");
//         ftp.downloadFile("ftpFile/data", "ftpTest.txt", "D://logs//");
//         ftp.deleteFile("ftpFile/data", "ftpTest.txt");

//		String path = "ftpFile/data/ftpTest.txt";
//		System.out.println(path + " : " + ftp.getFileLastModifiedTime(path));
//         System.out.println(ftp.getAllFileLastModifiedTime("ftpFile/data/"));
        ftp.removeFile("ftpFile/data", "ftpTest.txt", "ftpFile/bak");
        System.out.println("=====end======");
    }
}

