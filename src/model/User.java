package model;

public class User extends Person{
	int id;
	boolean userAgreement;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	public User(String username, String password, String first_name, String last_name, String email, int id,
			boolean userAgreement) {
		super(username, password, first_name, last_name, email);
		this.id = id;
		this.userAgreement = userAgreement;
	}
	public User(String username, String password, String first_name, String last_name, String email,
			boolean userAgreement) {
		super(username, password, first_name, last_name, email);
		this.userAgreement = userAgreement;
	}
	public User(String username, String password, String first_name, String last_name, String email) {
		super(username, password, first_name, last_name, email);
	}
	
}