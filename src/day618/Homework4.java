package day618;

import java.util.Scanner;

public class Homework4 {

    /*  从键盘输入8个整数存放在一个数组中
    然后将奇数和偶数分别存入两个不同的数组中，
    并按奇数，偶数交替的顺序输出这两个数组中的所有数据
    先交替输出，如果奇数个数多，则再输出剩下的奇数；如果偶数个数多，则再输出剩下的偶数。
    提示与要求：
   （1）定义一个数组存储从键盘输入的8个整数，先判断这8个整数中奇数和偶数的个数，
    才能定义存储奇数和偶数的数组的长度；
   （2）把一个大的数组分别存放在奇数和偶数数组中并交替输出的过程定义为方法
     */

    public static void main(String[] args) {

        //取数部分
        //为八个整数数组声明并分配空间
        int [] num = new int[8];
        //使用for循环从键盘接收输入的整数
        System.out.println("请输入8个整数：");
        Scanner input=new Scanner(System.in);
        for (int i=0;i<num.length;i++){
            num[i] = input.nextInt();
        }

        //判断部分
        //声明记录数组jiOu用以接收panDuan方法的返回值
        int [] jiOu = new int [2];
        //接收以获取奇偶个数
        jiOu = panDuan(num);
        //分别使用j，o变量接收奇数个数，偶数个数
        int j = jiOu[0];
        int o = jiOu[1];

        //分开存储部分
        //声明jiShu，ouShu数组，并为其分配内存空间
        // 同时调用fenCun方法--将奇偶数分开存放
        int [] jiShu = fenCun(num,jiOu)[0];
        int [] ouShu = fenCun(num,jiOu)[1];
//        jiShu = fenCun(num,jiOu)[0];
//        ouShu = fenCun(num,jiOu)[1];

        //输出部分
        shuChu(jiShu,ouShu);
    }

    //输出函数--将奇偶数组交替输出
    private static void shuChu(int[] jiShu, int[] ouShu) {
        //声明max，min变量--分别保存最大数组长度，最小数组长度
        int max;
        int min;
//        int max= jiShu.length>ouShu.length?jiShu.length:ouShu.length;
//        int min= jiShu.length<ouShu.length?jiShu.length:ouShu.length;
        if (jiShu.length>ouShu.length){
            max=jiShu.length;
            min=ouShu.length;
        }else {
            max=ouShu.length;
            min=jiShu.length;
        }

        //循环输出--以‘一奇一偶’形式输出
        System.out.println("一奇一偶交替输出如下：");
        for (int i =0;i<min;i++){
            System.out.print(jiShu[i]+" ");
            System.out.print(ouShu[i]+" ");
        }
        //溢出
        if (min!=max) {
            System.out.println();
            System.out.println("奇偶数不平衡");
            //奇数过多
            if (jiShu.length > ouShu.length) {
                System.out.print("奇数有点多，多出来的都在这：");
                for (int i = min; i < max; i++) {
                    System.out.print(jiShu[i]+" ");
                }
                //偶数过多
            } else {
                System.out.print("偶数太多了，你看：");
                for (int i = min; i < max; i++) {
                    System.out.print(ouShu[i]+" ");
                }
            }
        }
        System.out.println();
    }

    //分开存储方法--将奇偶数分别存入奇数数组，偶数数组
    private static int[] [] fenCun(int[] num,int [] jiOu) {
        //根据奇偶个数分别定义奇偶数组
        int [] jiShu = new int[jiOu[0]];
        int [] ouShu = new int[jiOu[1]];
        //定义变量a，b--分别作为奇偶数组的动态索引
        int a=0;
        int b=0;
        //定义一个二维数组jiAndOu--接收奇数数组和偶数数组
        int jiAndOu[][]=new int[2][];

        for (int i=0;i<num.length;i++){
            //从八个整数中找出偶数存入ouShu数组
            if (num[i]%2==0){
                ouShu[a]=num[i];
                a++;
                //将非偶数（奇数）存入jiShu数组
            }else {
                jiShu[b]=num[i];
                b++;
            }
        }

        //二维数组接收两个一维数组
        jiAndOu[0]=jiShu;
        jiAndOu[1]=ouShu;

        //将二维数组返回主调函数
        return jiAndOu;
    }

    //判断输入的八个数中分别有几个奇数，几个偶数
    private static int[] panDuan(int[] num) {
        //定义jiOu数组来接收奇数的个数和偶数的个数
        int [] jiOu = new int[2];
        //对八个整数数组进行遍历，使用jiOu数组来记录奇数偶数个数
        for (int i=0;i<num.length;i++){
            if (num[i]%2==0){
                jiOu[1]++;
            }else {
                jiOu[0]++;
            }
        }

        //输出奇数，偶数个数
        System.out.println("8个数中，有"+jiOu[0]+"个奇数，"+jiOu[1]+"个偶数.");
        //返回记录数组jiOu
        return jiOu;
    }
}