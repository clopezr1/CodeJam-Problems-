import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Fibbonaci {

    private static int seeds;

    public static void main(String[] args) throws IOException {
        File input = new File("C:\\Users\\Carlos\\Desktop\\fibonacci_hard.in");
        FileReader in = new FileReader(input);
        BufferedReader buf = new BufferedReader(in);

        int numLines = Integer.parseInt(buf.readLine());
        ArrayList[] lines = new ArrayList[numLines];

        for (int i = 0; i < numLines ; i++) {
            lines[i] = new ArrayList<String>();
            lines[i].add(buf.readLine());
            String[] s;
            s = lines[i].toString().split(" ");
            String[] str = new String[s.length];
            for (int j = 0; j < s.length; j++) {
                str[j] = s[j];
                str[j] = str[j].replace("[", "");
                str[j] = str[j].replace("]", "");
            }
            int[] a = new int[str.length];
            ArrayList<Integer> AL= new ArrayList<Integer>();
            for (int j = 0; j < a.length; j++) {
                int n = Integer.parseInt(str[j]);
                AL.add(n);
            }
            int x = 0;

            x = makeSequence(AL);
            System.out.println(x);

        }

    }

    public static int makeSequence(ArrayList<Integer> a){
        //
        int max = (int) Math.pow(2,30);
        int newNum;
        int sum = 0;
        seeds = a.size();
        for (int i = 0; i < seeds; i++) {
            //sum += a.get(i);
            sum = (a.get(i)+ sum) % max;
        }

        for (int i = seeds - 1; i < 99999; i++) {
            newNum = 0;
            for (int j = 0; j < seeds; j++){
                //newNum += a.get(i - j);
                newNum = (newNum + a.get(i - j)) % max;
            }
            a.add(newNum);
            //sum += newNum;
            sum = (sum + newNum) % max;
        }

        return sum;
    }
}
