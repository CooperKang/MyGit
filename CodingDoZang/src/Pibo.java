import java.util.Arrays;

//�ɽ��Ͻø� �Ʒ� ������.
//�Ǻ���ġ���� 0, 1�� �⺻���� �־����ϴ�.
//0, 1, 1, 2, 3, 5, 8....
//���� ���� ����ϴ� ������ ������ּ���
import java.util.Scanner;
//�Ǻ���ġ ������ ������ִ� ���α׷��̴�.
//�Ǻ���ġ �����̶� ù��° ���ڿ� �ι�° ���ڸ� ���� ����° ���ڸ� ���ϴ� ��������
// a, b, a+b=c , b+c=d, c+d=e .....�̷������� ���ȴ�.
public class Pibo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("�Ǻ���ġ ������ ���� ���� N�� �Է��ϼ���: ");
        int n = scanner.nextInt();
        int[] arr01 = new int[n];
        System.out.println("ù��° �ڸ� �ʱⰪ�� �Է��Ͻÿ�.");
        int f = scanner.nextInt();
        arr01[0] = f;
        System.out.println("�ι�° �ڸ� �ʱⰪ�� �Է��Ͻÿ�.");
        int s = scanner.nextInt();
        arr01[1] = s;
        for (int i = 2; i < arr01.length; i++) {
			arr01[i] = arr01[i-2] + arr01[i-1];
		}
        scanner.close();
        System.out.println(Arrays.toString(arr01));
    }
}
