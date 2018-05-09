package ProjectIsa.bioskop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjectIsa.bioskop.domain.Adresa;
import ProjectIsa.bioskop.domain.TheaterOrCinema;
import ProjectIsa.bioskop.repository.CinemaDBRepository;
@Service
public class TheaterOrCinemaService implements TheaterOrCinemaServiceInterface{

	@Autowired
	CinemaDBRepository repository;
	
	@Override
	public List<TheaterOrCinema> getTheaterOrCinemas() {
		List<TheaterOrCinema> cinemas = repository.findAll();
		if(cinemas.size() == 0) {
			return null;
		}
		return cinemas;
	}

	@Override
	public TheaterOrCinema addTheaterOrCinema(TheaterOrCinema tc) {
		
		System.out.println("usao u ADD");
		System.out.println(tc.getAdress().getCity());
		if (tc.getAdress() != null) {
			System.out.println("Address is NOT NULL");
			addAddress(tc.getAdress());
		}
		
		TheaterOrCinema t = repository.findByName(tc.getName());
		if (t != null) {
			return null;
		}
		
		System.out.println("Prosao do return");
		return repository.save(tc);
	}

	@Override
	public void deleteTheaterOrCinema(TheaterOrCinema tc) {
		repository.delete(tc);
	}

	@Override
	public TheaterOrCinema getTheaterOrCinema(Long id) {
		return repository.findById(id);
	}

	@Override
	public TheaterOrCinema changeInstitution(String institutionName, TheaterOrCinema newInstitution) {
		
		for(TheaterOrCinema cinema : getTheaterOrCinemas()) {
			if(cinema.getName().equals(institutionName)) {
				
			}
		}
		
		return null;
	}
	
	
	@Override
	public Adresa addAddress(Adresa address) {
		// TODO Auto-generated method stub
		System.out.println("usao u ADD ADDRESS");
		Adresa newAddress = repository.save(address);
		return newAddress;
	}

	

}
