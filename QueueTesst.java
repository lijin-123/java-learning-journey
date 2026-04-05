/**
 * ClassName: QueueTesst
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/3 11:34
 * @Version 1.0
 */
public class QueueTesst {
    private int[] arr;
    private int rear;
    private int front;
    private int MAX_SIZE;

    //构造器
    public QueueTesst(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        rear = -1;
        front = -1;
        arr = new int[MAX_SIZE];
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //判断是否为满
    public boolean isFull() {
        return rear + 1 == MAX_SIZE;
    }

    //入队
    public void enqueue(int date) {
        if (isFull()) {
            System.out.println("Queue is full");
            throw new RuntimeException("Queue is full");
        }
        rear++;
        arr[rear] = date;
    }

    //出兑
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");

        }
        front++;
        int result = arr[front];
        return result;
    }

    //取头部元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");

        }
        return arr[front + 1];

    }

    //输出
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d] = %d\n", i,arr[i]);
        }
    }

//    public static void main(String[] args) {
//        var queueTesst = new QueueTesst(5);
//        queueTesst.enqueue(1);
//        queueTesst.enqueue(2);
//        queueTesst.enqueue(3);
//        queueTesst.dequeue();
//        queueTesst.peek();
//        queueTesst.display();
//
//
//    }
}


