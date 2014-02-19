package model.util;

/**
 * @author ChenChao
 *
 */
public interface UnibookQueries {
	static final String CREATE_SUMMARY_TABLE =
		"CREATE TABLE memberSummary (userName VARCHAR(50) PRIMARY KEY, gender VARCHAR(10),pid VARCHAR(20),age INT,profile VARCHAR(256))";
	static final String CREATE_PHOTO_TABLE =
		"CREATE TABLE memberPhoto (userName VARCHAR(50),section INT, photo BLOB(30000))";
	static final String CREATE_USER_TABLE =
		"CREATE TABLE personalDetails (userName VARCHAR(50) PRIMARY KEY, password VARCHAR(20))";
	static final String CREATE_FRIEND_TABLE =
		"CREATE TABLE friend (friendNumber INT, userName VARCHAR(50), friend VARCHAR(50))";
	static final String CREATE_MESSAGE_TABLE =
		"CREATE TABLE message (senderName VARCHAR(50), data_time VARCHAR(50), recipient VARCHAR(50), content VARCHAR(300), type VARCHAR(5))";
	    
	static final String DROP_SUMMARY_TABLE = "DROP TABLE memberSummary";
	static final String DROP_PHOTO_TABLE ="DROP TABLE memberPhoto";
	static final String DROP_USER_TABLE ="DROP TABLE personalDetails";
	static final String DROP_FRIEND_TABLE ="DROP TABLE friend";
	static final String DROP_MESSAGE_TABLE ="DROP TABLE message";
	
	static final String INSERT_SUMMARY =
		"INSERT INTO memberSummary VALUES(?,?,?,?,?)";
	static final String INSERT_PHOTOBLOB =
		"INSERT INTO memberPhoto VALUES(?,?,?)";
	static final String INSERT_PERSONAL =
		"INSERT INTO personalDetails VALUES(?,?)";
	static final String INSERT_FRIEND =
		"INSERT INTO friend VALUES(?,?,?)";
	static final String INSERT_MESSAGE =
		"INSERT INTO message VALUES(?,?,?,?,?)";
	static final String UPDATE_SUMMARY =
	 	"UPDATE memberSummary SET profile = ? WHERE username = ?";
	static final String UPDATE_FRIEND_NUMBER =
		"UPDATE friend SET friendNumber = friendNumber -1 WHERE userName = ?";
	static final String UPDATE_FRIEND_NUMBER_DELETE =
		"UPDATE friend SET friendNumber = friendNumber -1 WHERE friendNumber > ?";
	 
	static final String SELECT_SUMMARY =
	"SELECT * FROM memberSummary WHERE username = ?"; 
	static final String SELECT_PHOTO = 
	"SELECT * FROM memberPhoto WHERE username = ? ORDER BY section ASC";
	static final String SELECT_PERSONAL_INFO = "SELECT * FROM personalDetails WHERE username = ? and password = ?";
	static final String SELECT_FULLSUMMARY = 
	"SELECT * FROM memberProfile WHERE profile IS NOT NULL";
	static final String SELECT_SUMMARIES = 
	"SELECT * FROM memberSummary ORDER BY username ASC";
	static final String SELECT_FRIEND_ALONE =
	"SELECT * FROM friend WHERE userName = ? and friend = ?";
	static final String SELECT_FRIEND = 
	"SELECT * FROM friend WHERE userName = ? ORDER BY friendNumber ASC";
	static final String SELECT_SEND_MESSAGE =
	"SELECT * FROM message WHERE senderName = ? and type = 'f'";
	static final String SELECT_RECEIVE_MESSAGE =
	"SELECT * FROM message WHERE recipient = ? and type = 't'";
	static final String SELECT_SEND_MESSAGE_ALONE =
	"SELECT * FROM message WHERE recipient ? and data_time = ?";
	static final String SELECT_RECEIVE_MESSAGE_ALONE =
	"SELECT * FROM message WHERE senderName = ? and data_time = ?";
    
	static final String DELETE_SUMMARY =
	"DELETE FROM memberSummary WHERE username = ?";
	static final String DELETE_SUMMARIES = 
	 "DELETE FORM memberSummary";
	static final String DELETE_PHOTO =
	"DELETE FROM memberPhoto WHERE username = ?";
	static final String DELETE_PHOTOS =
	"DELETE FORM memberPhoto";
	static final String  DELETE_PERSONAL_INFO ="DELETE FROM personalDetails WHERE username = ?";
	static final String DELETE_PARTIAL_SUMMARY =
	"DELETE FROM memberProfile WHERE profile IS NULL";
	static final String DELETE_FRIEND = 
	"DELETE FROM friend WHERE userName = ? and friend = ?";
	static final String DELETE_FIRST_FRIEND =
	"DELETE FROM friend WHERE userName = ? and friendNumber = 1";
	static final String DELETE_SENT_MESSAGE =
	"DELETE FROM message WHERE recipient = ? and type = 'f' and data_time = ?";
	static final String DELETE_RECEIVE_MESSAGE =
	"DELETE FROM message WHERE senderName = ? and type = 't' and data_time = ?";
}
