import java.util.Arrays;
import java.util.Scanner;

public class Caesar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ܾ �Է��ϼ��� : ");
		String input = sc.next();
		//input = input.toUpperCase(); ������ �빮�ڷ� ��ȯ
		char[] cat = input.toCharArray();
		System.out.println("�о���� �ϴ� Ƚ�� : ");
		int pass = sc.nextInt();
		if(pass>26) {
			pass = pass%26;
		}
		for (int i = 0; i < cat.length; i++) {
			if(cat[i]>='a' && cat[i]<='z') {
				if(cat[i] + pass >'z') {
					cat[i] = (char) (cat[i] + pass - 26);
				}else {
					cat[i] = (char) (cat[i] + pass);
				}				
			} else if(cat[i]>='A' && cat[i]<='Z') {
				if(cat[i] + pass >'Z') {
					cat[i] = (char) (cat[i] + pass - 26);
				}else {
					cat[i] = (char) (cat[i] + pass);
				}
			} else {
				System.out.println("�ܾ �ƴմϴ�.");
			}
		}
		System.out.println(Arrays.toString(cat));
		sc.close();
	}

}
