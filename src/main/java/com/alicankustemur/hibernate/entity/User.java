package com.alicankustemur.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "APP_USER")
@Table(name = "APP_USER")
public class User implements Serializable
{
	@Id
	@Column(name = "ID")
	private long	id;

	@Column(name = "LOGIN")
	private String	login;

	public User()
	{

	};

	public User(long id, String login)
	{
		this.id = id;
		this.login = login;

	};

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

}
