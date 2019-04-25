package millerrabin;

import java.util.Scanner;

public class MillerRabin {

    public static String isPrime(long n)
    {
                Long nMenosUm, q = null, a;
        long k = 0;
        String nMenosUmBin;
        
        if (n % 2 == 0 || n == 0 || n == 1) {
            System.out.printf(n + " não é primo..");
        } else {
            // (n – 1 = 2k * q)
            nMenosUm = n - 1;
            
            
            nMenosUmBin = Long.toBinaryString(nMenosUm);
            
            while ((nMenosUm & 1) != 1) {

                if (nMenosUmBin.charAt(nMenosUmBin.length() - 1) == '0') {
                    nMenosUmBin = nMenosUmBin.substring(0, nMenosUmBin.length() - 1);
                    nMenosUm = Long.parseLong(nMenosUmBin, 2);
                    k++;
                }
                q = Long.parseLong(nMenosUmBin, 2);
            }

            System.out.println("k = " + k + ", q = " + q);
            for (long i = 2; i < n - 1; i++) {
                
            a = i;
            
            System.out.println(i);
            System.out.println(Math.pow(a, q) % n);

                if (Math.pow(a, q) % n == 1) {
                    return "INCONCLUSIVE\n";
                } else {
                    for (int j = 0; j < k - 1; j++) {
                        long potencia = (long) (Math.pow(2, j) * q);

                        if (Math.pow(a, potencia) % n == (n - 1)) {
                            return "INCONCLUSIVE\n";
                        } else {
                            return "COMPOSITE\n";
                        }
                    }
                }
            }
        }
        return null;

    }
    
    public static void main(String[] args) {
        
//        long bla;
//        
//        bla=1;
//        
//        while (bla>0)
//        {
//            bla=bla+100;
//        }
//        bla=bla-100;
        
 //       System.out.println(bla + "\n\n\n");
        
        Scanner sc = new Scanner(System.in);
        
	Long n = sc.nextLong();
        
        System.out.println(isPrime(n));
    }
}
