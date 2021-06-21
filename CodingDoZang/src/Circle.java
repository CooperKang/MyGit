import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		System.out.println("숫자 대입했을 때 원 만들기");
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요. _ ");
		int code = sc.nextInt();
		for (int i = -code/2; i <= code/2; i++) {
			for (int j = -code/2; j <= code/2; j++) {
				if(i * i + j * j < code/2*code/2 && i * i + j * j > (code-2.5)/2*(code-2.5)/2) {
					System.out.print("■"+"\s");
				}else {
					System.out.print("□"+"\s");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}