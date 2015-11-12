package com.alicankustemur.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle
{
	@Id
	@GeneratedValue
	private long	vehicleId;

	private String	vehicleName;

	public long getVehicleId()
	{
		return vehicleId;
	}

	public void setVehicleId(long vehicleId)
	{
		this.vehicleId = vehicleId;
	}

	public String getVehicleName()
	{
		return vehicleName;
	}

	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
	}

}
