package ProjectIsa.bioskop.service;

import java.util.Collection;

import ProjectIsa.bioskop.domain.Hall;

public interface HallServiceInterface {
	Collection<Hall> getHalls();
	Hall addHall(Hall hall);
	void deleteHall(Hall hall);
	Hall getHallById(String id);
}
