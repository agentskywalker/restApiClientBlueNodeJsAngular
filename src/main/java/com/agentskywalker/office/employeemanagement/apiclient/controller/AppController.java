package com.agentskywalker.office.employeemanagement.apiclient.controller;

import com.agentskywalker.office.employeemanagement.apiclient.common.entity.Employee;
import com.agentskywalker.office.employeemanagement.apiclient.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
//@RequestMapping("/app")
public class AppController {

    public static Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    AppService appService;

    @RequestMapping("/viewSingleEmployeeJSTLrequestPOST")
    public String viewSingleEmployeeJSTLrequestPOST(@RequestParam("employeeoperation") String employeeoperation,
                                                    @RequestParam(value = "sid", required = false) String sid,
            /*@RequestParam("sid") String   sid,*/
                                                    Model model) {
        String returnPage = "error";

        logger.info("Controller : Endpoint :: EmployeeController : /retrieveDB");
        logger.info("Controller : Method :: EmployeeController : retrieveDB()");

        //Retrieve Single employee and then display. Give option to update info.
        if (employeeoperation.equals("selectsingleemp")) {
            logger.info("Controller : Method : Condition : SID :: EmployeeController : retrieveDB() : selectsingleemp : " + sid);
            model.addAttribute("employee", appService.appServiceGetEmployeeBySid(sid));
            returnPage = "viewSingleEmployeeJSTLresponse";
        }

        //Retrieve All employees and then display. Give option to update info.
        if (employeeoperation.equals("selectallemp")) {
            logger.info("Controller : Method : Condition :: EmployeeController : retrieveDB() : selectallemp");
            Employee[] employeeList = appService.appServiceGetAllEmployees();
            model.addAttribute("employeeList", employeeList);
            System.out.println("employeeList size : " + employeeList.length);

            for (int k = 0; k < employeeList.length; k++) {

                System.out.println("employeeList " + k + " : " + employeeList[k]);

                model.addAttribute("employee" + k, employeeList[k]);
            }

            returnPage = "viewAllEmployeeJSTLresponse";
        }

        return returnPage;

    }

    @RequestMapping("/viewAllEmployeesJSTL")
    public String viewAllEmployeesJSTL(Model model) {
        logger.info("Controller : Endpoint :: AppController : /viewAllEmployeesJSTL");
        logger.info("Controller : Method :: AppController : viewAllEmployeesJSTL()");


        //List employeeList = appService.getAppEmployees();
        Employee[] employeeList = appService.appServiceGetAllEmployees();
        model.addAttribute("employeeList", employeeList);
        System.out.println("employeeList size : " + employeeList.length);

        for (int k = 0; k < employeeList.length; k++) {

            System.out.println("employeeList " + k + " : " + employeeList[k]);

            model.addAttribute("employee" + k, employeeList[k]);
        }

        return "viewAllEmployeeJSTLresponse";
    }


    @RequestMapping("/addNewEmployeeJSTLrequestPOST")
    public String addNewEmployeeJSTLrequestPOST(@RequestParam("sid") String sid,
                                                @RequestParam("first_name") String first_name,
                                                @RequestParam("last_name") String last_name,
                                                @RequestParam("role") String role,
                                                @RequestParam(value = "email", required = false) String email,
                                                @RequestParam(value = "mgr_id", required = false) String mgr_id,
                                                @RequestParam(value = "dob", required = false) Date dob,
                                                @RequestParam(value = "ssn", required = false) Integer ssn,
                                                Model model) {
        logger.info("Controller : Endpoint :: AppController : /addNewEmployeeJSTLrequestPOST");
        logger.info("Controller : Method :: AppController : addNewEmployeeJSTLrequestPOST()");


        logger.info("DOB : " + dob);
        logger.info("ssn : " + ssn);

        Employee    e1    = new Employee(sid, first_name, last_name, role, email, mgr_id, dob, ssn);

        Employee    employee = this.appService.appServiceSaveEmployee(e1);

        model.addAttribute("employee", employee);

        return "viewSingleEmployeeJSTLresponse";
    }


}
