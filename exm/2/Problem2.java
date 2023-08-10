import java.math.*;

class rsaPrac {
    public static void main(String args[]) {
        int p = 2, q = 1009;

        int n, phi;
        n = p * q;
        phi = (p - 1) * (q - 1);

        int d = 0, e, i;

        int msg = 154;
        double c;
        BigInteger deMsg;
        System.out.println("Message = " + msg);
        System.out.println();

        System.out.println("the value of Phi(n) = " + phi);

        for (e = 2; e < phi; e++) {

            if (gcd(e, phi) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        // for (i = 0; i <= 100; i++) {
        // int x = 1 + (i * phi);

        // if (x % e == 0) {
        // d = x / e;
        // break;
        // }
        // }
        for (i = 0; i <= 1000; i++) {
            if ((e * i) % phi == 1) {
                d = i;
                break;
            }
        }
        System.out.println("the value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);

        BigInteger N = BigInteger.valueOf(n);

        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        deMsg = (C.pow(d)).mod(N);
        System.out.println();
        System.out.println("Decrypted message is : "
                + deMsg);
    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}