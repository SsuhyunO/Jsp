package kr.co.jboard.util;

public class SQL {
	// Article
	public static final String INSERT_ARTICLE = "INSERT INTO Article SET "
															+ "type='free',"
															+ "title=?,"
															+ "content=?,"
															+ "writer=?,"
															+ "regip=?,"
															+ "wdate=NOW()";
	public static final String SELECT_ARTICLE = "SELECT * FROM Article WHERE an=?";
	public static final String SELECT_ALL_ARTICLE = "SELECT * FROM Article";
	public static final String UPDATE_ARTICLE = "UPDATE ARTICLE SET "
															+ "title=?,"
															+ "content=? "
															+ "WHERE ano=?";
	public static final String DELETE_ARTICLE = "DELETE FROM Article WHERE ano=?";
	
	// User
	public static final String INSERT_USER = "INSERT INTO User(userid, pass, name, nick, email, hp, zip, addr1, addr2, regip, regDate, leaveDate)"
																									+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
	public static final String SELECT_USER = "SELECT * FROM User WHERE userid=?";
	public static final String SELECT_ALL_USER = "SELECT * FROM User";
	public static final String UPDATE_USER = "";
	public static final String DELETE_USER = "DELETE FROM User WHERE userid=?";
	
	// File
	public static final String INSERT_FILE = "INSERT File(ano, ofname, sfname, rdate) INTO"
																				+"(?, ?, ?, NOW())";
	public static final String SELECT_FILE = "SELECT * FROM File WHERE fno=?";
	public static final String SELECT_ALL_FILE = "SELECT * FROM File";
	public static final String UPDATE_FILE = "";
	public static final String DELETE_FILE = "DELETE FROM File WHERE fno=?";
	
	// Comment
	public static final String INSERT_COMMENT= "INSERT Comment(parent, content, writer, regip, wdate) INTO"
																				+ "(?, ?, ?, ?, NOW())";
	public static final String SELECT_COMMENT = "SELECT * FROM Comment WHERE cno=?";
	public static final String SELECT_ALL_COMMENT = "SELECT * FROM Comment";
	public static final String UPDATE_COMMENT = "";
	public static final String DELETE_COMMENT = "DELETE FROM Comment WHERE cno=?";
	
	// Terms
	public static final String INSERT_TERMS = "INSERT Terms(basic, privacy) INTO (?, ?)";
	public static final String SELECT_TERMS = "SELECT * FROM Terms WHERE no=?";
	public static final String SELECT_ALL_TERMS = "SELECT * FROM Terms";
	public static final String UPDATE_TERMS = "";
	public static final String DELETE_TERMS = "DELETE FROM Terms WHERE no=?";

}
