package com.lakazambia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

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
	
	@Column(name = "status")
	private String status;

	@Column(name = "created_at")
	private String created_at;

	@Column(name = "updated_at")
	private String updated_at;

	@Column(name = "reset_token")
	private String resetToken;
	
	public Customer() {
		super();
	}


	public Customer(Long user_id) {
		super();
		this.user_id = user_id;
	}


	


	public Customer(Long user_id, String username, String password, String address, long mobile, String email,
			String fname, String lname, String occupation, String about, String websiteUrl, String avatar,
			String status, String created_at, String updated_at, String resetToken) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.address = address;
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
		this.resetToken = resetToken;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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

	
	public String getResetToken() {
		return resetToken;
	}


	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + (int) (mobile ^ (mobile >>> 32));
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((resetToken == null) ? 0 : resetToken.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (mobile != other.mobile)
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (resetToken == null) {
			if (other.resetToken != null)
				return false;
		} else if (!resetToken.equals(other.resetToken))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (websiteUrl == null) {
			if (other.websiteUrl != null)
				return false;
		} else if (!websiteUrl.equals(other.websiteUrl))
			return false;
		return true;
	}


	
	

	

}
