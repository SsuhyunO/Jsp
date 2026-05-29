package util;

public class SQL {
	// user1
	public static final String INSERT_USER1 = "INSERT INTO User1 VALUES(?, ?, ?, ?, ?)";
	public static final String SELECT_USER1 = "SELECT * FROM User1 WHERE userid = ?";
	public static final String SELECT_ALL_USER1 = "SELECT * FROM User1";
	public static final String UPDATE_USER1 = "UPDATE User1 SET "
												+ "name = ?,"
												+ "birth = ?,"
												+ "hp = ?,"
												+ "age = ? "
												+ "WHERE userid = ?";
	public static final String DELETE_USER1 = "DELETE FROM User1 WHERE userid = ?";
	
	// user2
	public static final String INSERT_USER2 = "INSERT INTO User2 VALUES(?, ?, ?, ?)";
	public static final String SELECT_USER2 = "SELECT * FROM User2 WHERE userid = ?";
	public static final String SELECT_ALL_USER2 = "SELECT * FROM User2";
	public static final String UPDATE_USER2 = "UPDATE User2 SET "
												+ "name = ?,"
												+ "birth = ?,"
												+ "addr = ? "
												+ "WHERE userid = ?";
	public static final String DELETE_USER2 = "DELETE FROM User2 WHERE userid = ?";
	
	// user3
	public static final String INSERT_USER3 = "INSERT INTO User3 VALUES(?, ?, ?, ?, ?)";
	public static final String SELECT_USER3 = "SELECT * FROM User3 WHERE userid = ?";
	public static final String SELECT_ALL_USER3 = "SELECT * FROM User3";
	public static final String UPDATE_USER3 = "UPDATE User3 SET "
												+ "name = ?,"
												+ "birth = ?,"
												+ "hp = ?,"
												+ "addr = ? "
												+ "WHERE userid = ?";
	public static final String DELETE_USER3 = "DELETE FROM User3 WHERE userid = ?";

	// user4
	public static final String INSERT_USER4 = "INSERT INTO User4 VALUES(?, ?, ?, ?, ?, ?)";
	public static final String SELECT_USER4 = "SELECT * FROM User4 WHERE userid = ?";
	public static final String SELECT_ALL_USER4 = "SELECT * FROM User4";
	public static final String UPDATE_USER4 = "UPDATE User4 SET "
												+ "name = ?,"
												+ "gender = ?,"
												+ "age = ?,"
												+ "hp = ?,"
												+ "addr = ? "
												+ "WHERE userid = ?";
	public static final String DELETE_USER4 = "DELETE FROM User4 WHERE userid = ?";
		
	// user5
	public static final String INSERT_USER5 = "INSERT INTO User5(name, gender, age, addr) VALUES(?, ?, ?, ?)";
	public static final String SELECT_USER5 = "SELECT * FROM User5 WHERE seq = ?";
	public static final String SELECT_ALL_USER5 = "SELECT * FROM User5";
	public static final String UPDATE_USER5 = "UPDATE User5 SET "
												+ "name = ?,"
												+ "gender = ?,"
												+ "age = ?,"
												+ "addr = ? "
												+ "WHERE seq = ?";
	public static final String DELETE_USER5 = "DELETE FROM User5 WHERE seq = ?";
}
