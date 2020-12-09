public class ExtraCredit {

    public static void main(String [] args)
    {
        MyStringBuilder s1 = new MyStringBuilder("This is extra credit");

        s1 = s1.toLowerCase();
        System.out.println("Testing toLowerCase(): " + s1.toString());

        s1 = s1.toUpperCase();
        System.out.println("Testing toUpperCase(): " + s1.toString());
    }
}
