package com.nt.service;

public interface IOToMAssociationMgmtService {

	public void saveDataUsingParent();
	
	public void saveDataUsingChild();
	
	public void LoadDataUsingParent();
	
	public void LoadDataUsingChild();
	
	// Delete Operation in associate mapping
	public String deleteByPerson(int personId);
	
	// Deleting only childs of parent in one to many
	public String deleteAllPhoneNumbersOfAPerson(int personId);
	
	// Adding new Child to existing childs of a Parent
	public void addNewChildToAParentById(int id);
	
	// deleting child and its parents
	public void deleteDataUsingChilds();
}
