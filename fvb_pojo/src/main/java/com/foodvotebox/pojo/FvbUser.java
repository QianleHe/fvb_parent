package com.foodvotebox.pojo;

import java.io.Serializable;
import java.util.Date;

public class FvbUser implements Serializable{
	private Long userid;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Date created;

    private Date updated;

    private String picid;

	public Long getUserId() {
		return userid;
	}

	public void setUserId(Long id) {
		this.userid = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getPicid() { return picid; }

	public void setPicid(String picid) { this.picid = picid;}

	@Override
	public String toString() {
		return "FvbUser [id=" + userid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", created=" + created + ", updated=" + updated + " picid=" + picid + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FvbUser user = (FvbUser) o;

		if (!userid.equals(user.userid)) return false;
		if (!username.equals(user.username)) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
		if (email != null ? !email.equals(user.email) : user.email != null) return false;
		return picid != null ? picid.equals(user.picid) : user.picid == null;
	}

	@Override
	public int hashCode() {
		int result = userid.hashCode();
		result = 31 * result + username.hashCode();
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (picid != null ? picid.hashCode() : 0);
		return result;
	}
}
