package util;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author: xiong
 * @time: 2018/02/02
 * @说明: 鼠标点击类
 */
public class MouseTouch {

    private static Robot robot;

    public static void Touch(String str) {
        String coordinate[] = str.split(",");
        int x = Integer.parseInt(coordinate[0]);
        int y = Integer.parseInt(coordinate[1]);
        if (robot == null) {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
        //模拟移动到当前鼠标位置
        robot.mouseMove(x, y);
        //模拟鼠标按下右键
        robot.mousePress(InputEvent.BUTTON3_MASK);
        //模拟鼠标松开右键
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public static void main(String[] args) {
        Touch("1000,1000");
    }

}
