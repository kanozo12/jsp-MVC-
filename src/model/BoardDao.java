package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDao {
	//private Connection conn;
	private DataSource ds;
	private static BoardDao dao = new BoardDao();
	private BoardDao(){
		//DataSource를 lookup 하는 부분이 여기 들어있었다..지금은 따로 뽑아냈다.
		ds=DataSourceManager.getInstance().getConnection();		
	}
	public static BoardDao getInstance(){
		return dao;
	}
	//이전의 dao와 변경된 지점...Connection을 리턷받는 곳을 따로 관리한다..
	//DataSourceManager 로 기능을 분리했다.
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null)
			ps.close();
		if(conn !=null)
			conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	/////////////////////////////////////Business Login/////////////////////////////
	
	/*
	 * 게시판의 글을 작성하는 로직..
	 */
	public void posting(BoardVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			//하나의 게시글을 입력하는 쿼리문을 작성...이부분을 메타데이타화
			//properties 파일-> 인터페이스 --> xml --> @annotation
			ps = conn.prepareStatement(StringQuery.INSERT_POSTING);
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getWriter());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getContent());
			
			int row = ps.executeUpdate();
			System.out.println(row+" row INSERT POSTING!!");
			
			//쿼리문이 하나 더 돌아가야 한다...값을 vo에 주입
			ps=  conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()){
				vo.setNo(rs.getInt(1));
			}
			System.out.println("dao INSERT...OK..No ::"+vo.getNo());
		}finally{
			closeAll(rs, ps, conn);
		}
		
	}//posting()
	
	public BoardVO getPostingByNo(int no)throws SQLException{
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_POSTING);
			ps.setInt(1,no);
			rs = ps.executeQuery();
			if(rs.next()){
				vo = new BoardVO(no, 
						rs.getString("title"), 
						rs.getString("writer"),
						rs.getString("content"),
						rs.getInt("hits"), 
						rs.getString(6));
				System.out.println("getPostingByNo..ok");
			}			
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	
	
	
	public ArrayList<BoardVO> getPostingList() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try{
			conn  =  getConnection();
			ps = conn.prepareStatement(StringQuery.PAGE_LIST);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new BoardVO(rs.getInt("no"), 
						rs.getString("title"),
						rs.getString("writer"), 
						null, 
						null, 
						rs.getInt("hits"), 
						rs.getString("time_posted")));
			}
			
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}//

	public boolean checkPassword(int no,String password)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result =  false;
		
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.PASS_CHECK);
			ps.setInt(1, no);
			ps.setString(2, password);
			rs=  ps.executeQuery();
			if(rs.next()){
				if(rs.getInt(1) !=0 ) result = true;
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return result;
	}	//
	
	public void deletePosting(int no)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.DELETE_POSTING);
			ps.setInt(1,no);
			
			int row = ps.executeUpdate();
			System.out.println("dao....deletePosting..."+row);
		}finally{
			closeAll(ps, conn);
		}
	}//
	
	public void updatePosting(BoardVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_POSTING);
			ps.setString(1,vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			ps.setInt(4, vo.getNo());
			
			int row = ps.executeUpdate();
			System.out.println("dao....updatePosting.."+row);
		}finally{
			closeAll(ps, conn);
		}
	}
	
	public void updateHits(int no, int hits) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_HITS);
			ps.setInt(1, hits);
			ps.setInt(2, no);
			
			int row = ps.executeUpdate();
			System.out.println("dao.....updateHits.."+row);
			
		}finally{
			closeAll(ps, conn);
		}
	}
}



























