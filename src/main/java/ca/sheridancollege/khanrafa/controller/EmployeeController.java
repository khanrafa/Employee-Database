package ca.sheridancollege.khanrafa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.khanrafa.bean.Employee;
import ca.sheridancollege.khanrafa.dao.EmployeeDatabaseAccess;


@Controller
public class EmployeeController {
	
	//mapping sets
	
	ArrayList<Employee> employees = new ArrayList<>();

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/userEmpInput")
	public String userEmpInputForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "userEmpInput";
	}

	@Autowired
	private EmployeeDatabaseAccess da;

	@RequestMapping("/userEmpInput")
	  public String addEmployee(Model model, @ModelAttribute
			  Employee employee) {
	     long numberOfRows = da.addEmployee(employee);
	    return "index";
	  }


	@GetMapping ("/empList")
	public String viewEmployeeList(Model model) {
		List<Employee> employeeList = da.selectEmployees();
        model.addAttribute("employees", employeeList);
	return "empList";
	}
	
	@RequestMapping ("/empNumDelete")
	public String deleteEmployee (Model model, @ModelAttribute 
				Employee employee) {
	model.addAttribute("employee", new Employee());
	return "empNumDelete";		
}

	
	@GetMapping ("/empNumSearchInput")
	public String empNumSearch (Model model) {
		model.addAttribute("employee", new Employee());
		return "empNumSearchInput";
	}
	
	@GetMapping ("/empPhoneSearchInput")
	public String empPhoneSearch (Model model) {
		model.addAttribute("employee", new Employee());
		return "empPhoneSearchInput";
	}
	
	@GetMapping ("/empUpdate")
	public String empUpdate (Model model) {
		model.addAttribute("employee", new Employee());
		return "empUpdate";
	}
	

}


