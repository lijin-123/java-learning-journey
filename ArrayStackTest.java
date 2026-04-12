/**
 * ClassName: Stack
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/9 8:22
 * @Version 1.0
 */
//栈是一种先进后出的线性表结构,有栈顶top,栈厎Bottom,size,可以用数组或者单向链表实现
// ,栈顶初始为第一个元素的前一个元素,后面指向最后一个元素前一个元素,栈厎指向第一个元素
public class ArrayStackTest {
    public static void main(String[] args) {
ArrayStack stack=new ArrayStack(5);
stack.push(1);
stack.push(2);
stack.push(3);
stack.show();
        System.out.println();
 int date=stack.pop();
stack.show();
    }
}

class ArrayStack {
    private int Max;
    private int top = -1;
    private int arraystack[];

    public int getMax() {
        return Max;
    }

    public ArrayStack(int Max) {
        this.Max = Max;

        this.arraystack = new int[Max];
    }

    //栈满
    public boolean isFull() {
        return top == Max - 1;
    }

    //占空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int data) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        arraystack[top]=data;
    }
    //出站
    public int pop() {
        if(isEmpty()){
            throw new  RuntimeException();
        }
        int datea=arraystack[top];
        top--;
        return datea;
    }
    //输出
    public void show(){
        if(isEmpty()){
            return ;

        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arraystack[i]+" ");
        }
    }
}

