package com.jsp.vehicle.info.service;

import com.jsp.vehicle.info.dao.VehicleDao;
import com.jsp.vehicle.info.dto.Chasis;
import com.jsp.vehicle.info.dto.EngineNumber;
import com.jsp.vehicle.info.dto.Vehicle;

public class VehicleService {
	
	VehicleDao vehicleDao=new VehicleDao();
	
	
	public Vehicle saveVehicle(Vehicle vehicle, EngineNumber engineNumber, Chasis chasis) {
		return vehicleDao.saveVehicle(vehicle, engineNumber, chasis);
		
	}
	
	public Vehicle deleteVehicle(Vehicle vehicle, EngineNumber engineNumber, Chasis chasis) {
		return vehicleDao.deleteVehicle(vehicle, engineNumber, chasis);
	}
	
	public Vehicle updateVehicle(Vehicle vehicle, EngineNumber engineNumber, Chasis chasis) {
		return vehicleDao.updateVehicle(vehicle, engineNumber, chasis);
	}
	public void getAlldetails() {
		vehicleDao.getAlldetails();
	}
	
	
}
