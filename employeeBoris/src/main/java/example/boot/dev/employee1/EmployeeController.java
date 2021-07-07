package example.boot.dev.employee1;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	//-----------------------read ----------------------------------

	@RequestMapping("/allEmployees")
	public String getAllEmployees(Model boxToView) {

		boxToView.addAttribute("employeeListfromControllerAndDB", employeeRepository.findAll());

		return "employees";
	}

	
	//-----------------------add----------------------------------
	@RequestMapping("/newEmployee")
	public String newEmpoyee() {

		return "newemployee.html";
	}

	@RequestMapping("/addEmployee")
	public String inserEmployee(Employee employee) {

		employeeRepository.save(employee);

		return "redirect:/employee/allEmployees";
	}

	

}
