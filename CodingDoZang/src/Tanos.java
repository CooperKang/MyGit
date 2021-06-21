import java.util.Arrays;
import java.util.Scanner;

public class Tanos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원소 개수 설정 : ");
		int finger = sc.nextInt();
		int[] people = new int[finger];
		for (int i = 0; i < finger; i++) {
			people[i] = (int)(Math.random() * 100) + 1;
			for (int j = 0; j < i; j++) { 
				if(people[i] == people[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("사라지고 싶지 않아" + Arrays.toString(people) + "\n으악");
		int[] half = new int[people.length/2];
		if(finger%2 == 0) {
			half = new int[people.length/2];
		}else {
			half = new int[people.length/2 + (int)(Math.random()*2)];
		}
		for (int i = 0; i < half.length; i++) {
			int r = (int)(Math.random()*people.length);
			if(people[r] != 0) {
				half[i] = people[r];
				people[r] = 0;
			}else {
				i--;
			}
		}
		System.out.println(Arrays.toString(half));
//		int[] bye = new int[finger/2];
//		if(finger%2 == 0) {
//			for (int i = 0; i < (finger/2); i++) {
//				bye[i] = (int)(Math.random() * (finger-1)) + 1;
//				for (int j = 0; j < i; j++) { 
//					if(bye[i] == bye[j]) {
//						i--;
//						break;
//					}
//				}
//			}
//			for (int i = 0; i < bye.length; i++) {
//				num[bye[i]] = 0;
//			}
//			System.out.println( Arrays.toString(num));
//		}else {
//			for (int i = 0; i < (finger/2); i++) {
//				bye[i] = (int)(Math.random() * (finger-1)) + 1;
//				for (int j = 0; j < i; j++) { 
//					if(bye[i] == bye[j]) {
//						i--;
//						break;
//					}
//				}
//			}
//			for (int i = 0; i < bye.length + ((int)Math.random()*2); i++) {
//				num[bye[i]] = 0;
//			}
//			System.out.println( Arrays.toString(num));
//		}
		sc.close();
	}
}
