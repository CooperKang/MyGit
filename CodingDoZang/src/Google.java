import java.util.Scanner;

public class Google {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("8의 개수를 구할 범위를 지정하시오");
		int num = sc.nextInt();
		int[] google = new int[num];
		int number = 1;
		int count = 0;
		for (int i = 0; i < google.length; i++) {
			google[i] = number;
			number++;
			do {
	            if (google[i] % 10 == 8) {
	                count++;
	            }
	            google[i] /= 10;
	        } while (google[i] > 0);

		}
		System.out.println(count);
		sc.close();
	}

}
