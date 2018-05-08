package ProjectIsa.Bioskop;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;



import ProjectIsa.bioskop.domain.Adresa;
import ProjectIsa.bioskop.domain.ItemOffer;
import ProjectIsa.bioskop.domain.User;
import ProjectIsa.bioskop.domain.UserType;
import ProjectIsa.bioskop.service.UserService;

import ProjectIsa.bioskop.domain.ThematicItem;
import ProjectIsa.bioskop.service.ThematicItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

	
	@Autowired
	ThematicItemService service;
	@Autowired
	UserService userService;
	@Test
	public void testPrice(){
		List<ThematicItem> items = (List<ThematicItem>)service.getItems();
		//creating new item with higher price than zero
		Long id = 5l;
		ThematicItem item = new ThematicItem(id , "Star wars", 1000, "Opis", "");
		service.addNewItem(item);
		List<ThematicItem> itemsAfter = (List<ThematicItem>)service.getItems();
		assertThat(items).hasSize(itemsAfter.size() - 1);
	}
	@Test
	public void testPrice2(){
		List<ThematicItem> items = (List<ThematicItem>)service.getItems();
		//creating new item with lower price than zero
		Long id = 5l;
		ThematicItem item = new ThematicItem(id , "Star wars", -5, "Opis", "");
		service.addNewItem(item);
		List<ThematicItem> itemsAfter = (List<ThematicItem>)service.getItems();
		assertThat(items).hasSize(itemsAfter.size());
	}
	@Test
	public void testItemOffer(){
		ThematicItem item = service.getItem(1L); // default item in db
		User user = userService.getUser("admin"); //default user in db
		double price = 400;
		ItemOffer offer = new ItemOffer(user, price, item);
		
		List<ItemOffer> itemsBefore = service.getOffers();
		
		service.addItemOffer(offer);
		
		List<ItemOffer> itemsAfter = service.getOffers();
		
		assertThat(itemsBefore).hasSize(itemsAfter.size() - 1);
	}
	@Test
	public void testItemOffer1(){
		ThematicItem item = service.getItem(1L); // default item in db
		User user = new User("ime", "prezime", "aaaaaaaaaaaaaaaaa", "asd", UserType.REGISTEREDUSER, new Adresa(), "asd@gmail.com"); // user koji ne postoji
		double price = 400;
		ItemOffer offer = new ItemOffer(user, price, item);
		
		List<ItemOffer> itemsBefore = service.getOffers();
		
		service.addItemOffer(offer);
		
		List<ItemOffer> itemsAfter = service.getOffers();
		
		assertThat(itemsBefore).hasSize(itemsAfter.size());
	}
}
