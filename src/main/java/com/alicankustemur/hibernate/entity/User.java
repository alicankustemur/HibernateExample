package com.alicankustemur.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int					id;

	@Column(name = "NAME")
	private String				name;

	private String				surname;

	@Column(name = "JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date				joinDate;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME") ),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME") ),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME") ),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE_NAME") )})
	private Adress				homeAdress;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET_NAME") ),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME") ),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME") ),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE_NAME") )})
	private Adress				officeAdress;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADRESS", joinColumns = @JoinColumn(name = "USER_ID") )
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = {@Column(name = "ADRESS_ID")}, generator = "hilo-gen", type = @Type(type = "long") )
	private Collection<Adress>	listOfAdress	= new ArrayList<Adress>();

	/*
	@OneToOne
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle				vehicle;
	
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
	*/

	public Collection<Adress> getListOfAdress()
	{
		return listOfAdress;
	}

	public void setListOfAdress(Collection<Adress> listOfAdress)
	{
		this.listOfAdress = listOfAdress;
	}

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
