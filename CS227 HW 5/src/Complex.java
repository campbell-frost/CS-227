public class Complex {
	private double real;
	private double img;

	public Complex()     {      }

	public Complex(double real, double img) {         this.real = real;         this.img = img;     }

	public Complex add(Complex c1, Complex c2) {
		Complex ctemp = new Complex();
		ctemp.real = c1.real + c2.real;
		ctemp.img = c1.img + c2.real;
		return ctemp;
	}

	public Complex subtract(Complex c1, Complex c2) {
		Complex ctemp = new Complex();
		ctemp.real = c1.real - c2.real;
		ctemp.img = c1.img - c2.real;
		return ctemp;
	}

	public Complex multiply(Complex c1, Complex c2) {
		Complex ctemp = new Complex();
		ctemp.real = c1.real * c2.real;
		ctemp.img = c1.real * c2.img;
		ctemp.img += c1.img * c2.real;
		ctemp.real += c1.img * c2.img * (-1);
		return ctemp;
	}

	public Complex division(Complex c1, Complex c2) {
		double p = c1.real * c2.real + c1.img * c2.img;
		double div = c1.img * c1.img + c2.img * c2.img;
		double uimg = c1.img * c2.real - c1.real * c2.img;
		Complex ctemp = new Complex();
		ctemp.real = p / div;
		ctemp.img = uimg / div;
		return ctemp;
	}

	public double abs(Complex c) {
		double x = c.real * c.real + c.img * c.img;
		return Math.sqrt(x);
	}

	@Override
	public String toString() {
		return "Complex{" + "real=" + real + ", img=" + img + "i" + '}';
	}
}

class ComplexTest {
	public static void main(String ar[]) {
		System.out.println(" <------------:: Complex Number Arithmetic Operation ::-----------> ");
		Complex c1 = new Complex(2, 3);
		System.out.println("Complex Number C1 :: " + c1);
		Complex c2 = new Complex(2, 5);
		System.out.println("Complex Number C2 :: " + c2);
		Complex add = new Complex().add(c1, c2);
		System.out.println("add = C1 + C2 :: " + add);
		Complex sub = new Complex().subtract(c1, c2);
		System.out.println("sub = C1 - C2 :: " + sub);
		Complex mul = new Complex().multiply(c1, c2);
		System.out.println("mul = C1 * C2 :: " + mul);
		Complex div = new Complex().division(c1, c2);
		System.out.println("div = C1 / C2 :: " + div);
		System.out.println("Abs Value for Complex Number C1 :: " + new Complex().abs(c1));
	}
}
