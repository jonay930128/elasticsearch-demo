package wrx.xing;

import org.junit.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo01 {

    @Test
    public void zipFile() throws Exception {    // 所有异常抛出
        File file = new File("d:" + File.separator + "mldn.txt");    // 定义要压缩的文件
        File zipFile = new File("d:" + File.separator + "mldn.zip");    // 定义压缩文件名称
        InputStream input = new FileInputStream(file);    // 定义文件的输入流
        ZipOutputStream zipOut = null;    // 声明压缩流对象
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName()));    // 设置ZipEntry对象
        zipOut.setComment("www.mldnjava.cn");    // 设置注释
        int temp = 0;
        byte[] bytes = new byte[1024];
        while ((temp = input.read(bytes)) != -1) {    // 读取内容
            zipOut.write(temp);    // 压缩输出
        }
        input.close();    // 关闭输入流
        zipOut.close();    // 关闭输出流
    }

    @Test
    public void zipDir() throws IOException {
        File file = new File("d:" + File.separator + "mldn") ;	// 定义要压缩的文件夹
        File zipFile = new File("d:" + File.separator + "mldndir.zip") ;	// 定义压缩文件名称
        InputStream input = null ;	// 定义文件输入流
        ZipOutputStream zipOut = null ;	// 声明压缩流对象
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile)) ;
        zipOut.setComment("www.mldnjava.cn") ;	// 设置注释
        int temp = 0 ;
        if(file.isDirectory()){	// 判断是否是文件夹
            File lists[] = file.listFiles() ;	// 列出全部文件
            for(int i=0;i<lists.length;i++){
                input = new FileInputStream(lists[i]) ;	// 定义文件的输入流
                zipOut.putNextEntry(new ZipEntry(file.getName()
                        +File.separator+lists[i].getName())) ;	// 设置ZipEntry对象
                while((temp=input.read())!=-1){	// 读取内容
                    zipOut.write(temp) ;	// 压缩输出
                }
                input.close() ;	// 关闭输入流
            }
        }
        zipOut.close() ;	// 关闭输出流

    }

    @Test
    public void getZipName() throws IOException {
        File file = new File("d:" + File.separator + "mldn.zip") ;	// 找到压缩文件
        ZipFile zipFile = new ZipFile(file) ;	// 实例化ZipFile对象
        System.out.println("压缩文件的名称：" + zipFile.getName()) ;	// 得到压缩文件的名称
    }
}
