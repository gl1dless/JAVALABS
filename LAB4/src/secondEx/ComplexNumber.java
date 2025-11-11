package secondEx;


public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double a = this.real;
        double b = this.imag;
        double c = other.real;
        double d = other.imag;

        double newReal = a * c - b * d;
        double newImag = a * d + b * c;

        return new ComplexNumber(newReal, newImag);
    }

    public String toString() {
        return real + " + " + imag + "i";
    }
}
