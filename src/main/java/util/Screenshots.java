package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author: xiong
 * @time: 2018/02/06
 * @说明: 截图类
 */
public class Screenshots {

    public static final String ImageFile = "D:\\Xiong955\\";

    public static void captureScreen(String folder) throws Exception {
        // Dimension定义图片的尺寸,Toolkit 定义的一些方法能直接查询本机操作系统。该句的意义就是获得系统屏幕尺寸，保存的Dimension类型的screenSize里面
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Rectangle 指定了坐标空间中的一个区域,根据宽度和高度可以定义一个区域
        Rectangle screenRectangle = new Rectangle(screenSize);
        // 此类用于为测试自动化、自运行演示程序和其他需要控制鼠标和键盘的应用程序生成本机系统输入事件。
        Robot robot = new Robot();
        // robot的对象的creatScreenCapture方法的作用就是创建包含从屏幕中读取的像素的图像。该图像不包括鼠标光标。然后将读取的图像赋给image对象。
        BufferedImage image = robot.createScreenCapture(screenRectangle);

        // 保存路径，将image对象保存为图像文件
        // 创建文件夹
        File screenFile = new File(ImageFile);
        //判断文件夹是否存在
        if (!screenFile.exists()) {
            //创建此抽象路径名指定的目录。
            screenFile.mkdir();
        }

        //根据文件夹对象和文件名及格式，创建文件
        File f = new File(screenFile, folder);
        //使用支持给定格式的任意 ImageWriter 将一个图像写入 File。如果已经有一个 File 存在，则丢弃其内容。
        // 期中第一个是图像内存数据，第二个是文本格式，第三个就是文件对象（也可以是数据流，但这里要写文件，所以用文件流）
        ImageIO.write(image, "png", f);
        //自动打开
         /* 在Jdk1.6以后新增加了一个类--DeskTop:The Desktop class allows a Java application to
         launch associated applications registered on the native desktop to handle a URI or a file.*/
        // isDesktopSupported:Tests whether this class is supported on the current platform.
        // isSupported: Tests whether an action is supported on the current platform.
        // Action:Represents an action type.加上.open就是名是判断能否打开，返回true
        // getDesktop():Returns the Desktop instance of the current browser context;

//        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
//            //获得Desktop对象，进行打开操作，打开的对象是文件对象
//            Desktop.getDesktop().open(f);
    }

    public static void main(String[] args) {
        try {
            captureScreen(System.currentTimeMillis() + ".png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
