import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/3 17:14
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        //生成随机数[66,90]的整数
        int a = (int) ((1 + (Math.random()) * 99) + 1);
        Scanner sc = new Scanner(System.in);
        System.out.println("===============猜数字游戏开始================");
        System.out.println("如果6次之内猜对,那你运气很好");
        int count = 0;
        System.out.println();
        while (true) {
            System.out.println("猜测一个1到100的数,请输入:");
            System.out.println();
            int b = sc.nextInt();
            if (a == b) {
                count++;
                System.out.println("猜对了");
                System.out.println("猜测次数为" + count);
                break;
            } else {
                count++;
                System.out.println();
                System.out.print("猜错了,请重新输入");
                if (a > b) {
                    System.out.println(",而且你猜小了,已经猜测了" + count + "次");
                } else {
                    System.out.print(",而且你猜大,已经猜测了" + count + "次");
                }
            }
        }
        System.out.println("游戏结束");

    }
}
