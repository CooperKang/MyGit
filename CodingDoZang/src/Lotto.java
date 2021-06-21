import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		
		int lotto[] = new int [6];
		Scanner sc = new Scanner(System.in);
		System.out.print("�ζǸ� � �����Ͻðڽ��ϱ�? : ");
		int buy = sc.nextInt();
		System.out.print("\n===============================\n\n�ζ� ��÷��ȣ : ");

		int lottoNum[] = new int [7];
		for(int i=0; i<7; i++) {
			lottoNum[i] = (int)(Math.random() * 45) + 1;
			for(int j=0; j<i; j++) {
				if(lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				}
			}
		}//7���� �����ؼ� ������ ��ȣ�� ���ʽ���ȣ�� ���
		System.out.print(Arrays.toString(lottoNum));
		System.out.println("\n���ʽ� ��ȣ�� [ " + lottoNum[6] + " ]");
		
		System.out.print("\n===============================\n\n����� �ζ� ��ȣ : ");
		
		for (int a = 0; a < buy; a++) {
			for(int i=0; i<6; i++) {
				lotto[i] = (int)(Math.random() * 45) + 1;
				for(int j=0; j<i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
			System.out.println("");
			System.out.print(Arrays.toString(lotto));
			System.out.println("\n����� �ζ� ���� ���");
			int cont = 0;
			for (int i = 0; i < 6; i++) {
				for (int z = 0; z < 7; z++) {
					if(lotto[i] == lottoNum[z]) {
						cont++;
					}
				}
			}
			int cont2 = 0;
			for (int i = 0; i < 6; i++) {
				for (int z = 0; z < 6; z++) {
					if(lotto[i] == lottoNum[z]) {
						cont2++;
					}
				}
			}
			System.out.println("��÷�� ��ȣ ������ : " + cont + "�� �Դϴ�.");
			switch (cont2) {
			case 0:
			case 1:
				System.out.println("��÷�Ǿ����ϴ�.");
				break;
			case 2:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
				lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("�����մϴ�. 5���Դϴ�.");
				} else {
					System.out.println("��÷�Ǿ����ϴ�.");
				}
				break;
			case 3:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
				lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("�����մϴ�. 4���Դϴ�.");
				} else {
					System.out.println("�����մϴ�. 5���Դϴ�.");
				}
				break;
			case 4:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
				lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("�����մϴ�. 3���Դϴ�.");
				} else {
					System.out.println("�����մϴ�. 4���Դϴ�.");
				}
				break;
			case 5:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
					lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("�����մϴ�. 2���Դϴ�.");
				} else {
					System.out.println("�����մϴ�. 3���Դϴ�.");
				}
				break;
			case 6:
				System.out.println("�����մϴ�. 1���Դϴ�.");
				break;
			default:
				break;
			}
		}
		
		sc.close();
	}
}
