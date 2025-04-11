package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("personService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public List<Object[]> fetchDataUsingJoinsByParent() {
		return personRepo.fetchDataUsingJoinsByParent();
	}

	/*@Override
	public void saveDataUsingParent() {
		// Create a Parent Object
		Person per = new Person("Sakshi", " Punjab");
	
		// Create a child Object
		PhoneNumber ph1 = new PhoneNumber(9900440001l, "Airtel", "Personal");
		PhoneNumber ph2 = new PhoneNumber(7012342352l, "Jio", "Home");
	
		// add parentr to child
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
	}*/

}
