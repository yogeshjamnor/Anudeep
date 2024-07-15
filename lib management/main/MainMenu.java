package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.StudentDBConnection;
import menu.AdminMenu;
import menu.InstructorMenu;
import menu.StudentMenu;

public class MainMenu {
	private String roleName;
	private Scanner sc = new Scanner(System.in);

	public void login() {
		try (Connection con = StudentDBConnection.createC()) {
			Statement st = con.createStatement();

			System.out.println("Login to Librery Management System by providing your credentials:");

			System.out.println("Enter username: ");
			String username = sc.nextLine();

			System.out.println("Enter password: ");
			String password = sc.nextLine();

			String fetchQuery = "SELECT userType FROM Login WHERE username = '" + username + "' AND password = '"
					+ password + "'";

			ResultSet rs = st.executeQuery(fetchQuery);

			if (rs.next()) {
				roleName = rs.getString("userType");
				System.out.println("Login successful as " + roleName);
				System.out.println("Thankyou for Login.");
			} else {
				System.out.println("Wrong credentials. Please check the username and password.");
				login();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
	// Main menu
	public void mainMenu() {
        try {
            if (roleName.equals("admin")) {
                AdminMenu.adminMenu(sc);
            } else if (roleName.equals("teacher")) {
                InstructorMenu.instructorMenu(sc);
            } 
            else if (roleName.equals("student")) {
            	StudentMenu.studentMenu(sc);
            }
        } catch (NullPointerException e) {
            System.out.println("Not Found!!");
        }
        sc.next();
    }

}
