import java.util.Arrays;
import java.util.Scanner;

// 단어를 입력하면 모스부호가 출력되는 프로그램
public class Morse {

	public static void main(String[] args) {
		String str = ".... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--";
		System.out.println(str);
		String[] strArr = str.split(" ");
		System.out.println(Arrays.toString(strArr));
		String[] alpha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] mose = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", " "};
		for (int i = 0; i < mose.length; i++) {
			for (int j = 0; j < strArr.length; j++) {
				if(strArr[j].equals(mose[i])) {
					strArr[j] = alpha[i];
				}
			}
		}
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i]+" ");
		}
		System.out.println("\n\n\n=============이중배열==============\n\n");
		String[][] moseCode = {
				{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"},
				{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--","-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", " "}
		};
		String[] decode = str.split(" ");
		System.out.println(Arrays.toString(decode));
		for (int i = 0; i < decode.length; i++) {
			for (int j = 0; j < moseCode[0].length; j++) {
				if(decode[i].equals(moseCode[1][j])) {
					System.out.print(moseCode[0][j]);
					break;
				}
			}
			System.out.print("_");
		}
		System.out.println("\n\n\n=============단어 입력 받기==============\n\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("단어를 입력하시오.");
		String word = sc.nextLine();
		word = word.toUpperCase();
		String[] decode2 = word.split("");
		System.out.println(Arrays.toString(decode2));
		for (int i = 0; i < decode2.length; i++) {
			for (int j = 0; j < moseCode[0].length; j++) {
				if(decode2[i].equals(moseCode[0][j])) {
					System.out.print(moseCode[1][j]);
				}
			}
			System.out.print(" ");
		}
		sc.close();
	}

}
