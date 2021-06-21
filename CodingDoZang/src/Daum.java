import java.util.Arrays;

/* 풀어주세요.
 * 
 * 1차원의 점들이 주어졌을 때,
 * 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오.
 * (단 점들의 배열은 모두 정렬되어있다고 가정한다.)
 * 예를들어 S={1, 3, 4, 8, 13, 17, 20} 이 주어졌다면,
 * 결과값은 (3, 4)가 될 것이다.
 */
public class Daum {
	public static void main(String[] args) {
		int[] num = new int[6];
		for (int i = 0; i < 6; i++) {
			num[i] = (int)(Math.random() * 100) + 1;
			for (int j = 0; j < i; j++) { 
				if(num[i] == num[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(num);
		int[] count = new int[5];
		System.out.println("문제 : " + Arrays.toString(num));
		for (int i = 0; i < num.length-1; i++) {
			count[i] = num[i+1] - num[i];
			int[] result = {num[i], num[i+1]};
			System.out.println(Arrays.toString(result) + " = " + count[i]);
			
//			if(count[0] != 0) {
//				System.out.println(Arrays.toString(result));
//				break;
//			} -> 이중배열 배우고 해보기
		}
		
	
		int[] daum = num;//{1, 3, 4, 8, 13, 17, 20};
		//각 거리차이를 저장할 변수
		
		int count02 = daum[1] - daum[0];
		int fir = daum[0], sec = daum[1];
		
		for (int i = 0; i < daum.length-1; i++) {
			if(count02 > daum[i+1] - daum[i]){
				fir = daum[i]; sec = daum[i + 1];
				count02 = daum[i + 1] - daum[i];
			}
		}
		System.out.println("차이값이 최솟값인 배열 " +fir + ", " + sec);
		
	}
}
