package com.lakazambia.api.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long user_id;
	/*@Column(name = "role_id")
	private Long role_id=2L;*/
	
	
	
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;
	
	@Column(name="social")
	private String social;

	@Column(name = "mobile")
	private long mobile;

	@Column(name = "email")
	private String email;

	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="about")
	private String about;
	
	@Column(name="websiteUrl")
	private String websiteUrl;
	
	@Column(name="avatar")
	private String avatar;

/*	@Column(name="role")
	private String role;*/
	
//	public User(String role) {
//		super();
//		this.role = role;
//	}

	@Column(name = "status")
	private String status;
	@Column(name = "created_at")
	private String created_at;
	@Column(name = "updated_at")
	private String updated_at;
	//private boolean accountNonExpired, accountNonLocked, credentialsNonExpired, enabled;
	/*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
	
	private List<Role> roles;*/

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "role_id",insertable=false,updatable=false) private Role
	 * role;
	 */
	
	public String getUsername() {
		return username;
	}
/*
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}*/

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	/*public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}*/

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/*public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

	/*
	 * public int getRole_id() { return role_id; }
	 * 
	 * 
	 * public void setRole_id(int role_id) { this.role_id = role_id; }
	 */

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User() {
		// super();
	}

	public User(Long user_id) {
		super();
		this.user_id = user_id;
	}
	
/*	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

	public User(Long user_id, String username, String password, String address, String social, long mobile,
			String email, String fname, String lname, String occupation, String about, String websiteUrl, String avatar,
			 String status, String created_at, String updated_at) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.social = social;
		this.mobile = mobile;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.occupation = occupation;
		this.about = about;
		this.websiteUrl = websiteUrl;
		this.avatar = avatar;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}

	
	
}
	

	/*@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void grantAuthority(String authority) {
		// if ( role == null )
		// role = new ArrayList<>();
		// roles.add(authority);
	}

	@Override
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		// role.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
		return authorities;
	}*/

