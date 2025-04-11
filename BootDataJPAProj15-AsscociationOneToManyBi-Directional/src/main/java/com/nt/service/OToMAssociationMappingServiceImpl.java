package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("OtoMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public void saveDataUsingParent() {

		// Create a Parent Object
		Person per = new Person("Ravi", " Kanpur");

		// Create a child Object
		PhoneNumber ph1 = new PhoneNumber(9900877854l, "Vi", "Personal");
		PhoneNumber ph2 = new PhoneNumber(7070701155l, "Jio", "Office");

		// add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);

		// add child to parent
		Set<PhoneNumber> phonesSet = new HashSet<PhoneNumber>();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);

		// save the parent Object
		personRepo.save(per);
		System.out.println("Person and his Associated Phone Numbers are saved(Parent To Child)");
	}

	@Override
	public void saveDataUsingChild() {

		// create the parent object
		Person per = new Person("Virat ", "Punjab");

		// create the child object
		PhoneNumber ph1 = new PhoneNumber(9808866754l, "Jio", "Personal");
		PhoneNumber ph2 = new PhoneNumber(8965733440l, "Airtel", "Office");

		// add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);

		// add child to parent
		Set<PhoneNumber> phonesSet = new HashSet<PhoneNumber>();

		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);

		// save the parent object
		phoneRepo.save(ph1);
		phoneRepo.save(ph2);
		System.out.println("Person and his Associate Phone Numbers Are saved(Child To Parent)");

	}

	@Override
	public void LoadDataUsingParent() {
		Iterable<Person> it = personRepo.findAll();
		it.forEach(per -> {
			System.out.println("Parent::" + per);

			/*	// get Childs of each parent
				Set<PhoneNumber> childs = per.getContactDetails();
				System.out.println("Childs Count :: " + childs.size());
				
				childs.forEach(ph->{
					System.out.println("child::" + ph.getMobileNo());
				});*/
		});

	}

	@Override
	public void LoadDataUsingChild() {

		// get all child objects and associated parent objs
		List<PhoneNumber> childs = phoneRepo.findAll();
		childs.forEach(ph -> {
			System.out.println("Child::" + ph);

			// get the associated parent object
			/*Person per = ph.getPersonInfo();
			System.out.println("Parent-->");*/
		});

	}

	@Override
	public String deleteByPerson(int personId) {
		// Load the parent Object
		Optional<Person> opt = personRepo.findById(personId);
		if (opt.isPresent()) {
			personRepo.delete(opt.get());
			return "Person and his Phone Number is Deleted";
		}
		return "Person is Not Found";
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		// Load the parent Object
		Optional<Person> opt = personRepo.findById(personId);
		if (opt.isPresent()) {
			// get all child of a parents
			Set<PhoneNumber> childs = opt.get().getContactDetails();
			// delete the childs
			childs.forEach(ph -> {
				ph.setPersonInfo(null);

			});
			phoneRepo.deleteAll(childs);
			return childs.size() + "Phone Numbers Of " + personId + "Persons are deleted";

		}
		return personId + "Person Not Found";
	}

	@Override
	public void addNewChildToAParentById(int id) {
		// Load the parent Object
		Optional<Person> opt = personRepo.findById(id);
		if (opt.isPresent()) {
			Person per = opt.get();

			// get All Child of a parents
			Set<PhoneNumber> childs = per.getContactDetails();

			// create the new child object
			PhoneNumber ph = new PhoneNumber(7890654321l, "Airtel", "Personal");

			// link child to parent
			ph.setPersonInfo(per);
			childs.add(ph);

			personRepo.save(per);

			System.out.println("New Child is added to the existing childs of a Parents");

		} else {
			System.out.println(id + " Person Not Found For Operation ");
		}
	}

	@Override
	public void deleteDataUsingChilds() {
		// Load the parent Object
		Optional<Person> opt = personRepo.findById(2);
		if (opt.isPresent()) {
			// get parent object
			Person per = opt.get();
			// get all child of a parent
			Set<PhoneNumber> childs = per.getContactDetails();

			// delete all childs
			childs.forEach(ph -> {
				phoneRepo.delete(ph);
			});
			System.out.println("All Child and its Associated is Deleted ");
		} else {
			System.out.println("Parent Not Found");
		}
	}
}
