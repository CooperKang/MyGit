import java.util.Scanner;

public class CreateN {
	public static void main(String[] args) {
		System.out.println("숫자 대입했을 때 N만들기");
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요. _ ");
		int code = sc.nextInt();
		if(code % 2 == 0) {
			code++;
		}
		for (int i = 0; i < code; i++) {
			for (int j = 0; j < code; j++) {
				if(i == j || j == 0 || j == code - 1) {
					System.out.print("N");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		sc.close();
	}
}
