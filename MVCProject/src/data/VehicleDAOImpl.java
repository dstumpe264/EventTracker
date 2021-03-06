package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Vehicle;

@Repository
@Transactional
public class VehicleDAOImpl implements VehicleDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	public Vehicle create(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Vehicle vehicle = mapper.readValue(json, Vehicle.class);
			System.out.println(vehicle);
			em.persist(vehicle);
			em.flush();
			return vehicle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Vehicle update(int id, String json) {
		ObjectMapper mapper = new ObjectMapper();
		Vehicle currentVeh = em.find(Vehicle.class, id);
		try {
			Vehicle tempVeh = mapper.readValue(json, Vehicle.class);
			if(tempVeh.getMake() != null) {
				currentVeh.setMake(tempVeh.getMake());	
			}
			if(tempVeh.getModel() != null) {
				currentVeh.setModel(tempVeh.getModel());
			}
			if(tempVeh.getYear() != 0) {
				currentVeh.setYear(tempVeh.getYear());
			}
			if (tempVeh.getCurrentMiles() != 0) {
				currentVeh.setCurrentMiles(tempVeh.getCurrentMiles());
			}
			if (tempVeh.getMilesDue() != 0) {
				currentVeh.setMilesDue(tempVeh.getMilesDue());
			}
			em.persist(currentVeh);
			em.flush();
			return currentVeh;
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}

	@Override
	public List<Vehicle> index() {
		String query = "Select v FROM Vehicle v";
		return em.createQuery(query, Vehicle.class).getResultList();
	}

	@Override
	public Vehicle show(int id) {
		return em.find(Vehicle.class, id);
	}

	@Override
	public boolean destroy(int id) {
		try {
			em.remove(em.find(Vehicle.class, id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
