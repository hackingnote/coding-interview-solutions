
public class StepByStep {
    public static void main(String[] argv) {

        int a = 1;
        int b = -3;
        int n = 1;

        while (b != 0) {

            System.out.println("======    Iteration #" + n++ + "    ======");

            System.out.printf("%20s = %32s\n", "a", Integer.toBinaryString(a));

            System.out.printf("%20s = %32s\n", "b", Integer.toBinaryString(b));

            int carry = a & b;
            System.out.printf("%20s = %32s\n", "carry(a & b)", Integer.toBinaryString(carry));

            a = a ^ b;
            System.out.printf("%20s = %32s\n", "new a(a ^ b)", Integer.toBinaryString(a));

            b = carry << 1;
            System.out.printf("%20s = %32s\n\n", "new b(shifted carry)", Integer.toBinaryString(b));

        }

        System.out.println("Final Result: " + a);
    }
}