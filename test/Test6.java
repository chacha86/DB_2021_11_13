package test;

public class Test6 {

	public static void main(String[] args) {
		String sql = """
		SELECT *
		FROM article
		WHERE title LIKE '%%%s%%'
				""";
		
		sql = String.format(sql, "test");
		
		System.out.println(sql);

	}

}
