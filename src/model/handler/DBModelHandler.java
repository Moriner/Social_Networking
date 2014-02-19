package model.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.ibm.db2e.jdbc.DB2eDataSource;

import model.type.Friend;
import model.type.LoginUser;
import model.type.Message;
import model.type.Profile;
import model.util.PhotoBlob;
import model.util.UnibookQueries;
import MAD_UnibookServiceTypes.MemberSummary;

public class DBModelHandler
	extends DefaultModelHandler
	implements UnibookQueries {
	private DB2eDataSource dataSource;
	private DefaultModelHandler handler;
	private static final String DB_URL = "jdbc:db2e:Ass2-chenchao";
	private Connection conn;
	private PreparedStatement ps;
	private Statement stmt;
	private ResultSet results;

	public DBModelHandler() {
		initDatabase();
	}

	public boolean initDatabase() {
		boolean flag = false;
		dataSource = new DB2eDataSource();
		dataSource.setUrl(DB_URL);
		try {
			openConnections();
			try {
//				stmt.executeUpdate(DROP_SUMMARY_TABLE);
//				stmt.executeUpdate(DROP_PHOTO_TABLE);
//				stmt.executeUpdate(DROP_USER_TABLE);
//				stmt.executeUpdate(DROP_FRIEND_TABLE);
//				stmt.executeUpdate(DROP_MESSAGE_TABLE);
				stmt.executeUpdate(CREATE_SUMMARY_TABLE);
				stmt.executeUpdate(CREATE_PHOTO_TABLE);
				stmt.executeUpdate(CREATE_USER_TABLE);
				stmt.executeUpdate(CREATE_FRIEND_TABLE);
     			stmt.executeUpdate(CREATE_MESSAGE_TABLE);
				flag = true;
				System.out.println("DB tables created\n");
			} catch (SQLException exp) {
				System.out.println("DB tables have already existed\n");
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		return flag;
	}

	public boolean dropDatabase() {
		boolean flag = false;
		try {
			stmt.executeUpdate(DROP_SUMMARY_TABLE);
			stmt.executeUpdate(DROP_PHOTO_TABLE);
			stmt.executeUpdate(DROP_USER_TABLE);
			stmt.executeUpdate(DROP_FRIEND_TABLE);
			stmt.executeUpdate(DROP_MESSAGE_TABLE);
			flag = true;
		} catch (SQLException exp) {
			System.out.println("tables don't exist\n");
		} finally {
			closeConnections();
		}
		return flag;
	}


	
	public boolean getLogin(String uName, String pass, boolean isOnline){
		boolean flag = false;
		if(isOnline == true){
			try{
				openConnections();
				ps = conn.prepareStatement(SELECT_PERSONAL_INFO);
				ps.setString(1, uName);
				ps.setString(2, pass);
				results = ps.executeQuery();
				while(results.next()){
					flag = true;
					System.out.println("DB HANDLER: GET LOGIN\n ");
				}

			}catch (Exception exp) {
				exp.printStackTrace();
			} finally {
				closeConnections();
			}
			if(flag == false){
				flag = nextHandler().getLogin(uName, pass, isOnline);
			}
		}else{
			try{
				openConnections();
				ps = conn.prepareStatement(SELECT_PERSONAL_INFO);
				ps.setString(1, uName);
				ps.setString(2, pass);
				results = ps.executeQuery();
				while(results.next()){
					flag = true;
					System.out.println("DB HANDLER: GET LOGIN\n ");
				}
			}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		}
		return flag;
	}
	
	public boolean setLogin(LoginUser login){
		boolean flag = false;
		try{
			openConnections();
			if (login != null){
				ps = conn.prepareStatement(INSERT_PERSONAL);
				ps.setString(1, login.getUsername());
				ps.setString(2, login.getPassword());
				ps.executeUpdate();
				flag = true;
				System.out.println("DB HANDLER: STORE LOGIN\n ");
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		return flag;
	}
	
	public boolean addFriend(String uName, String fName){
		boolean flag = true; 
		try{
			openConnections();
			if(uName != null){
				ps = conn.prepareStatement(SELECT_FRIEND_ALONE);
				ps.setString(1, uName);
				ps.setString(2, fName);
				results = ps.executeQuery();
				while(results.next()){
					flag = false;
					System.out.println(uName+" already has a friend named "+fName+"\n");
				}
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		if(flag == true){
			try{
				openConnections();
				int i = 0;
				if(uName != null){
					ps = conn.prepareStatement(SELECT_FRIEND);
					ps.setString(1, uName);
					results = ps.executeQuery();
					while(results.next()){
						i++;
					}
					if (i<5){
						ps = conn.prepareStatement(INSERT_FRIEND);
						ps.setInt(1, i+1);
						ps.setString(2, uName);
						ps.setString(3, fName);
						ps.executeUpdate();
					}else {
						ps = conn.prepareStatement(DELETE_FIRST_FRIEND);
						ps.setString(1, uName);
						ps.executeUpdate();
						ps = conn.prepareStatement(UPDATE_FRIEND_NUMBER);
						ps.setString(1, uName);
						ps.executeUpdate();
						ps = conn.prepareStatement(INSERT_FRIEND);
						ps.setInt(1, 5);
						ps.setString(2, uName);
						ps.setString(3, fName);
						ps.executeUpdate();
					}
					System.out.println("DB HANDLER: ADD FRIEND\n ");
				}
			}
			catch (Exception exp) {
				exp.printStackTrace();
			} finally {
				closeConnections();
			}
		}
		return flag;
	}
	
	public boolean isFriend(String uName, String fName){
		boolean flag = true;
		try{
			openConnections();
			if(uName != null){
				ps = conn.prepareStatement(SELECT_FRIEND_ALONE);
				ps.setString(1, uName);
				ps.setString(2, fName);
				results = ps.executeQuery();
				while(results.next()){
					flag = false;
				}
			}
		}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		return flag;
	}
	
	public Friend[] getFriend(String uName){
		Friend[] friend = null;
		try{
			openConnections();
			if(uName != null){
				int i = 0;
				ps = conn.prepareStatement(SELECT_FRIEND);
				ps.setString(1, uName);
				results = ps.executeQuery();
				while(results.next()){
					i++;
				}
				friend = new Friend[i];
				while(i>0){
					friend[i-1] = new Friend(uName);
					i--;
				}
				ps = conn.prepareStatement(SELECT_FRIEND);
				ps.setString(1, uName);
				results = ps.executeQuery();
				int m = 0;
				while(results.next()){
					friend[m].setNumber(results.getInt(1));
					friend[m].setUsername(results.getString(2));
					friend[m].setFriendName(results.getString(3));
					m++;
				}
				System.out.println("DB HANDLER: GET FRIEND\n ");
			}
		}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		return friend;
	}
	
	public boolean deleteFriend(String uName, String fName){
		boolean flag = false;
		try{
			openConnections();
			if (uName != null){
				int i = 0;
				ps = conn.prepareStatement(SELECT_FRIEND_ALONE);
				ps.setString(1, uName);
				ps.setString(2, fName);
				results = ps.executeQuery();
				while(results.next()){
					i = results.getInt(1);
				}
				ps = conn.prepareStatement(DELETE_FRIEND);
				ps.setString(1, uName);
				ps.setString(2, fName);
				ps.executeUpdate();
				ps = conn.prepareStatement(UPDATE_FRIEND_NUMBER_DELETE);
				ps.setInt(1, i);
				ps.executeUpdate();
				System.out.println("DB HANDLER: DELETE FRIEND\n ");
				flag = true;
			}
		}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		return flag;
	}

	public boolean setProfile(Profile pro) {
		boolean flag = false;
		try {
			System.out.println("DB HANDLER: STORE PROFILE\n");
			openConnections();
			if (pro != null) {
	
	
				byte photo[] = pro.getPhoto();
				
				ByteArrayInputStream bis = new ByteArrayInputStream(photo);
				byte[] b = new byte[30000];
				int count = 0;
				int section = 1;
				try {
					while ((count = bis.read(b)) > 0) {
						ps = conn.prepareStatement(INSERT_PHOTOBLOB);
						ps.setString(1, pro.getUsername());
						ps.setInt(2, section);
						ps.setBlob(3, new PhotoBlob(b));
						ps.executeUpdate();
						section++;
					}

				ps = conn.prepareStatement(UPDATE_SUMMARY);
				ps.setString(1, pro.getProfile());
				ps.setString(2, pro.getUsername());
				ps.executeQuery();
					flag = true;
				} catch (IOException e1) {
					e1.printStackTrace();
				}


				
				flag = true;
				System.out.println("DB HANDLER: UPDATING CACHE\n");
				previousHandler().setProfile(pro);
			} else {
				System.out.println("MemberProfile is null\n");
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
		return flag;
	}

	public Profile getProfile(String username) {
		boolean found = false;
		boolean found1 = false;

		System.out.println("DB HANDLER: GET PROFILE\n");

		Profile pro = new Profile(username);
		
		try {
			openConnections();
			ps = conn.prepareStatement(SELECT_PHOTO);
			ps.setString(1, username);
			results = ps.executeQuery();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while (results.next()) {
				int section = results.getInt("section");
				Blob b = results.getBlob("photo");
				bos.write(b.getBytes((long) 1, (int) b.length()));
				found = true;
			}
			pro.setPhoto(bos.toByteArray());
			bos.close();
			
			ps = conn.prepareStatement(SELECT_SUMMARY);
			ps.setString(1, username);
			results = ps.executeQuery();
			while(results.next()){
				pro.setProfile(results.getString(5));
				found1 = true;
			}

		
		}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}
			if (found && found1) {
				System.out.println("DB HANDLER: PROFILE FOUND\n");
				previousHandler().setProfile(pro);
				return pro;
			} else {
				System.out.println("DB HANDLER: PROFILE NOT FOUND\n");
				return nextHandler().getProfile(username);
			}
		
			

	}

	public MemberSummary getSummary(String username) {
		boolean found = false;

		System.out.println("DB HANDLER: GET SUMMARY\n");

		MemberSummary memberSummary = new MemberSummary();

		try {
			openConnections();

			ps = conn.prepareStatement(SELECT_SUMMARY);

			ps.setString(1, username);
			results = ps.executeQuery();
			while(results.next()) {
				String a = results.getString(3);
				if(a != null){

				memberSummary.setUsername(results.getString(1));
				memberSummary.setGender(results.getString(2));
				memberSummary.setProgramCode(results.getString(3));
				memberSummary.setAge(results.getInt(4));
				
				found = true;
				}

			}

		} catch (SQLException e) {

		} finally {
			closeConnections();
		}
		if (found) {
			System.out.println("DB HANDLER: SUMMARY FOUND\n");
			previousHandler().setSummary(username, memberSummary);
			return memberSummary;
		} else {
			System.out.println("DB HANDLER: SUMMARY NOT FOUND\n");
			return nextHandler().getSummary(username);
		}
	}

	public boolean setSummary(String username, MemberSummary memberSummary) {
		boolean flag = false;
		try {
			System.out.println("DB HANDLER: STORE SUMMARY\n");
			openConnections();
			if (memberSummary.getUsername() != null) {
				
			
				ps = conn.prepareStatement(INSERT_SUMMARY);
				ps.setString(1,memberSummary.getUsername());
				ps.setString(2, memberSummary.getGender());
				ps.setString(3, memberSummary.getProgramCode());
				ps.setInt(4, memberSummary.getAge());
				ps.setString(5, "profile");
				ps.executeUpdate();
				flag = true;

				previousHandler().setSummary(username, memberSummary);

			} else {
				System.out.println("MemberSummary is null\n");
			}
		} catch (Exception exp) {
			exp.printStackTrace();

		} finally {
			closeConnections();
		}
		return flag;
	}
	
	public void storeSentMessage(Message message){
		if(!message.getContent().equals("")){
			try {
				openConnections();
				ps = conn.prepareStatement(INSERT_MESSAGE);
				ps.setString(1, message.getSender());
				ps.setString(2, message.getTime());
				ps.setString(3, message.getRecipient());
				ps.setString(4, message.getContent());
				ps.setString(5, "f");
				ps.executeUpdate();
				System.out.println("DB HANDLER: STORE SENT MESSAGE\n");
			} catch (Exception exp) {
				exp.printStackTrace();
			} finally {
				closeConnections();
			}
		}
	}
	
	public void storeRecivedMessage(Message message){
		if(!message.getContent().equals("")){
			try {
				openConnections();
				ps = conn.prepareStatement(INSERT_MESSAGE);
				ps.setString(1, message.getSender());
				ps.setString(2, message.getTime());
				ps.setString(3, message.getRecipient());
				ps.setString(4, message.getContent());
				ps.setString(5, "t");
				ps.executeUpdate();
				System.out.println("DB HANDLER: STORE RECEIVED MESSAGE\n");
			} catch (Exception exp) {
				exp.printStackTrace();
			} finally {
				closeConnections();
			}
		}
	}
	
	public Message[] getRecivedMessage(String uName, String password){
		Message[] message = null;
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();
		boolean found = false;
		try{
			openConnections();
			ps = conn.prepareStatement(SELECT_RECEIVE_MESSAGE);
			ps.setString(1, uName);
			results = ps.executeQuery();
			while(results.next()){
				v1.addElement(results.getString(1));
				v2.addElement(results.getString(2));
				v3.addElement(results.getString(4));
				found = true;
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}			
		if(found){
			System.out.println("DB HANDLER: GET RECEIVED MESSAGE\n");
			int i = v1.size();
			message = new Message[i];
			for(;i>0;i--){
				message[i-1] = new Message(v1.elementAt(i-1).toString());
				message[i-1].setRecipient(uName);
				message[i-1].setTime(v2.elementAt(i-1).toString());
				message[i-1].setSender(v1.elementAt(i-1).toString());
				message[i-1].setContent(v3.elementAt(i-1).toString());
			}
			return message;
		}else {
			return null;
		}
	}
	
	public Message[] getSentMessage(String uName){
		Message[] message = null;
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();
		boolean found = false;
		try{
			openConnections();
			ps = conn.prepareStatement(SELECT_SEND_MESSAGE);
			ps.setString(1, uName);
			results = ps.executeQuery();
			while(results.next()){
				v1.addElement(results.getString(2));
				v2.addElement(results.getString(3));
				v3.addElement(results.getString(4));
				found = true;
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}		
		if(found){
			System.out.println("DB HANDLER: GET SENT MESSAGE\n");
			int i = v1.size();
			message = new Message[i];
			for(;i>0;i--){
				message[i-1] = new Message(uName);
				message[i-1].setSender(uName);
				message[i-1].setTime(v1.elementAt(i-1).toString());
				message[i-1].setRecipient(v2.elementAt(i-1).toString());
				message[i-1].setContent(v3.elementAt(i-1).toString());
			}
		}
		previousHandler().setSentMessage(message);
		return message;
	}
	
	public boolean DeleteRecivedMessage(String sender,String timer){
		boolean flag = false;
		try{
			openConnections();
			ps = conn.prepareStatement(DELETE_RECEIVE_MESSAGE);
			ps.setString(1, sender);
			ps.setString(2, timer);
			ps.executeUpdate();
			System.out.println("DB HANDLER: DELETE RECEIVED MESSAGE\n");
			flag = true;
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}	
		return flag;
	}
	
	public boolean DeleteSentMessage(String recipient, String timer){
		boolean flag = false;
		try{
			openConnections();
			ps = conn.prepareStatement(DELETE_SENT_MESSAGE);
			ps.setString(1, recipient);
			ps.setString(2, timer);
			ps.executeUpdate();
			System.out.println("DB HANDLER: DELETE SENT MESSAGE\n");
			flag = true;
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}	
		return flag;
	}
	
	public Message getSentMessage(String recipient, String timer){
		Message message = null;
		try{
			openConnections();
			ps = conn.prepareStatement(SELECT_SEND_MESSAGE_ALONE);
			ps.setString(1, recipient);
			ps.setString(2, timer);
			results = ps.executeQuery();
			while(results.next()){
				message = new Message(results.getString(1));
				message.setTime(results.getString(2));
				message.setRecipient(results.getString(3));
				message.setContent(results.getString(4));
			}
			System.out.println("DB HANDLER: GET SENT MESSAGE\n");
		}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}	
		return message;
	}
	
	public Message getRecivedMessage(String uName, String sender, String timer){
		Message message = null;
		try{
			openConnections();
			ps = conn.prepareStatement(SELECT_RECEIVE_MESSAGE_ALONE);
			ps.setString(1, sender);
			ps.setString(2, timer);
			results = ps.executeQuery();
			while(results.next()){
				message = new Message(results.getString(1));
				message.setTime(results.getString(2));
				message.setRecipient(results.getString(3));
				message.setContent(results.getString(4));
			}
			System.out.println("DB HANDLER: GET RECEIVED MESSAGE\n");
		}catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			closeConnections();
		}	
		return message;
	}
	


	public void openConnections() {
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public void closeConnections() {
		try {
			if (results != null)
				results.close();
			if (ps != null)
				ps.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
