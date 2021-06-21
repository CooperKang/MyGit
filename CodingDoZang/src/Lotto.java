import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		
		int lotto[] = new int [6];
		Scanner sc = new Scanner(System.in);
		System.out.print("로또를 몇개 구매하시겠습니까? : ");
		int buy = sc.nextInt();
		System.out.print("\n===============================\n\n로또 당첨번호 : ");

		int lottoNum[] = new int [7];
		for(int i=0; i<7; i++) {
			lottoNum[i] = (int)(Math.random() * 45) + 1;
			for(int j=0; j<i; j++) {
				if(lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				}
			}
		}//7개를 생성해서 마지막 번호는 보너스번호로 사용
		System.out.print(Arrays.toString(lottoNum));
		System.out.println("\n보너스 번호는 [ " + lottoNum[6] + " ]");
		
		System.out.print("\n===============================\n\n당신의 로또 번호 : ");
		
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
			System.out.println("\n당신의 로또 응모 결과");
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
			System.out.println("당첨된 번호 개수는 : " + cont + "개 입니다.");
			switch (cont2) {
			case 0:
			case 1:
				System.out.println("낙첨되었습니다.");
				break;
			case 2:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
				lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("축하합니다. 5등입니다.");
				} else {
					System.out.println("낙첨되었습니다.");
				}
				break;
			case 3:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
				lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("축하합니다. 4등입니다.");
				} else {
					System.out.println("축하합니다. 5등입니다.");
				}
				break;
			case 4:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
				lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("축하합니다. 3등입니다.");
				} else {
					System.out.println("축하합니다. 4등입니다.");
				}
				break;
			case 5:
				if(lottoNum[6] == lotto[0] || lottoNum[6] == lotto[1] ||  lottoNum[6] == lotto[2] || lottoNum[6] == lotto[3] || 
					lottoNum[6] == lotto[4] || lottoNum[6] == lotto[5]) {
					System.out.println("축하합니다. 2등입니다.");
				} else {
					System.out.println("축하합니다. 3등입니다.");
				}
				break;
			case 6:
				System.out.println("축하합니다. 1등입니다.");
				break;
			default:
				break;
			}
		}
		
		sc.close();
	}
}
