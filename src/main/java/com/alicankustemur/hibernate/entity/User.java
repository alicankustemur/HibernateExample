package com.alicankustemur.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "APP_USER")
//@Table(name = "APP_USER")
public class User implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int		id;

	@Column(name = "NAME")
	private String	name;

	private String	surname;

	@Column(name = "JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date	joinDate;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME") ),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME") ),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME") ),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE_NAME") )})
	private Adress	homeAdress;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET_NAME") ),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME") ),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME") ),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE_NAME") )})
	private Adress	officeAdress;

	public Adress getHomeAdress()
	{
		return homeAdress;
	}

	public void setHomeAdress(Adress homeAdress)
	{
		this.homeAdress = homeAdress;
	}

	public Adress getOfficeAdress()
	{
		return officeAdress;
	}

	public void setOfficeAdress(Adress officeAdress)
	{
		this.officeAdress = officeAdress;
	}

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
