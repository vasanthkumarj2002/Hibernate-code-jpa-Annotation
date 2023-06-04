package org.jsp.userApp.Controller;

import java.util.Scanner;
import org.jsp.userApp.Dao.UserDao;
import org.jsp.userApp.Dto.User;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	static UserDao dao = new UserDao();

	public static void main(String[] args) {
		System.out.println("1.Register: ");
		System.out.println("2.Edit User Details: ");
		System.out.println("3.Fetch User By Id: ");
		System.out.println("4.Delete User By Id: ");
		System.out.println("5.Verify User By Phone and Password: ");
		System.out.println("6.Verify User By Email and Password: ");
		System.out.println("7.Verify User By id and Password: ");

		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;

		}
		case 3: {
			fetch();
			break;
		}
		case 4: {
			delete();
			break;
		}
		case 5: {
			vali();
			break;
		}
		case 6: {
			vali2();
			break;
		}
		case 7: {
			vali3();
			break;
		}
		}
	}

	public static void save() {
		System.out.println("Enter your Name,email,gender,phone,password to Register User");
		String name = sc.next();
		String email = sc.next();
		String gender = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPhone(phone);
		u.setPassword(password);
		u = dao.saveUser(u);
		System.out.println("You areRegister with Id: " + u.getId());
	}

	public static void update() {
		System.out.println("Enter your User Id To  Edit the Data:");
		int id = sc.nextInt();
		System.out.println("Enter your Name,email,gender,phone,password to Register User");
		String name = sc.next();
		String email = sc.next();
		String gender = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPhone(phone);
		u.setPassword(password);
		u = dao.updateUser(u);
		System.out.println("You are Updated with Id: " + u.getId());

	}

	public static void fetch() {
		System.out.println("Enter your User Id To  Edit the Data:");
		int id = sc.nextInt();
		User u = new User();
		u = dao.fetchUserById(id);
		System.out.println("ID: " + u.getId());
		System.out.println("NAME: " + u.getName());
		System.out.println("EMAIL: " + u.getEmail());
		System.out.println("GENDER: " + u.getGender());
		System.out.println("PHONE: " + u.getPhone());
		System.out.println("PASSWORD: " + u.getPassword());
	}

	public static void delete() {
		System.out.println("Enter your User Id To  Delete the Data:");
		int id = sc.nextInt();
		dao.deleteUser(id);
		System.out.println("User Data is Deleted");
	}

	public static void vali() {
		System.out.println("Enter phone and password from user");
		long phone = sc.nextLong();
		String password = sc.next();
		User u = dao.verifyUser(phone, password);
		System.out.println(u);
	}

	public static void vali2() {
		System.out.println("Enter email and password from user");
		String email = sc.next();
		String password = sc.next();
		User u = dao.verifyUser2(email, password);
		System.out.println(u);
	}

	public static void vali3() {
		System.out.println("Enter id and password from user");
		int id = sc.nextInt();
		String password = sc.next();
		User u = dao.verifyUser3(id, password);
		System.out.println(u);

	}

}
