package stuff;

import java.math.BigInteger;
import java.util.stream.Stream;

public class UniqueRemainders {

    public static void main(String[] args) {

//        for (int i = 23; i <= 24; i++){
//            System.out.println(small(i));
//        }
        BigInteger t = new BigInteger("1");
        System.out.println(Stream.iterate(new BigInteger("1"), (BigInteger bi) -> bi.add(BigInteger.ONE)).limit(150_000).reduce(UniqueRemainders::lcm).get().subtract(t));

    }

    public static boolean mod(int N, int X) {

        for (int i = 1; i <= N; i++) {
            if (X % i != i - 1) {
                return false;
            }

        }
        return true;
    }
    public static boolean mod(int N, BigInteger X) {
        BigInteger bn = new BigInteger(Integer.toString(N));
        for (BigInteger i = new BigInteger("1"); i.compareTo(bn)<=0; i = i.add(BigInteger.ONE)) {

            if (X.mod(i).compareTo(i.subtract(BigInteger.ONE)) != 0) {
                return false;
            }

        }
        return true;
    }

    public static BigInteger small(int N) {

        BigInteger bn = new BigInteger(Integer.toString(N));
        BigInteger x = new BigInteger(Integer.toString(N-1));
        while (!mod(N, x)) {
            x = x.add(bn);
        }
        return x;

    }
//    public static int small(int N) {
//        int x = N-1;
//        while (!mod(N, x)) {
//            x += N;
//        }
//        return x;
//
//    }

    private static BigInteger gcd(BigInteger a, BigInteger b)
    {
        while (b.compareTo(BigInteger.ZERO) > 0)
        {
            BigInteger temp = b;
            b = a.mod(b); // % is remainder
            a = temp;
        }
        return a;
    }


    private static BigInteger lcm(BigInteger a, BigInteger b)
    {
        return a.multiply(b.divide(gcd(a,b)));
    }

//    private static BigInteger gcd(BigInteger[] input)
//    {
//        BigInteger result = input[0];
//        for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
//        return result;
//    }
//    
//    private static BigInteger lcm(BigInteger[] input)
//    {
//        BigInteger result = input[0];
//        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
//        return result;
//    }

}
