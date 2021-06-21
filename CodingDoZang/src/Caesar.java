import java.util.Arrays;
import java.util.Scanner;

public class Caesar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단어를 입력하세요 : ");
		String input = sc.next();
		//input = input.toUpperCase(); 무조건 대문자로 변환
		char[] cat = input.toCharArray();
		System.out.println("밀어내고자 하는 횟수 : ");
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
				System.out.println("단어가 아닙니다.");
			}
		}
		System.out.println(Arrays.toString(cat));
		sc.close();
	}

}
