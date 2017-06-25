package com.foodvotebox.pojo;

import java.util.Date;

public class FvbUser {
	private Long userid;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Date created;

    private Date updated;

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

	@Override
	public String toString() {
		return "FvbUser [id=" + userid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", created=" + created + ", updated=" + updated + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FvbUser user = (FvbUser) o;

		if (!userid.equals(user.userid)) return false;
		if (!username.equals(user.username)) return false;
		if (!password.equals(user.password)) return false;
		if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
		return email != null ? email.equals(user.email) : user.email == null;
	}

	@Override
	public int hashCode() {
		int result = userid.hashCode();
		result = 31 * result + username.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}
}
