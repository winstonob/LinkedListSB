import java.util.Scanner;

public class Assign2B {
    public static void main(String [] args) {
        System.out.print("INPUT SIZE OF DATASET: ");
        int N =  new Scanner(System.in).nextInt();
        char data = 'W';

        long timeMSBA;
        long timeMSBD;
        long timeMSBI;

        long timeSBA;
        long timeSBD;
        long timeSBI;

        long timeSA;
        long timeSD;
        long timeSI;

        long tempTime1;
        long tempTime2;

        //Tests for MyStringBuilder
        MyStringBuilder s1 = new MyStringBuilder();

        // Testing append()
        tempTime1 = System.nanoTime();
        for(int index = 0; index < N; index++) {
            s1.append('N');
        }
        tempTime2 = System.nanoTime();
        timeMSBA = (tempTime2 - tempTime1) / N;


        // Testing delete()
        tempTime1 = System.nanoTime();
        for(int index = 0; index < N; index++) {
            s1.delete(0,1);
        }
        tempTime2 = System.nanoTime();
        timeMSBD =  (tempTime2 - tempTime1) / N;


        // Testing insert()
        // Edge Case: Inserting at midpoint when length is 0
        // Inserting the first index outside of loop to avoid throwing an ArithmeticException.
        tempTime1 = System.nanoTime();
        s1.insert(0, data);
        for(int index = 0; index < N - 1; index++) {
            s1.insert(s1.length() / 2, data);
        }
        tempTime2 = System.nanoTime();
        timeMSBI =  (tempTime2 - tempTime1) / N;



        //Tests for StringBuilder
        StringBuilder s2 = new StringBuilder();

        // Testing append()
        tempTime1 = System.nanoTime();
        for(int index = 0; index < N; index++) {
            s2.append('N');
        }
        tempTime2 = System.nanoTime();
        timeSBA = (tempTime2 - tempTime1) / N;

        // Testing delete()
        tempTime1 = System.nanoTime();
        for(int index = 0; index < N; index++) {
            s2.delete(0,1);
        }
        tempTime2 = System.nanoTime();
        timeSBD = (tempTime2 - tempTime1) / N;

        // Testing insert()
        // Edge Case: Inserting at midpoint when length is 0
        // Inserting the first index outside of loop to avoid throwing an ArithmeticException.
        tempTime1 = System.nanoTime();
        s1.insert(0, data);
        for(int index = 0; index < N - 1; index++) {
            s2.insert(s2.length() / 2, data);
        }
        tempTime2 = System.nanoTime();
        timeSBI = (tempTime2 - tempTime1) / N;



        //Tests for String
        String s3 = new String();

        // Testing append()
        tempTime1 = System.nanoTime();
        for(int index = 0; index < N; index++) {
            s3 += data;
        }
        tempTime2 = System.nanoTime();
        timeSA = (tempTime2 - tempTime1) / N;

        // Testing delete()
        tempTime1 = System.nanoTime();
        for(int index = 0; index < N; index++) {
            s3 = s3.substring(1, s3.length());
        }
        tempTime2 = System.nanoTime();
        timeSD = (tempTime2 - tempTime1) / N;

        // Testing insert()
        // Edge Case: Inserting at midpoint when length is 0
        // Inserting the first index outside of loop to avoid throwing an ArithmeticException.
        tempTime1 = System.nanoTime();
        s3 += data;
        for(int index = 0; index < N - 1; index++) {

            s3 = s3.substring(0, (s3.length() / 2) + 1) + data + s3.substring(s3.length() / 2, s3.length());
        }
        tempTime2 = System.nanoTime();
        timeSI = (tempTime2 - tempTime1) / N;

        System.out.println("APPEND (MSB): " + timeMSBA);
        System.out.println("APPEND (SB): " + timeSBA);
        System.out.println("APPEND (S): " + timeSA);

        System.out.println("DELETE (MSB): " + timeMSBD);
        System.out.println("DELETE (SB): " + timeSBD);
        System.out.println("DELETE (S): " + timeSD);

        System.out.println("INSERT (MSB): " + timeMSBI);
        System.out.println("INSERT (SB): " + timeSBI);
        System.out.println("INSERT (S): " + timeSI);
    }
}
