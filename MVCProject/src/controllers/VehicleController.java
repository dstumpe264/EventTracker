package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import data.VehicleDAO;
import entities.Vehicle;

@RestController
public class VehicleController {
	@Autowired
	VehicleDAO dao;
	
	@RequestMapping(path="vehicles", method=RequestMethod.GET)
	public List<Vehicle> index(){
		return dao.index();
	}
	
	@RequestMapping(path="vehicles/{id}", method=RequestMethod.GET)
	public Vehicle show(@PathVariable int id){
		return dao.show(id);
	}
	
	@RequestMapping(path="vehicles", method=RequestMethod.POST)
	public Vehicle createVehicle(@RequestBody String json, HttpServletResponse res) {
		Vehicle veh = dao.create(json);
		if (veh == null) {
			res.setStatus(400);
		}else {
			res.setStatus(201);
		}
		return veh;
	}
	
	@RequestMapping(path="vehicles/{id}", method=RequestMethod.PUT)
	public Vehicle updateVehicle(@RequestBody String json, @PathVariable int id, HttpServletResponse res) {
		Vehicle veh = dao.update(id, json);
		if (veh == null) {
			res.setStatus(400);
		}else {
			res.setStatus(201);
		}
		return veh;
	}
	
	
	@RequestMapping(path="vehicles/{id}", method=RequestMethod.DELETE)
	public boolean deleteVehicle(@PathVariable int id, HttpServletResponse res) {
		try {
			if (dao.destroy(id)) {
				res.setStatus(201);
				return true;
			}else {
				res.setStatus(405);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@RequestMapping(path="index.do", method = RequestMethod.GET)
	public ModelAndView actors(@RequestParam("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		Vehicle vehicle = dao.show(id);
		System.out.println(vehicle);
		mv.addObject("vehicle", vehicle);
		mv.setViewName("VehicleTracker.jsp");
		return mv;
	}
	
	

}
