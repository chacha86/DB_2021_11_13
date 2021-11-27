package board.model;

import java.util.ArrayList;

import board.Article;

public class SqlMapper {
	
	DBUtil db = new DBUtil();
	
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
		ArrayList<Article> articleList = db.getDataList(sql);
		
		if(articleList.size() > 0) {
			articleList.get(0);
		}
		return null;
	}
	
	
	public void updateArticle(Article a) {
		
			String sqlOrigin = """

					UPDATE article
					SET title = '%s',
					`body` = '%s'
					WHERE idx = %d

									""";
			String sql = String.format(sqlOrigin, a.getTitle(), a.getBody(), a.getNo());
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
		
		String.format(sql, a.getTitle(), a.getBody(), a.getWriter(), a.getRegDate());
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
}
