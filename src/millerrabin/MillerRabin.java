import java.util.Scanner;

public class MillerRabin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
	Integer n = sc.nextInt();
        Integer nMenosUm, q, a;
        Integer k = 0;
        String nMenosUmBin;
        
        if (n % 2 == 0 || n == 0 || n == 1) {
            System.out.printf(n + " não é primo..");
        } else {
            // (n – 1 = 2k * q)
            nMenosUm = n - 1;
            nMenosUmBin = Integer.toBinaryString(nMenosUm);
            
            while ((nMenosUmBin & 1) != 1) {

                if (nMenosUmBin.charAt(nMenosUmBin.length() - 1) == '0') {
                    nMenosUmBin = nMenosUmBin.substring(0, nMenosUmBin.length() - 1);
                    nMenosUmBin = Integer.parseInt(nMenosUmBin, 2);
                    k++;
                }
                q = Integer.parseInt(nMenosUmBin, 2);
            }

            System.out.println("k = " + k + ", q = " + q);
            for (int i = 2; i < n - 1; i++) {
                
            a = i;
            
            System.out.println(i);
            System.out.println(Math.pow(a, q) % n);

                if (Math.pow(a, q) % n == 1) {
                        System.out.printf("INCONCLUSIVE\n");
                } else {
                    for (int j = 0; j < k - 1; j++) {
                        double potencia = Math.pow(2, j) * q;

                        if (Math.pow(a, potencia) % n == (n - 1)) {
                                System.out.printf("INCONCLUSIVE\n", n);
                        } else {
                                System.out.printf("COMPOSITE\n", n);
                        }
                    }
                }
            }
        }
    }
}
