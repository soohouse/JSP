package user;

public class User {
	
	private String account;
	private String password;
	private String name;
	private String nickName;
	
	public User() {}
	 
	
	public User(String account, String password, String name, String nickName) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
	}



	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	

}
	