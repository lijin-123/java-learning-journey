import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组栈的中缀表达式计算器
 * 支持加减乘除运算和括号
 */
public class InfixExpressionCalculator {

    /**
     * 数组栈实现类
     */
    static class ArrayStack {
        private int maxSize;    // 栈的最大容量
        private int[] stack;    // 数组存储栈元素
        private int top;        // 栈顶指针，-1表示空栈

        /**
         * 构造函数，初始化栈
         *  maxSize 栈的最大容量
         */
        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new int[maxSize];
            this.top = -1;
        }

        /**
         * 判断栈是否已满
         */
        public boolean isFull() {
            return top == maxSize - 1;
        }

        /**
         * 判断栈是否为空
         */
        public boolean isEmpty() {
            return top == -1;
        }

        /**
         * 入栈操作
         *  value 要入栈的值
         */
        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("栈已满，无法入栈");
            }
            top++;
            stack[top] = value;
        }

        /**
         * 出栈操作
         * 栈顶元素
         */
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈为空，无法出栈");
            }
            int value = stack[top];
            top--;
            return value;
        }

        /**
         * 查看栈顶元素（不出栈）
         * 栈顶元素
         */
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return stack[top];
        }

        /**
         * 获取栈的大小
         */
        public int size() {
            return top + 1;
        }
    }

    /**
     * 判断字符是否为运算符
     * ch 字符
     *  true表示是运算符
     */
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * 获取运算符的优先级
     *operator 运算符
     * 优先级数值，数字越大优先级越高
     */
    private static int getPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    /**
     * 执行具体的计算
     * num1 第一个操作数
     *  num2 第二个操作数
     *   operator 运算符
     * @return 计算结果
     */
    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("除数不能为0");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("不支持的运算符: " + operator);
        }
    }

    /**
     * 计算中缀表达式
     *  expression 中缀表达式字符串
     * 计算结果
     */
    public static int evaluate(String expression) {
        // 去除表达式中的所有空格
        expression = expression.replaceAll("\\s+", "");

        // 创建操作数栈和运算符栈
        ArrayStack numStack = new ArrayStack(100);  // 操作数栈
        ArrayStack operatorStack = new ArrayStack(100); // 运算符栈

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            // 如果是数字这里要判断是不是数字和字符
            if (Character.isDigit(ch)) {
                // 解析多位数
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                int num = Integer.parseInt(numStr.toString());
                numStack.push(num);
                continue; // 已经移动了索引，跳过最后的i++,说明已经要找符号
            }
            // 如果是左括号
            else if (ch == '(') {
                operatorStack.push(ch);
            }
            // 如果是右括号
            else if (ch == ')') {
                // 计算括号内的表达式，直到遇到左括号
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    char operator = (char) operatorStack.pop();
                    int result = calculate(num1, num2, operator);
                    numStack.push(result);
                }
                // 弹出左括号
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();
                } else {
                    throw new IllegalArgumentException("括号不匹配");
                }
            }
            // 如果是运算符
            else if (isOperator(ch)) {
                // 当前运算符优先级小于等于栈顶运算符优先级时，先计算栈顶运算符
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    char topOp = (char) operatorStack.peek();
                    if (getPriority(topOp) >= getPriority(ch)) {
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        char operator = (char) operatorStack.pop();
                        int result = calculate(num1, num2, operator);
                        numStack.push(result);
                    } else {
                        break;
                    }
                }
                // 当前运算符入栈
                operatorStack.push(ch);
            }
            else {
                throw new IllegalArgumentException("无效字符: " + ch);
            }
            i++;
        }

        // 处理剩余的运算符
        while (!operatorStack.isEmpty()) {
            char operator = (char) operatorStack.pop();
            // 不应该还有括号
            if (operator == '(' || operator == ')') {
                throw new IllegalArgumentException("括号不匹配");
            }
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            int result = calculate(num1, num2, operator);
            numStack.push(result);
        }

        // 最终结果在操作数栈中
        if (numStack.size() != 1) {
            throw new IllegalArgumentException("表达式无效");
        }

        return numStack.pop();
    }

    /**
     * 主方法，用于测试
     */
    public static void main(String[] args) {
        System.out.println("ddjs\ssjdk");
        // 测试用例
        String[] expressions = {
                "3+5",           // 8
                "10-2*3",        // 4 (先乘后减)
                "(1+2)*3",       // 9
                "100/4+2*3",     // 25+6=31
                "((1+2)*3+4)/2", // ((3)*3+4)/2 = (9+4)/2 = 13/2 = 6
                "12+34-56/7",    // 12+34-8=38
                "2*3+4*5"        // 6+20=26
        };

        for (String expr : expressions) {
            try {
                int result = evaluate(expr);
                System.out.println(expr + " = " + result);
            } catch (Exception e) {
                System.out.println(expr + " 计算错误: " + e.getMessage());
            }
        }

        // 复杂表达式测试
        String complexExpr = "3*(4+5)-6/2+8";
        System.out.println("\n复杂表达式: " + complexExpr + " = " + evaluate(complexExpr));
        // 预期: 3*9-3+8 = 27-3+8 = 32
    }
}