package cn.chachae.se.circle2;

/**
 * @author chachae
 * @date 2019/10/16 13:06
 */
public class Test {
    /**
     * 主函数
     *
     * @param args 主函数入参
     */
    public static void main(String[] args) {
        Circle circle = new Circle(20);
        Circular circular = new Circular(circle.getArea(), 10);
        System.out.println("底面积：" + circle.getArea());
        System.out.println("体积：" + circular.getVolume());
    }
}
