package activity;

import bean.ImageBean;
import ocr.AuthService;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: xiong
 * @time: 2018/02/02
 * @说明: 主界面
 */
public class Main {

    //设置APPID/AK/SK
    private static final String API_KEY = "QYTlT1FQ3dhZ9yBZo4vGC3A4";
    private static final String SECRET_KEY = "ciX5vZxuO6n5mtsvoFAA64lzu5hnBk4t ";

    // token
    private static String BAIDU_TOKEN = "";

    // 鼠标X,Y Label
    private static JLabel value_x;
    private static JLabel value_y;

    // 输入坐标
    private static String klmd;
    private static String dbwg;
    private static String wy;
    private static String nsd;
    private static String pdly;
    private static String psqd;


    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);

        initMouseInfo();
    }

    /**
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        // 创建及设置窗口
        JFrame frame = new JFrame("Hello,World");
        frame.setSize(310, 400);
        // 在屏幕中间启动
//        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 添加面板
        JPanel panel = new JPanel();
        frame.add(panel);

        // 初始化窗口
        initPanel(panel);

        // 显示窗口
        frame.setVisible(true);
    }

    private static void initPanel(JPanel panel) {
        panel.setLayout(null);

        initMousePanel(panel);
        initToken(panel);
        initCoordinate(panel);
        initStart(panel);
    }

    /**
     * 初始化Token
     */
    private static void initToken(JPanel panel) {
        // text
        JLabel tokenLabel = new JLabel("请获取百度token");
        tokenLabel.setBounds(10, 20, 100, 25);
        panel.add(tokenLabel);

        // button
        JButton tokenButton = new JButton("获取token");
        tokenButton.setBounds(10, 50, 100, 25);
        // 点击获取百度云token
        tokenButton.addActionListener(e -> {
            BAIDU_TOKEN = AuthService.getAuth(API_KEY, SECRET_KEY);
            tokenLabel.setText("已获取到百度token");
        });
        panel.add(tokenButton);
    }

    /**
     * 鼠标坐标布局
     */
    private static void initMousePanel(JPanel panel) {
        JLabel jLbx = new JLabel("坐标x:");
        jLbx.setBounds(200, 20, 45, 25);
        panel.add(jLbx);

        value_x = new JLabel("0");
        value_x.setForeground(Color.BLUE);
        value_x.setBounds(250, 20, 50, 25);
        panel.add(value_x);

        JLabel jLby = new JLabel("坐标y:");
        jLby.setBounds(200, 50, 45, 25);
        panel.add(jLby);

        value_y = new JLabel("0");
        value_y.setForeground(Color.BLUE);
        value_y.setBounds(250, 50, 50, 25);
        panel.add(value_y);
    }

    /**
     * 获取鼠标坐标
     */
    private static void initMouseInfo() {
        try {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
                    Main.value_x.setText("" + point.x);
                    Main.value_y.setText("" + point.y);
                }
            }, 100, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化坐标点
     */
    private static void initCoordinate(JPanel panel) {
        JLabel coordinateLabel = new JLabel("请输入坐标(X,Y)");
        coordinateLabel.setBounds(10, 120, 100, 25);
        panel.add(coordinateLabel);

        JLabel KLabel = new JLabel("卡利姆多");
        KLabel.setBounds(10, 150, 100, 25);
        panel.add(KLabel);

        JLabel DLabel = new JLabel("东部王国");
        DLabel.setBounds(110, 150, 100, 25);
        panel.add(DLabel);

        JLabel WLabel = new JLabel("外域");
        WLabel.setBounds(210, 150, 100, 25);
        panel.add(WLabel);

        JLabel NLabel = new JLabel("诺森德");
        NLabel.setBounds(10, 210, 100, 25);
        panel.add(NLabel);

        JLabel PLabel = new JLabel("潘达利亚");
        PLabel.setBounds(110, 210, 100, 25);
        panel.add(PLabel);

        JLabel PoLabel = new JLabel("破碎群岛");
        PoLabel.setBounds(210, 210, 100, 25);
        panel.add(PoLabel);

        // edit
        JTextField KText = new JTextField("");
        KText.setBounds(10, 180, 70, 25);
        panel.add(KText);

        JTextField DText = new JTextField("");
        DText.setBounds(110, 180, 70, 25);
        panel.add(DText);

        JTextField WText = new JTextField("");
        WText.setBounds(210, 180, 70, 25);
        panel.add(WText);

        JTextField NText = new JTextField("");
        NText.setBounds(10, 240, 70, 25);
        panel.add(NText);

        JTextField PText = new JTextField("");
        PText.setBounds(110, 240, 70, 25);
        panel.add(PText);

        JTextField PoText = new JTextField("");
        PoText.setBounds(210, 240, 70, 25);
        panel.add(PoText);

        JButton coordinateButton = new JButton("确认坐标");
        coordinateButton.setBounds(10, 270, 100, 25);

        coordinateButton.addActionListener(e -> {
            klmd = KText.getText();
            dbwg = DText.getText();
            wy = WText.getText();
            nsd = NText.getText();
            pdly = PText.getText();
            psqd = PoText.getText();
        });
        panel.add(coordinateButton);
    }

    /**
     * 开始
     */
    private static void initStart(JPanel panel) {
        JLabel ResLabel = new JLabel("");
        ResLabel.setBounds(10, 360, 1000, 40);
        panel.add(ResLabel);

        JButton startButton = new JButton("开始识别");
        startButton.setBounds(10, 320, 270, 30);

        startButton.addActionListener(e -> {
            // 生成图片地址
            String str = System.currentTimeMillis() + ".png";
            ImageBean data = new ImageBean();
            StringBuilder address = new StringBuilder();
            try {
                // 截图
                Screenshots.captureScreen(str);
                // 向百度发送请求,返回识别字符串
                data = GsonUtil.getInstance().json2Bean(ImageToText.getAddress(Screenshots.ImageFile + str, BAIDU_TOKEN), ImageBean.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // 遍历拼接字符
            for (ImageBean.WordsResultBean wordsResultBean : data.getWords_result()) {
                address.append(wordsResultBean.getWords());
            }
            ResLabel.setText(address.toString());
            // 拿到字符串去判断,点击
            switch (AddressUtil.getXY(address.toString())){
                case 1:
                    MouseTouch.Touch(klmd);
                    break;
                case 2:
                    MouseTouch.Touch(dbwg);
                    break;
                case 3:
                    MouseTouch.Touch(wy);
                    break;
                case 4:
                    MouseTouch.Touch(nsd);
                    break;
                case 5:
                    MouseTouch.Touch(pdly);
                    break;
                case 6:
                    MouseTouch.Touch(psqd);
                    break;
            }
        });
        panel.add(startButton);
    }
}