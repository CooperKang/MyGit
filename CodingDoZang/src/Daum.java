import java.util.Arrays;

/* Ǯ���ּ���.
 * 
 * 1������ ������ �־����� ��,
 * �� �� ���� �Ÿ��� ª�� ���� ���� ����ϴ� �Լ��� �ۼ��Ͻÿ�.
 * (�� ������ �迭�� ��� ���ĵǾ��ִٰ� �����Ѵ�.)
 * ������� S={1, 3, 4, 8, 13, 17, 20} �� �־����ٸ�,
 * ������� (3, 4)�� �� ���̴�.
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
		System.out.println("���� : " + Arrays.toString(num));
		for (int i = 0; i < num.length-1; i++) {
			count[i] = num[i+1] - num[i];
			int[] result = {num[i], num[i+1]};
			System.out.println(Arrays.toString(result) + " = " + count[i]);
			
//			if(count[0] != 0) {
//				System.out.println(Arrays.toString(result));
//				break;
//			} -> ���߹迭 ���� �غ���
		}
		
	
		int[] daum = num;//{1, 3, 4, 8, 13, 17, 20};
		//�� �Ÿ����̸� ������ ����
		
		int count02 = daum[1] - daum[0];
		int fir = daum[0], sec = daum[1];
		
		for (int i = 0; i < daum.length-1; i++) {
			if(count02 > daum[i+1] - daum[i]){
				fir = daum[i]; sec = daum[i + 1];
				count02 = daum[i + 1] - daum[i];
			}
		}
		System.out.println("���̰��� �ּڰ��� �迭 " +fir + ", " + sec);
		
	}
}
