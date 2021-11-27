package test;

public class Test5 {

	public static void main(String[] args) {

		int year = 2020;
		int month = 12;
		int day = 29;

		String date = String.format("%d-%d-%d", year, month, day);
		System.out.println(date);

		// 특정 유형을 지칭하는 문자가 있다. -> 서식 문자
		// %d -> 정수
		// %f -> 실수
		// %s -> 문자

		int age = 22;
		String name = "홍길순";
		String str = String.format("안녕하세요 %d살 %s입니다.", age, name);

		System.out.println(str);

		// java 8 버전 X
		// java 16 버전 이상 쓰는 분들만 해당

		String sqlOrigin = """

				UPDATE article
				SET title = '%s',
				`body` = '%s'
				WHERE idx = %d

								""";
		String sql = String.format(sqlOrigin, "aaa", "bbb", 1);
		System.out.println(sql);

	}

}
