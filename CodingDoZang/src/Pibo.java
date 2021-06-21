import java.util.Arrays;

//심심하시면 아래 문제도.
//피보나치수열 0, 1은 기본으로 주어집니다.
//0, 1, 1, 2, 3, 5, 8....
//위와 같이 출력하는 문장을 만들어주세요
import java.util.Scanner;

public class Pibo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("피보나치 수열을 구할 정수 N을 입력하세요: ");
        int n = scanner.nextInt();
        int[] arr01 = new int[n];
        System.out.println("첫번째 자리 초기값을 입력하시오.");
        int f = scanner.nextInt();
        arr01[0] = f;
        System.out.println("두번째 자리 초기값을 입력하시오.");
        int s = scanner.nextInt();
        arr01[1] = s;
        for (int i = 2; i < arr01.length; i++) {
			arr01[i] = arr01[i-2] + arr01[i-1];
		}
        scanner.close();
        System.out.println(Arrays.toString(arr01));
    }
}
