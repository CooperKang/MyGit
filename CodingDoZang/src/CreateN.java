import java.util.Scanner;
//���ڸ� �Է��ϸ� X*X��ŭ�� ������ ����� �� ������ ������ N�� �����ȴ�.
public class CreateN {
	public static void main(String[] args) {
		System.out.println("���� �������� �� N�����");
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���. _ ");
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
