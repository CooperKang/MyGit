
import java.util.Scanner;

public class UnderBar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ܾ �Է��Ͻÿ�.");
		String word = sc.nextLine();
		//String[] decode = word.split(""); �迭 ���������
		for (int i = 0; i < word.length(); i++) {
			if(Character.isUpperCase(word.charAt(i))) {
				System.out.print("_"+Character.toLowerCase(word.charAt(i)));
				//decode[i] = "_"+decode[i].toLowerCase();
			}else if(Character.isDigit(word.charAt(i))) {
				System.out.print("_"+word.charAt(i));
				//decode[i] = "_"+decode[i];
			}else {
				System.out.print(word.charAt(i));
			}
		}
//		if(Character.isUpperCase(word.charAt(0))) {
//			decode[0] = decode[0].toLowerCase();
//		}
//		for (int i = 0; i < decode.length; i++) {
//			System.out.print(decode[i]);
//		}
		System.out.println("\n\n================ȣ���ؼ� ����ϱ�===============");
		//ȣ�� = �ٸ� �޼ҵ� �� ��Ű��
		//�޼ҵ��̸�(�Ķ����)
		String str2 = camel2pothole(word);
		System.out.println(str2);
		//�Ķ���� Ÿ���� �¾ƾ� �ȴ�.
		sc.close();
	}//main �޼ҵ� ��
	//��ü���� ��ü�ȸ��� ��ȯŸ�� �̸�(�Ķ����)
	public       static    String  camel2pothole(String camel) {
		String result = "";
		for (int i = 0; i < camel.length(); i++) {
			if(Character.isUpperCase(camel.charAt(i))) {
				result += "_" + Character.toLowerCase(camel.charAt(i));
			}else if(Character.isDigit(camel.charAt(i))) {
				result += "_" + camel.charAt(i);
			} else {
				result += camel.charAt(i);
			}
		}
		return result;//�ӽ÷� �̷���
	}
}//Ŭ���� ��
