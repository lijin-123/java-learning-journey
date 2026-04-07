/**
 * ClassName: NodelList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/4 9:50
 * @Version 1.0
 */
public class NodelListTest {
    public static void main(String[] args) {
//创建节点
        Node hero = new Node("死歌", 1000);
        Node hero2 = new Node("豹女", 999);
        Node hero3 = new Node("男枪", 999);
        Node hero4 = new Node("死歌", 22);
        Node hero5 = new Node("盖伦", 342);
        NodeList list = new NodeList();
        list.add(hero);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        list.add(hero5);
        list.delete(hero2);
        list.display();
        //求有效节点个数
         //System.out.println(getLegth(NodeList.gethead()));

    }

    //或许到单链表的有效数据,带头结点的链表,需要不统计头结点
    public static int getLegth(Node head) {
        Node temp = head.next;
        int length = 0;
        while (true) {
            if (head.next == null) {
                System.out.println("空");
                break;
            } else if (temp.next != null) {
                length++;
                temp = temp.next;
            } else {
                break;

            }
        }
        return length;
    }
}


class Node {

    private String name;
    private int age;


    public Node next;

    //构造器
    public Node(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 提供getter，方便外部访问age（私有属性不能直接访问）
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name:" + name + ",age:" + age;
    }
}

//链表的管理
class NodeList {
   private Node head = new Node("", 0);
 public Node getHead() {
    return head;
 }
 public void setHeaad(Node head) {}
    //添加节点
    public void add(Node node) {
        Node temp = head;
        //找到队尾
        boolean flag = false;
        while (true) {

            if (temp.next == null) {
                break;
            }
            if (temp.next.getAge() == node.getAge()) {
                flag = true;
                break;
            }
            if (temp.next.getAge() > node.getAge()) {
                break;
            }
            temp = temp.next;
        }

        if (flag == true) {
            System.out.println("不能添加");
        } else {
            node.next = temp.next;
            temp.next = node;

        }
    }

    //修改名字
    public void update(Node node) {

        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                System.out.println("表为空");
            }
            if (temp.next.getName() == node.getName()) {
                break;
            }
            temp = temp.next;
        }
        if (flag == false) {
            System.out.println("没有找到要修改的英雄");
        } else {
            temp.next.setName(node.getName());
        }
    }

    //删除节点
    public void delete(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                System.out.println("没有找到");
                break;
            }
            if (temp.next.getName() == node.getName()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.next = temp.next.next;
        }
    }

    public void display() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //倒序输出链表,方式是先将链表的NODE压入栈,利用栈先进后出的原则,输出实现倒序
    /*
    public static void reversePrint(Node head) {
    if(head.next == null) {
        return;//空链表，不能打印
    }
    //创建要给一个栈，将各个节点压入栈
    Stack<Node> stack = new Stack<Node>();
    HeroNode cur = head.next;
    //将链表的所有节点压入栈
    while(cur != null) {
        stack.push(cur);
        cur = cur.next; //cur后移，这样就可以压入下一个节点
    }
    //将栈中的节点进行打印,pop 出栈
    while (stack.size() > 0) {
        System.out.println(stack.pop()); //stack的特点是先进
    }


}
     */
}




