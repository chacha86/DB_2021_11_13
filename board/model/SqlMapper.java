package board.model;

import java.util.ArrayList;

import board.Article;
import board.member.Member;

public class SqlMapper {
	
	DBUtil db = new DBUtil();
	
	public ArrayList<Article> getSearchedList(String keyword) {
		String sql = """
				
				SELECT *
				FROM article
				WHERE title LIKE '%%%s%%'
				
				""";
		
		sql = String.format(sql, keyword);
		return db.getDataList(sql);
		
	}
	
	
	public ArrayList<Article> getArticleList() {
		String sql = """
				SELECT *
				FROM article
				""";
					
		ArrayList<Article> articleList = db.getDataList(sql);
		return articleList;
	}

	public Article getArticleById(int id) {

		String sql = """
				
				SELECT *
				FROM article
				WHERE idx = %d
				
				""";
		
		sql = String.format(sql, id);
		return db.getData(sql);
	}
	
	
	public void updateArticle(Article a) {
		
			String sql = """

					UPDATE article
					SET title = '%s',
					`body` = '%s'
					WHERE idx = %d
					
					""";
			sql = String.format(sql, a.getTitle(), a.getBody(), a.getNo());
			db.updateData(sql);
	}
	
	public void insertArticle(Article a) {
		String sql = """
				
				INSERT INTO article 
				SET title = '%s', 
				`body` = '%s', 
				nickname = '%s',
				regDate = '%s'
				
				""";
		
		sql = String.format(sql, a.getTitle(), a.getBody(), a.getWriter(), a.getRegDate());
		db.updateData(sql);
	}
	
	public void deleteArticle(int id) {
		String sql = """
				
				DELETE
				FROM article
				WHERE idx = %d
				
				""";
		sql = String.format(sql, id);
		db.updateData(sql);
		
	}
	
	public void insertMember(Member m) {
		String sql = """
				
				INSERT INTO `member`
				SET loginId = '%s',
				loginPw = '%s',
				nickname = '%s',
				regDate = NOW()
					
				""";
		sql = String.format(sql, m.getLoginId(), m.getLoginPw(), m.getNickname());
		db.updateData(sql);
	}
}
