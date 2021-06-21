
import java.util.Scanner;

public class SpiralArray2 {

	public static void main(String[] args) {
		//1. ����_���ڸ� �Է¹�����
		//���μ��� �ش� ���ڸ�ŭ ū �迭�� �׷��ּ���.
		
		//��ĳ��
		Scanner sc = new Scanner(System.in);
		System.out.println("9�̻��� Ȧ���� �Է��Ͻÿ�(����� ex.9 9, 11 11)");
		System.out.println("X���� �Է��ϼ���.");
		int X = sc.nextInt();
		System.out.println("Y���� �Է��ϼ���.");
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
					System.out.print("��"+"\s");	
					nasen[i][j] = 0;
					number3++;
				}else {
					System.out.print("��"+"\s");
					nasen[i][j] = number2;
				}
			}
			System.out.println();
		}
		i = 0; j = Y/2-1;
		while (true) {
			//switch ������ ������ �ٲ����
            switch (where) {
            case 0:// �� 
            	nasen[i][j++] = number++;//��ȣ �����Ű�鼭 ��ȣ+1���ְ� Y��+1��ŭ �̵�
            	if(nasen[i--][j] == 0) {
            		j--;//Y������ +1 �Ǵ� j���� ����ְ�
            		i--;//X������ -1
            		where = 3;
            		break;
            	}
                if (j == Y || nasen[i][j] != 0) {
                	// y���� ���� �����߰ų� ���� y�࿡ ���� �ִٸ�
                    j--;//Y������ +1 �Ǵ� j���� ����ְ�
                    i++;//���� X�� �������� +1
                    where = 1;//������ȯ
                    break;
                }
            case 1:// ��
            	nasen[i++][j] = number++;//��ȣ �����Ű�鼭 ��ȣ+1���ְ� X��+1��ŭ �̵�
            	if(nasen[i][j++] == 0) {
            		i--;
            		j++;
            		where = 0;
            		break;
            	}
                if (i == X || nasen[i][j] != 0) {
                	// X���� ���� �����߰ų� ���� X�࿡ ���� �ִٸ�
                    i--;//X������ +1�Ǵ� i�� ����ְ�
                    j--;//���� Y�� �������� -1
                    where = 2;//������ȯ
                    break;
                }
            case 2:// ��
            	nasen[i][j--] = number++;//��ȣ �����Ű�鼭 ��ȣ+1���ְ� Y��-1��ŭ �̵�
            	if(nasen[i++][j] == 0) {
            		j++;
            		i++;
            		where = 1;
            		break;
            	}
                if (j == -1 || nasen[i][j] != 0) {
                	//Y������ -1�� ���������ǰ� �����Ƿ� ������ Y���� 0�� �����ϸ�
                	//j�� -1�� �ǰ� �̶� �ٽ� ������ Ʋ�������
                	//�ƴϸ� �� ���� Y�࿡ ���� ������
                    i--;//���� X�� �������� -1
                    j++;//Y�� �������� -1�Ǵ� j�� �����
                    where = 3;//������ȯ
                    break;
                }
            case 3:// ��
            	nasen[i--][j] = number++;//��ȣ �����Ű�鼭 ��ȣ+1���ְ� X��-1��ŭ �̵�
            	if(nasen[i][j--] == 0) {
            		i++;
            		j--;
            		where = 2;
            		break;
            	}
                if (i == 0 || nasen[i][j] != 0) {
                	//������� ���� �̹� X�࿡ 0��° ���� ���� �� �ֱ� ������
                	//i�� 1��° �ٱ��� �� ä��� i==0�̵�
                	//�׷� �̶� ������ Ʋ���ְų� �� ���� �ڸ��� ���� ������ ����ٲ�
                    i++;//���� X�� �������� -1�Ǵ� i�� ����ְ�
                    j++;//Y�� �������� +1
                    where = 0;//������ȯ ��
                    break;
                }
            }

            if (number == number3-1)
            	//ó�� ���ڰ� 1���� �����ϱ� ������ + 1
            	//number�� ������ ���ڰ� �Ǹ� ��
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
