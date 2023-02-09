package spring_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import spring_hibernate.dto.Employee;


@Component
public class EmployeeDao {
	@Autowired
	EntityManager entityManager;

	public void saveEmployee(Employee employee) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	public void updateEmployee(int id,String name)
	{
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee employee=entityManager.find(Employee.class, id);
		employee.setId(id);
		employee.setName(name);
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		
	}
	public void deleteEmployee(int id) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			
			entityTransaction.commit();
		}
	}
	public Employee getEmployee(int id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}
	
	public List<Employee> getAllEmpployee(){ 
		
		Query query=entityManager.createQuery("Select p from Employee p");
		List<Employee>list=query.getResultList();
		return list;
	}


}
