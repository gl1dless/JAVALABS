package secondEx;

public class SecondTest {
    public static void run() {
        ComplexNumber z1 = new ComplexNumber(3, 4);   // 3 + 4i
        ComplexNumber z2 = new ComplexNumber(1, -2);  // 1 - 2i

        ComplexNumber result = z1.multiply(z2);

        System.out.println("z1 * z2 = " + result);
    }
}
