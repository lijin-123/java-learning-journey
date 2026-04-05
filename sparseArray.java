/**
 * ClassName: sparseArray
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2026/4/2 13:17
 * @Version 1.0
 */

public class sparseArray {
    //一个较少棋子的棋盘的存储,转化为稀疏数组,然后上电之后转化为棋盘
    //二维数组存为稀疏数组,稀疏数组里面是个二维表格,行: row col val 列:有几个值 1,2,3,4,5..
    //第一行 总共几行几列几个值 第二行记录每个值是第几个值,行号和列好和值
    //稀疏数组转二维数组就是读稀疏数组然后在二维数组中填充
    public static void main(String[] args) {


        //先创建一个二维数组代表棋盘,11*11,1表示黑子,2表示白子\
        int[][] chessArray = new int[11][11];
        chessArray[2][3] = 1;
        chessArray[2][4] = 2;
        chessArray[2][5] = 1;
        for (int[] row : chessArray) {
            for (int date : row) {
                System.out.printf("%d \t", date);
            }
            System.out.println();
        }

        //遍历二维数组,得到数组中二维数组的非零个数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                }
            }

        }
        System.out.println("count= " + count);
        //创建稀疏数组
        int[][] chessArray2 = new int[count+1][3];
        chessArray2[0][0] = 11;
        chessArray2[0][1] = 11;
        chessArray2[0][2] = count;
        //遍历二维数组,将非零的值存放在稀疏数组中
        //定义一个计数变量,用于跟着循环的遍历还让cheaaArray2跟着换行
        int sum = 1;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArray[i][j]!=0) {

                    chessArray2[sum][0] = i;
                    chessArray2[sum][1] = j;
                    chessArray2[sum][2] = chessArray[i][j];
                    sum++;
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到的是稀疏数组是");
        for(int i=0;i<chessArray2.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",chessArray2[i][0],chessArray2[i][1],chessArray2[i][2]);
        }

        System.out.println();
        //返回到二维数组
        //读取稀疏数组第一行得到二维数组
        int[][] chessArray3 = new int[chessArray2[0][0]][chessArray2[0][1]];
        for(int i=1;i<chessArray2[0][2];i++){
            chessArray3[chessArray2[i][0]][chessArray2[i][1]]=chessArray2[i][2];

        }
        //输出第二次的二维数组
        //还原的二维数组:
        System.out.println("还原度二维数组");
        for (int[] row : chessArray3) {
            for (int date : row) {
                System.out.printf("%d \t", date);
            }
            System.out.println();
        }
    }
}
