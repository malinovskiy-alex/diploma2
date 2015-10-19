package com.malinovskiy.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
@NamedQuery(name = User.FIND_BY_EMAIL, query = "select a from User a where a.email = :email")
public class User implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "User.findByEmail";

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "ADDRESS")
	private String homeAddress;

	@Column(name = "PHONE")
	private String phone;
	
	@JsonIgnore
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role = "ROLE_USER";

    protected User() {
		super();
	}
	
	public User(String email, String password, String homeAddress, String phone, String username, String role) {
		this.email = email;
		this.username = username;
		this.homeAddress = homeAddress;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
