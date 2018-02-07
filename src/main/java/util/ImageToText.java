package util;

import ocr.AipOcr;
import ocr.AuthService;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author: xiong
 * @time: 2018/02/02
 * @说明: 图片转文字类
 */
public class ImageToText {

    //设置APPID/AK/SK
    private static final String APP_ID = "10784806";
    private static final String API_KEY = "QYTlT1FQ3dhZ9yBZo4vGC3A4";
    private static final String SECRET_KEY = "ciX5vZxuO6n5mtsvoFAA64lzu5hnBk4t ";

    public static String getAddress(String file, String token) {
        AipOcr aipOcr = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        aipOcr.setAccess_token(token);

        // 可选：设置网络连接参数
        aipOcr.setConnectionTimeoutInMillis(2000);
        aipOcr.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //aipOcr.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //aipOcr.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("detect_direction", "false");
        options.put("probability", "false");

        // 调用接口
        JSONObject res = aipOcr.basicAccurateGeneral(file, options);
        System.out.println(res.toString(2));
        return res.toString(2);
    }

    public static void main(String[] args) {
        getAddress("","");
    }
}
