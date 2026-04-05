/**
 * ClassName: QueueTEst2
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/3 15:16
 * @Version 1.0
 */

import java.util.Queue;
import java.util.Scanner;

public class QueueTEst2 {
    public static void main(String[] args) {
        QueueTesst arrayQueue = new QueueTesst(3);
        char key = ' ';
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        //输出一个菜单
        while (flag) {
            System.out.println("========打印菜单=========");
            System.out.println("S(show) 显示队列");
            System.out.println("e(exit)退出队列");
            System.out.println("a(add) 增加队列");
            System.out.println("g(get) 退出队列取数");
            System.out.println("h(headget)取得头部元素");
            key = scan.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.display();
                    break;
                case 'a':
                    int date = scan.nextInt();
                    arrayQueue.enqueue(date);
                    break;
                case 'd':
                    arrayQueue.dequeue();
                    break;
                case 'h':
                    arrayQueue.peek();
                    break;

                case 'e':
                    flag = false;
                    scan.close();

                    break;
                default:
                    System.out.println("输出信息有误");

            }


        }System.out.println("程序退出");

    }
}

/**这是一次性的队列,如果想要复用,就需要让他成为一个循环队列,关键就是加入一个取%的操作,
入队:(rear+1)%max=rear
 出兑:(front+1)%max=front
 队空:rear= front
 队满:(rear+1)%max=froat
 */
