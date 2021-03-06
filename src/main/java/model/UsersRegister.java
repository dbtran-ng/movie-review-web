package model;

import java.io.Serializable;

public class UsersRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userid;
	private String firstname;
    private String lastname;
    private String address;
    private String state;
    private String username;
    private String password;
    private String email;
    
    public UsersRegister(String userid, String firstname, String lastname, String address, String state, String username,
			String password, String email) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.state = state;
		this.username = username;
		this.password = password;
		this.email = email;
	}
    public UsersRegister(String firstname, String lastname, String address, String state, String username,
			String password, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.state = state;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public UsersRegister() {

	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String fname) {
		this.firstname = fname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lname) {
		this.lastname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}