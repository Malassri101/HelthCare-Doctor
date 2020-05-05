package com.HelthCare.HealthCare;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.HelthCare.Model.Doctor;
import com.HelthCare.Service.DoctorRepository;

@Path("/doctors")
public class DoctorResource {
	
	DoctorRepository r1 = new DoctorRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)		
		    
	public List<Doctor> getAllDoctors() {
		
		return r1.getAllDoctors();
		    
	}
/*	
	@GET
	@Path("doctor/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getDoctor(@PathParam("id") String did)
	{
		return r1.getDoctor(did);
	}
	*/	
	
	@POST
	@Path("/doctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor createDoctor(Doctor d1) {
		
		System.out.println(d1);
		r1.createDoctor(d1);
		return d1;
	}
	
	
	@PUT
	@Path("/doctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor updateDoctor(Doctor d1) {
		
		System.out.println(d1);
		r1.updateDoctor(d1);
		return d1;
	}

	@DELETE
	@Path("/doctor/{docID}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteDoctor(@PathParam("docID") String docID)
	{
		r1.deleteDoctor(docID);
	}
}
