package util;

/**
 * @author: xiong
 * @time: 2018/02/07
 * @说明: 地址类
 */
public class AddressUtil {
    public static int getXY(String str) {
        // 卡利姆多
        if (str.contains("阿斯特兰纳") || str.contains("羽月要塞") || str.contains("永夜港") || str.contains("永旺镇") ||
                str.contains("洛达内尔") || str.contains("加基森") || str.contains("拉穆卡恒") || str.contains("诺达希尔")
                || str.contains("语风林地") || str.contains("十字路口")) {
            return 1;
        }
        // 东部王国
        if (str.contains("卡拉诺斯") || str.contains("藏宝海湾") || str.contains("哨兵岭") || str.contains("布瑞尔") ||
                str.contains("斯通纳德") || str.contains("闪金镇") || str.contains("塔奎林") || str.contains("鹰巢山")
                || str.contains("塔伦米尔") || str.contains("米奈希尔港")) {
            return 2;
        }
        // 外域
        if (str.contains("加拉达尔") || str.contains("沙塔尔祭坛") || str.contains("奥蕾莉亚要塞") || str.contains("塞纳里奥庇护所") ||
                str.contains("荣耀堡") || str.contains("坂钳镇") || str.contains("52区") || str.contains("萨布拉金")
                || str.contains("希尔瓦纳") || str.contains("萨尔玛")) {
            return 3;
        }
        // 诺森德
        if (str.contains("卡玛古") || str.contains("欧尼瓦营地") || str.contains("银色前沿") || str.contains("战歌要塞") ||
                str.contains("无畏要塞") || str.contains("冰霜堡") || str.contains("征服堡") || str.contains("莫亚基岗哨")
                || str.contains("奈瓦辛里营地") || str.contains("龙眠神殿")) {
            return 4;
        }
        // 潘达利亚
        if (str.contains("雷霆裂口") || str.contains("龙鹰岗哨") || str.contains("闷水葫芦码头") || str.contains("晨芳园") ||
                str.contains("酒坛集") || str.contains("卡拉克西维斯") || str.contains("卓金村") || str.contains("半山")
                || str.contains("雄狮港") || str.contains("天禅院")) {
            return 5;
        }
        // 破碎群岛
        if (str.contains("灰色哨所") || str.contains("救赎岗哨") || str.contains("沙考尔巢穴") || str.contains("洛拉希尔") ||
                str.contains("雷霆图腾") || str.contains("瓦狄斯丹") || str.contains("鲑鱼溪") || str.contains("苍穹之角")
                || str.contains("梅瑞戴尔") || str.contains("蓝翼栖地")) {
            return 6;
        }
        return 0;
    }
}
