package spring_hibernate.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_hibernate.dao.EmployeeDao;
import spring_hibernate.dto.BankAccount;
import spring_hibernate.dto.Config;
import spring_hibernate.dto.Employee;

public class MainController {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		BankAccount bankAccount = context.getBean("bankAccount", BankAccount.class);
		Employee employee = context.getBean("employee", Employee.class);
		EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);

		boolean flag = true;
		do {
			System.out.println("1.Save Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.delete Employee");
			System.out.println("4.get Employee by Id");
			System.out.println("5.Get all employee");
			System.out.println("6.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter the name");
				String name = scanner.next();
				System.out.println("enter the address");
				String address = scanner.next();
				System.out.println("enter the phone");
				long phone = scanner.nextLong();
				employee.setName(name);
				employee.setAddress(address);
				employee.setPhone(phone);

				System.out.println("enter the bank name");
				String bname = scanner.next();
				System.out.println("enter the address");
				String baddress = scanner.next();
				System.out.println("enter the phone");
				String ifsc = scanner.next();

				bankAccount.setName(bname);
				bankAccount.setAddress(baddress);
				bankAccount.setIfsc(ifsc);

				employee.setBankAccount(bankAccount);

				dao.saveEmployee(employee);
				System.out.println("saved");

			}
				break;
			case 2: {
				System.out.println("enter the id ");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name = scanner.next();
				
				employee.setName(name);
				dao.updateEmployee(id, name);
				System.out.println("sucessfully updated");
			}
				break;
			case 3: {
				System.out.println("enter the id ");
				int id = scanner.nextInt();
				employee.setId(id);
				dao.deleteEmployee(id);
				System.out.println("sucessfully deleted");
			}
			break;
			case 4 :{
				System.out.println("enter the id ");
				int id = scanner.nextInt();
				System.out.println(dao.getEmployee(id));
				
			}
			break;
			case 5 :{
				System.out.println(dao.getAllEmpployee());
			}
			break;
			case 6 :{
				flag=false;
			}
			break;
			default:{
				System.out.println("Invalid password");
			}
				break;
			}

		} while (flag);
//		employee.setName("manu");
//		employee.setAddress("kolhapur");
//		employee.setPhone(24135656);

//		bankAccount.setName("BOI");
//		bankAccount.setAddress("kolhapur");
//		bankAccount.setIfsc("BKIDOOOO929");
//		employee.setBankAccount(bankAccount);
//		
//		EmployeeDao dao=context.getBean("employeeDao",EmployeeDao.class);
//		dao.saveEmployee(employee);

	}
}
