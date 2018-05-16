package ProjectIsa.bioskop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProjectIsa.bioskop.domain.ChangedInstitution;
import ProjectIsa.bioskop.domain.Projection;
import ProjectIsa.bioskop.domain.TheaterOrCinema;
import ProjectIsa.bioskop.service.TheaterOrCinemaService;

@RestController
public class TheaterOrCinemaController {

	@Autowired
	private TheaterOrCinemaService service;

	@RequestMapping(
			value = "/api/TheaterOrCinemas",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TheaterOrCinema>> getTheaterOrCinemas() {
		
		List<TheaterOrCinema> cinemas = service.getTheaterOrCinemas();

		if (cinemas != null){
			return new ResponseEntity<List<TheaterOrCinema>>(cinemas, HttpStatus.OK); 
		}else{
			return new ResponseEntity<List<TheaterOrCinema>>(cinemas, HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(
			value= "/api/TheaterOrCinema/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<TheaterOrCinema> getTheaterOrCinema(@PathVariable("id") Long id){
		
		TheaterOrCinema cinema = service.getTheaterOrCinema(id);
		if (cinema != null){
			return new ResponseEntity<TheaterOrCinema>(cinema, HttpStatus.OK); 
		}else{
			return new ResponseEntity<TheaterOrCinema>(cinema, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(
			value = "/api/createTheaterOrCinema",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<TheaterOrCinema> createTheaterOrCinema(@RequestBody TheaterOrCinema item){
		TheaterOrCinema newTheaterOrCinema = service.addTheaterOrCinema(item);
		return new ResponseEntity<TheaterOrCinema>(newTheaterOrCinema, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/changeInstitution", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<TheaterOrCinema> changeInstitution(@RequestBody ChangedInstitution changeInstitution){
		
		TheaterOrCinema institution = service.findByName(changeInstitution.getSelectInstitution());
		TheaterOrCinema newInstitution = new TheaterOrCinema();
		newInstitution.setName(changeInstitution.getName());
		newInstitution.setAdress(changeInstitution.getAdress());
		newInstitution.setDescription(changeInstitution.getDescription());
		TheaterOrCinema newCinema = service.changeInstitution(institution, newInstitution);
		return new ResponseEntity<TheaterOrCinema>(newCinema, HttpStatus.OK);
	}
	
	@RequestMapping(
			value= "/api/changeRepertoar",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<Projection> changeRepertoar(@RequestBody TheaterOrCinema cinema){
		
		Projection projection = service.changeRepertoar(cinema);
		if (projection != null){
			return new ResponseEntity<Projection>(projection, HttpStatus.OK); 
		}else{
			return new ResponseEntity<Projection>(projection, HttpStatus.BAD_REQUEST);
		}
	}
}
