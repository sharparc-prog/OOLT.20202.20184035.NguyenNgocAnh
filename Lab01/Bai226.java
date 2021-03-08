import java.util.Scanner;

public class Bai226 {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Phuong trinh co dang \naX + bY = c\ndX + eY = f");
		
		System.out.println("Nhap so a: \n");
		double a = keyboard.nextDouble();
		
		System.out.println("Nhap so b: \n");
		double b = keyboard.nextDouble();
		
		System.out.println("Nhap so c: \n");
		double c = keyboard.nextDouble();
		
		System.out.println("Nhap so d: \n");
		double d = keyboard.nextDouble();
		
		System.out.println("Nhap so e: \n");
		double e = keyboard.nextDouble();
		
		System.out.println("Nhap so f: \n");
		double f = keyboard.nextDouble();
		
		double D = (a * e) - (b * d);
		double D1 = (c * e) - (f * b);
		double D2 = (a * f) - (d * c1);
		
		if (D != 0) {
			double X = D1/D;
			double Y = D2/D;
			System.out.printf("Phuong trinh co 2 nghiem rieng biet X va Y: %.3f & %.3f", X, Y);
			System.exit(0);
		}
		if (D == 0) {
			System.out.println("Phuong trinh co vo so nghiem!");
			System.exit(0);
		}
		
		System.out.printf("Phuong trinh vo nghiem!");
		keyboard.close();
	}
}
