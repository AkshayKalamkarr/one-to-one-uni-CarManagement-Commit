package com.jsp.vehicle.info.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.vehicle.info.dto.Chasis;
import com.jsp.vehicle.info.dto.EngineNumber;
import com.jsp.vehicle.info.dto.Vehicle;

public class VehicleDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Akshay");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Vehicle saveVehicle(Vehicle vehicle, EngineNumber engineNumber, Chasis chasis) {
		entityTransaction.begin();
		entityManager.persist(chasis);
		entityManager.persist(engineNumber);
		entityManager.persist(vehicle);
		entityTransaction.commit();

		System.out.println("recoRd ADD");
		return vehicle;

	}

	public Vehicle deleteVehicle(Vehicle vehicle, EngineNumber engineNumber, Chasis chasis) {
		Vehicle vehicle2 = entityManager.find(Vehicle.class, vehicle.getId());
		EngineNumber engineNumber2 = entityManager.find(EngineNumber.class, engineNumber.getId());
		Chasis chasis2 = entityManager.find(Chasis.class, chasis.getId());
		entityTransaction.begin();
		entityManager.remove(chasis2);
		entityManager.remove(engineNumber2);
		entityManager.remove(vehicle2);
		entityTransaction.commit();
		return vehicle2;

	}

	public Vehicle updateVehicle(Vehicle vehicle, EngineNumber engineNumber, Chasis chasis) {
		Vehicle vehicle2 = entityManager.find(Vehicle.class, vehicle.getId());
		entityTransaction.begin();
		entityManager.merge(vehicle);
		entityManager.merge(engineNumber);
		entityManager.merge(chasis);
		System.out.println("update done");
		return vehicle2;
	}

	public void getAlldetails() {
		String sql1 = "select vehicle from Vehicle vehicle";
		String sql2 = "select enginenumber from  EngineNumber  enginenumber";
		String sql3 = "select chasis from  Chasis chasis";
		Query query1 = entityManager.createQuery(sql1);
		Query query2 = entityManager.createQuery(sql2);
		Query query3 = entityManager.createQuery(sql3);

		List<Vehicle> vehicles = query1.getResultList();
		List<EngineNumber> engineNumbers = query2.getResultList();
		List<Chasis> chasis = query3.getResultList();

		for (Vehicle v : vehicles) {
			System.out.println("=======");
			System.out.println(v.getId());
			System.out.println(v.getName());
			System.out.println(v.getBrand());
		}

		for (EngineNumber e : engineNumbers) {
			System.out.println("=========");
			System.out.println(e.getId());
			System.out.println(e.getNumber());

		}
		for (Chasis c : chasis) {
			System.out.println("=========");
			System.out.println(c.getId());
			System.out.println(c.getNumber());
		}
	}

}
