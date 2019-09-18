package model;
/*
 * Dao 에서는 비지니시 로직에 사용되는 쿼리문이 일일이 들어갔었다...
 * 이런 요인들 때문에 dao의 비지니스 로직 자체는 길어질수 밖에 없다.
 * 또한,
 * 쿼리문이 변경될때마다 비지니스 로직의 수정은 불가피 하다.
 * --->
 * 쿼리문을 따로 분리시키겠따.
 * 분리시킨 Template이 바로 StringQuery이다.
 * -->
 * 나중에서는 이것을 XML에 매핑시킬 것이다. :: iBatis / myBatis
 */
public interface StringQuery {
	String INSERT_POSTING=
			"INSERT INTO board (no, title, writer, password, content, time_posted)"
			+ " VALUES(board_seq.nextVal,?,?,?,?,sysdate)";
	
	String CURRENT_NO = 
			"SELECT board_seq.currVal FROM dual";
	
	String SELECT_POSTING = 
			"SELECT no,title, writer, content,hits,time_posted FROM board WHERE no=?";
	
	String PAGE_LIST = "SELECT no, title, writer, hits, to_char(time_posted, 'YYYY.MM.DD') time_posted FROM board";
	
	String PASS_CHECK ="SELECT COUNT(-1) FROM board WHERE no=? AND password=? ";
	String DELETE_POSTING="DELETE FROM board WHERE no=?";
	
	String UPDATE_POSTING = "UPDATE board SET title=?, writer=? , content=? WHERE no=?";
	
	String UPDATE_HITS = "UPDATE board SET hits=?+1 WHERE no=?";
}


















