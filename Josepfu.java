/**
 * ClassName: Josepfu
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/8 10:56
 * @Version 1.0
 *
 */

//约瑟夫问题,数小孩问题,一群环形小孩,从某个位置数几个数淘汰一个,知道最后剩下一个幸运儿

/**
 * 1 构建环形链表
 * 第一个节点自己指向自己
 * 后面每个节点：尾节点指向新节点，新节点指向头节点
 * 2. 让 helper 指向最后一个节点
 * helper 必须是 first 的前一个
 * 作用：删除节点时用来搭桥
 * 3. 移动到开始数数的位置
 * 从第 k 个开始，就移动 k-1 次
 * first 和 helper 一起走
 * 4. 循环出圈（核心）
 * 每次数 count-1 下
 * first 指向要删除的节点
 * 删除：first = first.next，helper.next = first
 * 直到 helper == first 结束
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLindedList  circleSingleLindedList=new CircleSingleLindedList();
        circleSingleLindedList.addBoy(5);
        circleSingleLindedList.showBoy();
        circleSingleLindedList.countBoy(5,2,1);
    }

}
//创建一个环形链表
class CircleSingleLindedList{
    private Boy first=null;
    public void addBoy(int num){
        if(num<1){
            System.out.println("传入数据不对");
            return;
        }
Boy curBoy=null;
        //创建我们的环形队列
        for(int i=1;i<=num;i++){
            //根据编号创建小孩节点
Boy boy=new Boy(i);
//第一个小孩
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    //遍历当前的环形列表
    public void showBoy(){
        if(first==null){
            System.out.println("链表为空");
        return;
        }
        Boy curBoy=first;
        while(true){
            System.out.println("小孩的标号是:"+curBoy.getData());
            if(curBoy.getNext()==first){

              break;
            }
           curBoy= curBoy.getNext( );
        }
    }
    /**
     * num:有几个小孩
     * count:数几下投太一个小孩
     * firstcount从第几个小孩开始数数
     */
    public void countBoy(int num,int count,int firstcount){
        if(num<1||firstcount>num||firstcount<1){
            System.out.println("输入有误,请重新输入");
            return;
        }
        Boy helper=first;
        while(true){

            if(helper.getNext()==first){
                break;
            }else {
                helper = helper.getNext();
            }
        }
            //利用两个指针节点书小孩
            for(int i=1;i<=firstcount-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            while(true){
                if(helper==first){
                    break;
                }else{
                    for(int i=1;i<=count-1;i++){
                        first=first.getNext();
                        helper=helper.getNext();
                    }
                    System.out.println(first.getData());
                    first=first.getNext();
                    helper.setNext(first);
                }
            }
            System.out.println("最后一个小孩的编号是"+first.getData());


    }
}

/**
 *
 *
 */
class Boy{
    private int data;
    private Boy next;

    public Boy(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}


