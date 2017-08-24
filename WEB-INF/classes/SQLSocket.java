
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import com.mysql.jdbc.jdbc2.optional.MysqlPooledConnection;



public class SQLSocket {
	private String url = "jdbc:mysql://localhost:3306/";
	private String username = "";
	private String password = "";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void setupConnection(String databaseName, String username, String password){
		this.username = username;
		this.password = password;
		url += databaseName;
		System.out.println("Database information transfer successful");
	}
	
	public void connectToDatabase(){

		System.out.println("Connecting to database...");
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			System.out.println("Database connected!");
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Can't connect to database");
		}
		
		try {
			statement = connection.createStatement();
			System.out.println("Statement created!");
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Unable to create statement");
		}
		
	}
	public void pushNewData(String data){
		String command = "INSERT INTO espuploads (F1,F2,F3,F4,F5,F6,F7,F8) VALUES (" + data + ");"; 
		System.out.println(command);
		if(this.statement != null){
			try {
			this.statement.executeUpdate(command);
			}catch (SQLException e){
				e.printStackTrace();
				System.out.println("Unable to execute update");
			}
		}
		
	}
	

}