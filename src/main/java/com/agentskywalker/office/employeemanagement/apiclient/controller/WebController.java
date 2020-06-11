package com.agentskywalker.office.employeemanagement.apiclient.controller;

import com.agentskywalker.office.employeemanagement.apiclient.common.entity.Employee;
import com.agentskywalker.office.employeemanagement.apiclient.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class WebController {

    @Autowired
    AppService  appService;

    public static Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Welcome to Spring Java");
        logger.info("Controller : Endpoint :: WebController : /");
        return "index";
    }

    @RequestMapping("/index")
    public String index(Map<String, Object> model) {
        model.put("message", "Welcome to Spring Java");
        logger.info("Controller : Endpoint :: WebController : /index");
        return "index";
    }

    @RequestMapping(value = "/viewSingleEmployeeJSTL/{sid}", method = RequestMethod.GET)
    public String viewSingleEmployeeJSTL(Map<String, Object> model,
                                         @PathVariable String    sid) {
        logger.info("Controller : Endpoint :: WebController : /viewSingleEmployeeJSTL");

        Employee    employee=appService.appServiceGetEmployeeBySid(sid);
        model.put("employee", employee);

        return "viewSingleEmployeeJSTL";
    }

    @RequestMapping("/viewAllEmployeesJSTLsdsdsd")
    public String viewAllEmployeesJSTL(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /viewAllEmployeesJSTL");
        return "viewAllEmployeesJSTL";
    }

    @RequestMapping("/addNewEmployeeJSTL")
    public String addNewEmployeeJSTL(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /addNewEmployeeJSTL");
        return "addNewEmployeeJSTL";
    }

    @RequestMapping("/updateEmployeeJSTL")
    public String updateEmployeeJSTL(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /updateEmployeeJSTL");
        return "updateEmployeeJSTL";
    }

    @RequestMapping("/about")
    public String about(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /about");
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /contact");
        return "contact";
    }

    @RequestMapping("/portfolio")
    public String portfolio(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /portfolio");
        return "portfolio";
    }

    @RequestMapping("/services")
    public String services(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /services");
        return "services";
    }

    @RequestMapping(value = "/viewSingleEmployeeJSTLrequest")
    public String viewSingleEmployeeJSTLrequest(Map<String, Object> model) {
        logger.info("Controller : Endpoint :: WebController : /viewSingleEmployeeJSTLrequest");
        return "viewSingleEmployeeJSTLrequest";
    }


}
