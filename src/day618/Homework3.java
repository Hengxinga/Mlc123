package day618;


import java.util.Arrays;

public class Homework3 {

    public static void main(String[] args) {

        char [] input = {'A','B','C','D','E'};

        char []chs=generate();
        System.out.println(Arrays.toString(chs));
        int [] result = check(input,chs);

        System.out.println("字符对的个数为："+result[1]+
                "位置对的个数为："+result[0]);

    }

    private static int[] check(char[] input, char[] chs) {
        int [] result =new int[2];
        for(int i=0;i<chs.length;i++){
            for (int j=0;j<input.length;j++){
                if (chs[i]==input[j]){
                    result[1]++;
                    if(i==j){
                        result[0]++;
                    }
                    break;
                }
            }
        }
        return result;
    }

    private static char[] generate() {

        char [] chs=new char[5];

        char [] letters = {'A','B','C','D','E','F','G','H','I','J',
                'K', 'L','M','N','O','P','Q','R','S','T','U','V',
                'W','X','Y','Z'};

        boolean [] flages = new boolean[letters.length];
        int index =0;
        for(int i=0;i<chs.length;i++){
            do{
                index = (int)(Math.random()*letters.length);
            }while (flages[index]);
            chs[i] = letters[index];
            flages[index] = true;
        }
        return chs;
    }
}
