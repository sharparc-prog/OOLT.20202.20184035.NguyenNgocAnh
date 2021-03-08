import java.util.Scanner;

public class Bai225 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Moi nhap 2 so: \nSo thu nhat: ");
		double dA = keyboard.nextDouble();
		System.out.println("So thu 2: ");
		double dB = keyboard.nextDouble();
		double sum = dA + dB;
		double diff = dA - dB;
		double prod = dA * dB;
		double quot = dA / dB;
		System.out.printf("Tong 2 so la: %.2f\n", sum);
		System.out.printf("Hieu 2 so la: %.2f\n",  diff);
		System.out.printf("Tich 2 so la: %.2f\n",  prod);
		System.out.printf("Thuong 2 so la: %.2f\n", quot);
		keyboard.close();
	}
}
