
import java.util.Scanner;

public class SpiralArray2 {

	public static void main(String[] args) {
		//1. 숫자_숫자를 입력받으면
		//가로세로 해당 숫자만큼 큰 배열을 그려주세요.
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		System.out.println("9이상의 홀수를 입력하시오(정비례 ex.9 9, 11 11)");
		System.out.println("X축을 입력하세요.");
		int X = sc.nextInt();
		System.out.println("Y축을 입력하세요.");
		int Y = sc.nextInt();
		int[][] nasen = new int[X][Y];
		int number = 0;
		int number2 = 1;
		int number3 = 1;
		int where = 0;
		int i = 0, j = 0;
		
		for (i = 0; i < X; i++) {
			for (j = 0; j < Y; j++) {
				if((i-X/2) * (i-X/2) + (j-Y/2) * (j-Y/2) < X/2*Y/2) {
					System.out.print("■"+"\s");	
					nasen[i][j] = 0;
					number3++;
				}else {
					System.out.print("□"+"\s");
					nasen[i][j] = number2;
				}
			}
			System.out.println();
		}
		i = 0; j = Y/2-1;
		while (true) {
			//switch 문으로 방향을 바꿔야지
            switch (where) {
            case 0:// → 
            	nasen[i][j++] = number++;//번호 저장시키면서 번호+1해주고 Y축+1만큼 이동
            	if(nasen[i--][j] == 0) {
            		j--;//Y축으로 +1 되던 j값은 잡아주고
            		i--;//X축으로 -1
            		where = 3;
            		break;
            	}
                if (j == Y || nasen[i][j] != 0) {
                	// y축의 끝에 도달했거나 다음 y축에 값이 있다면
                    j--;//Y축으로 +1 되던 j값은 잡아주고
                    i++;//이제 X축 방향으로 +1
                    where = 1;//방향전환
                    break;
                }
            case 1:// ↓
            	nasen[i++][j] = number++;//번호 저장시키면서 번호+1해주고 X축+1만큼 이동
            	if(nasen[i][j++] == 0) {
            		i--;
            		j++;
            		where = 0;
            		break;
            	}
                if (i == X || nasen[i][j] != 0) {
                	// X축의 끝에 도달했거나 다음 X축에 값이 있다면
                    i--;//X축으로 +1되던 i값 잡아주고
                    j--;//이제 Y축 방향으로 -1
                    where = 2;//방향전환
                    break;
                }
            case 2:// ←
            	nasen[i][j--] = number++;//번호 저장시키면서 번호+1해주고 Y축-1만큼 이동
            	if(nasen[i++][j] == 0) {
            		j++;
            		i++;
            		where = 1;
            		break;
            	}
                if (j == -1 || nasen[i][j] != 0) {
                	//Y축으로 -1씩 후행증감되고 있으므로 마지막 Y축의 0에 도착하면
                	//j는 -1이 되고 이때 다시 방향을 틀어버리자
                	//아니면 그 다음 Y축에 값이 있으면
                    i--;//이제 X축 방향으로 -1
                    j++;//Y축 방향으로 -1되던 j값 잡아줘
                    where = 3;//방향전환
                    break;
                }
            case 3:// ↑
            	nasen[i--][j] = number++;//번호 저장시키면서 번호+1해주고 X축-1만큼 이동
            	if(nasen[i][j--] == 0) {
            		i++;
            		j--;
            		where = 2;
            		break;
            	}
                if (i == 0 || nasen[i][j] != 0) {
                	//여기까지 오면 이미 X축에 0번째 줄은 값이 다 있기 때문에
                	//i가 1번째 줄까지 다 채우면 i==0이됨
                	//그럼 이때 방향을 틀어주거나 그 다음 자리에 값이 있으면 방향바꿔
                    i++;//이제 X축 방향으로 -1되던 i값 잡아주고
                    j++;//Y축 방향으로 +1
                    where = 0;//방향전환 →
                    break;
                }
            }

            if (number == number3-1)
            	//처음 숫자가 1부터 시작하기 때문에 + 1
            	//number가 마지막 숫자가 되면 끝
                break;
        }

		for (i = 0; i < X; i++) {
            for (j = 0; j < X; j++) {
                System.out.print(nasen[i][j] + "\t");
            }
            System.out.println("\n");
        }
		
		
		sc.close();
	}

}
