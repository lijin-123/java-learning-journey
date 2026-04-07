// 节点类（命名为 NodeNode）
class NodeNode {
    int data;
    NodeNode prev;
    NodeNode next;

    public NodeNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// 带头结点的双向链表类
class DoublyLinkedListWithHead {
    private NodeNode head;  // 头结点（不存储实际数据）
    private NodeNode tail;
    private int size;

    public DoublyLinkedListWithHead() {
        // 创建头结点，数据为默认值0
        this.head = new NodeNode(0);
        this.tail = head;
        this.size = 0;
    }

    // 1. 在末尾添加节点
    public void add(int data) {
        NodeNode newNode = new NodeNode(data);

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

        size++;
        System.out.println("添加节点: " + data);
    }

    // 2. 在头部添加节点（头结点之后）
    public void addFirst(int data) {
        NodeNode newNode = new NodeNode(data);
        NodeNode firstNode = head.next;

        newNode.next = firstNode;
        newNode.prev = head;

        if (firstNode != null) {
            firstNode.prev = newNode;
        } else {
            // 如果链表为空，tail指向新节点
            tail = newNode;
        }

        head.next = newNode;
        size++;
        System.out.println("在头部添加节点: " + data);
    }

    // 3. 在指定位置添加节点
    public void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("索引无效，无法添加！");
            return;
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            add(data);
        } else {
            NodeNode newNode = new NodeNode(data);
            NodeNode current = head.next;

            // 找到要插入位置的节点
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            // 插入节点
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;

            size++;
            System.out.println("在位置 " + index + " 添加节点: " + data);
        }
    }

    // 4. 删除指定值的节点
    public void remove(int data) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！");
            return;
        }

        NodeNode current = head.next;

        while (current != null) {
            if (current.data == data) {
                // 找到要删除的节点
                current.prev.next = current.next;

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    // 删除的是尾节点
                    tail = current.prev;
                }

                size--;
                System.out.println("删除节点: " + data);
                return;
            }
            current = current.next;
        }
        System.out.println("未找到值为 " + data + " 的节点！");
    }

    // 5. 删除指定位置的节点
    public void removeAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！");
            return;
        }

        if (index < 0 || index >= size) {
            System.out.println("索引无效，无法删除！");
            return;
        }

        NodeNode current = head.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // 删除节点
        current.prev.next = current.next;

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
        System.out.println("删除位置 " + index + " 的节点: " + current.data);
    }

    // 6. 删除第一个节点
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！");
            return;
        }

        NodeNode firstNode = head.next;
        head.next = firstNode.next;

        if (firstNode.next != null) {
            firstNode.next.prev = head;
        } else {
            tail = head;
        }

        size--;
        System.out.println("删除第一个节点: " + firstNode.data);
    }

    // 7. 删除最后一个节点
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！");
            return;
        }

        NodeNode lastNode = tail;
        tail = tail.prev;
        tail.next = null;

        size--;
        System.out.println("删除最后一个节点: " + lastNode.data);
    }

    // 8. 正向打印链表
    public void printForward() {
        if (isEmpty()) {
            System.out.println("链表为空！");
            return;
        }

        System.out.print("正向打印链表: head <-> ");
        NodeNode current = head.next;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println(" <-> null");
    }

    // 9. 反向打印链表
    public void printBackward() {
        if (isEmpty()) {
            System.out.println("链表为空！");
            return;
        }

        System.out.print("反向打印链表: null <-> ");
        NodeNode current = tail;
        while (current != head) {
            System.out.print(current.data);
            if (current.prev != head) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println(" <-> head");
    }

    // 10. 打印完整链表（包括头结点）
    public void printFullList() {
        System.out.print("完整链表（含头结点）: ");
        NodeNode current = head;
        while (current != null) {
            if (current == head) {
                System.out.print("[HEAD:" + current.data + "]");
            } else {
                System.out.print(" -> " + current.data);
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }

    // 11. 获取链表大小
    public int getSize() {
        return size;
    }

    // 12. 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 13. 清空链表
    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
        System.out.println("链表已清空！");
    }

    // 14. 查找节点
    public boolean contains(int data) {
        NodeNode current = head.next;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 15. 获取第一个节点数据
    public Integer getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.data;
    }

    // 16. 获取最后一个节点数据
    public Integer getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }
}

// 测试类
public class DoublyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("=== 带头结点的双向链表测试程序（节点类名: NodeNode）===\n");

        // 创建带头结点的双向链表对象
        DoublyLinkedListWithHead list = new DoublyLinkedListWithHead();

        // 测试1: 创建节点并添加
        System.out.println("【测试1】创建节点并添加:");
        System.out.println("创建节点: 10, 20, 30, 40, 50");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("当前链表大小: " + list.getSize());
        list.printForward();
        System.out.println();

        // 测试2: 在头部添加
        System.out.println("【测试2】在头部添加节点:");
        System.out.println("在头部添加: 5, 1");
        list.addFirst(5);
        list.addFirst(1);
        list.printForward();
        System.out.println("第一个节点: " + list.getFirst());
        System.out.println("最后一个节点: " + list.getLast());
        System.out.println("当前大小: " + list.getSize());
        System.out.println();

        // 测试3: 在指定位置添加
        System.out.println("【测试3】在指定位置添加节点:");
        System.out.println("在位置2添加: 15");
        list.addAtIndex(2, 15);
        System.out.println("在位置5添加: 35");
        list.addAtIndex(5, 35);
        list.printForward();
        System.out.println();

        // 测试4: 删除指定值节点
        System.out.println("【测试4】删除指定值节点:");
        System.out.println("删除: 30");
        list.remove(30);
        System.out.println("删除: 1");
        list.remove(1);
        list.printForward();
        System.out.println();

        // 测试5: 删除指定位置节点
        System.out.println("【测试5】删除指定位置节点:");
        System.out.println("删除位置2的节点");
        list.removeAtIndex(2);
        System.out.println("删除位置0的节点");
        list.removeAtIndex(0);
        list.printForward();
        System.out.println();

        // 测试6: 删除首尾节点
        System.out.println("【测试6】删除首尾节点:");
        System.out.println("删除第一个节点");
        list.removeFirst();
        System.out.println("删除最后一个节点");
        list.removeLast();
        list.printForward();
        System.out.println();

        // 测试7: 反向打印
        System.out.println("【测试7】反向打印链表:");
        list.printBackward();
        System.out.println();

        // 测试8: 完整链表结构
        System.out.println("【测试8】完整链表结构:");
        list.printFullList();
        System.out.println();

        // 测试9: 查找节点
        System.out.println("【测试9】查找节点:");
        System.out.println("链表中是否包含 20? " + list.contains(20));
        System.out.println("链表中是否包含 100? " + list.contains(100));
        System.out.println();

        // 测试10: 再次添加节点
        System.out.println("【测试10】再次添加节点:");
        list.add(60);
        list.add(70);
        list.addFirst(0);
        list.printForward();
        System.out.println();

        // 测试11: 清空链表
        System.out.println("【测试11】清空链表:");
        list.clear();
        System.out.println("清空后链表大小: " + list.getSize());
        list.printForward();
        list.printFullList();
    }
}