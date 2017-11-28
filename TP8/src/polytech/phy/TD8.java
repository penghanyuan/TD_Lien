package polytech.phy;

import polytech.phy.controller.MainController;
import polytech.phy.model.Address;
import polytech.phy.model.Person;

public class TD8 {

	public static void main(String[] args) {
		// MainController.createTables();
		Address address = new Address();
		address.setCity("Paris");
		address.setCountry("France");
		address.setPostalCode("75100");
		address.setState("Centre");
		address.setStreet("1 avenue");
		Address address1 = MainController.insertAddress("rue gaspard coriolis", "Tours", "Centre", "37200", "France");
		MainController.insertAddress(address);
		MainController.insertStudent("PENG Hanyuan", "1212", "email1", "21606314", 90, address);
		MainController.insertProfessor("WANG Tianxue", "23232", "email2", 1213, address1);
		for (Person p :MainController.findPersonByCountry("France")){
			System.out.println(p.getName());
		}
		//MainController.findProfessorByName("WANG Tianxue");
	}

}
