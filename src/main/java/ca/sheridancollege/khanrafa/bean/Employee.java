package ca.sheridancollege.khanrafa.bean;

public class Employee {
	//Employee entity creation template
	private String empNum;
	private String empName;
	private String empAddress;
	private String empPhone;
	
	public Employee (){ }
	//Getters and setters 
	public void setEmpNum(String empNum) {this.empNum = empNum;}
	
	public void setEmpName(String empName) {this.empName = empName;}
	
	public void setEmpAddress(String empAddress) {this.empAddress = empAddress;}
	
	public void setEmpPhone(String empPhone) {this.empPhone = empPhone; }
	
	public String getEmpNum() {return this.empNum;}
	
	public String getEmpName() {return this.empName;}	
	
	public String getEmpAddress() {return this.empAddress;}
	
	public String getEmpPhone() {return this.empPhone;}

}
