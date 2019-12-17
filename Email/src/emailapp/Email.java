package emailapp;

import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private String alternateEmail;
	private int defaultPasswordLength=10;
	private int mailBoxCapacity=500;
	private String companySuffix="_University.com";
	
	//constructor to receive Name
	public Email(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
		System.out.println("Email Generated: "+this.firstName+" "+this.lastName);
		
		//Call a method asking for the department
		this.department=setDepartment();
		
		//Call a method to generate random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+ department + companySuffix ;
		
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.println("Department Codes: \n1 for ComputerScience \n2 for Math \n3 for Chemistry \n4 for Physics"
				+ "\n0 for none \n Enter department code: " );
		Scanner in=new Scanner(System.in);
		int depChoice=in.nextInt();
		if(depChoice==1) { return "ComputerScience";}
		else if(depChoice==2) {return "Math";}
		else if(depChoice==3) {return "Chemistry";}
		else if(depChoice==4) {return "Physics";}
		else {return "";}
	}
	
	//Generate Password
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password=new char[length];
		
		for(int num=0;num<length;num++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[num]=passwordSet.charAt(rand);
		}
		 return new String(password);
		
	}
	
	//Set the mailbox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity=capacity;
	}
	
	//Set the alternate email address
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePassword(String password) {
		System.out.println("Password Changed ");
		this.password=password;
		
	}
	
	public int getMailboxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return "Your password is: "+password;
		
	}
	
	public String showInfo() {
		return "Display Name: "+firstName+""+lastName+
				"\nComapany Email"+email+
				"\nMailBox Capacity: "+mailBoxCapacity+"mb";
	}
	
	

}
