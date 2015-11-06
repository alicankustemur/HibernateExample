package com.alicankustemur.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "APP_USER")
//@Table(name = "APP_USER")
public class User implements Serializable
{
	@Id
	@Column(name = "ID")
	private int		id;

	@Column(name = "NAME")
	private String	name;

	@Column(name = "SURNAME")
	private String	surname;

	@Column(name = "JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date	joinDate;

	public User()
	{

	}

	public User(int id, String name, String surname, Date joinDate)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.joinDate = joinDate;

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public Date getJoinDate()
	{
		return joinDate;
	}

	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}

}
