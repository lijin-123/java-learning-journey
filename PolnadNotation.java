import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: PolnadNotation
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/12 10:33
 * @Version 1.0
 */

//中缀表达式转湖州最表达式
    /*
    * 需要两个栈,一个存运算符s1,一个存储中间结果s2
    * 从左到右扫描表达式,遇到树的时候压入s2
    * 遇到操作数,将其压入s2
    * 遇到s1没有符号压入为第一个符号,左括号也是同理
    * 遇到优先级比栈顶元素高的,压入
    * 遇到等于或者小雨栈顶元素优先级的符号,泽弹出S1的栈顶元素压入S2,再次转到从左到右的扫描,其中
    * 遇到左括号都是压入,遇到右括号都是依次弹出栈顶符号,知道遇到左括号,再扫描
    * 此时一直进行到表达式没有元素,此时再将S1d元素依次压入S2
    * 最后后缀表达式就是S2依次弹出的逆序
    * */
public class PolnadNotation {
    public static void main(String[] args) {
        
        //先定义一个逆波兰表达式
        String suffixExpresion = "3 4 + 5 * 5 * 6 -";//(3+4)*5*5-6=169
        List<String> list = expresionArraay(suffixExpresion);
        System.out.println("suffixExpresion" + list.toString());
        int res = expresionNotation(list);
        System.out.println("结果是" + res);
    }

    public static List<String> expresionArraay(String suffixExpresion) {
        String[] arr = suffixExpresion.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (String item : arr) {
            list.add(item);
        }
        return list;
    }

    public static int expresionNotation(List<String> list) {
        Stack<String> stack = new Stack<String>();

        for (String item : list) {

            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {

                    res = num1 + num2;
                } else if (item.equals("-")) {

                    res = num1 - num2;
                } else if (item.equals("*")) {

                    res = num1 * num2;

                } else if (item.equals("/")) {


                    try {
                        res = num1 / num2;
                    } catch (Exception e) {
                        System.out.println("0不能作为除数");
                    }
                } else {
                    throw new RuntimeException();
                }
                stack.push(res + "");
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
