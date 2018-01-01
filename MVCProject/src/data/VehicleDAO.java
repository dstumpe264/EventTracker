package data;

import java.util.List;

import entities.Vehicle;

public interface VehicleDAO {
	
	public List<Vehicle> index();
	public Vehicle show(int id);
	public Vehicle create(String json);
	public Vehicle update(int id, String json);
	public boolean destroy(int id);
	
	
}
