import java.util.Arrays;
import java.util.Scanner;
//may28�� �ִ� RunLength ����
public class ArrayZip {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ܾ �Է����ּ���.");
		String word = sc.nextLine() + " ", num = "";
		String[] decode = word.split("");
		System.out.println(Arrays.toString(decode));
		int count = 1;
		for (int i = 0; i < decode.length-1; i++) {
            if (word.charAt(i) == word.charAt(i + 1))
                count++;
            else {
            	num += word.charAt(i) + (count + "");
                count = 1;
            }
		}
        System.out.println(num);
		sc.close();
	}
}
