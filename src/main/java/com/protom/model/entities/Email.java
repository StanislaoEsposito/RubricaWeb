package com.protom.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emails")
public class Email {
	
	@Id
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	@ManyToOne()
	@JoinColumn(name = "id_contact", referencedColumnName="id")
	private Contact contact;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
