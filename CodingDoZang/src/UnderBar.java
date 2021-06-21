
import java.util.Scanner;

public class UnderBar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단어를 입력하시오.");
		String word = sc.nextLine();
		//String[] decode = word.split(""); 배열 사용했을때
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
		System.out.println("\n\n================호출해서 사용하기===============");
		//호출 = 다른 메소드 일 시키기
		//메소드이름(파라미터)
		String str2 = camel2pothole(word);
		System.out.println(str2);
		//파라미터 타입이 맞아야 된다.
		sc.close();
	}//main 메소드 끝
	//전체공개 객체안만듬 반환타입 이름(파라미터)
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
		return result;//임시로 이렇게
	}
}//클래스 끝
