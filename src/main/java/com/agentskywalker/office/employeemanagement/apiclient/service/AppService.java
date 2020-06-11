package com.agentskywalker.office.employeemanagement.apiclient.service;

import com.agentskywalker.office.employeemanagement.apiclient.common.entity.Employee;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Service
public class AppService {
    public Employee appServiceGetEmployeeBySid(String    sid) {

        Employee    employee    =   new Employee();
        String  urlIp = "http://localhost:1211";
        String  urlApiLink = "/api/employee/";
        //String  sid =   "n683452";
        String  fullUrl = urlIp+urlApiLink+sid;

        try{
            //Pass the desired URL as an object
            URL url = new URL(fullUrl);

            //Type cast the URL object into a HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            //Set the request type
            conn.setRequestMethod(String.valueOf(GET));

            //Open a connection stream to the corresponding API
            conn.connect();

            //Get the corresponding response code.
            int responsecode = conn.getResponseCode();

            //We will store JSON values here as Strings
            String  inline  =   "";

            if(responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " +responsecode);
            else
            {
                //Use the method Scanner to read each line from the API and fetch the data in string format.
                Scanner sc = new Scanner(url.openStream());

                while(sc.hasNext())
                {
                    inline+=sc.nextLine();
                }
                System.out.println("JSON Response in String format");
                System.out.println(inline);
                sc.close();
            }

            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser parse = new JSONParser();

            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject)parse.parse(inline);


            System.out.println("sid : " +jobj.get("sid"));
            System.out.println("first_name: " +jobj.get("first_name"));
            System.out.println("last_name: " +jobj.get("last_name"));
            System.out.println("role: " +jobj.get("role"));
            System.out.println("email: " +jobj.get("email"));
            System.out.println("mgr_id: " +jobj.get("mgr_id"));
            System.out.println("dob: " +jobj.get("dob"));
            System.out.println("ssn: " +jobj.get("ssn"));

            employee.setSid(jobj.get("sid").toString());
            employee.setFirst_name(jobj.get("first_name").toString());
            employee.setLast_name(jobj.get("last_name").toString());
            employee.setRole(jobj.get("role").toString());
            employee.setEmail(jobj.get("email").toString());
            employee.setMgr_id(jobj.get("mgr_id").toString());
            //employee.setDob(Date.valueOf(jobj.get("dob").toString()));
            employee.setSsn(Integer.parseInt(jobj.get("ssn").toString()));


            //Disconnect the HttpURLConnection stream
            conn.disconnect();
        }catch (Exception exception){
            System.out.println(exception);
            exception.printStackTrace();
        }

        return employee;
    }

    //@GetMapping("/employees")
    //public String getAppEmployees(Map<String, Object> model) {
    public Employee[] appServiceGetAllEmployees() {

        String  urlIp = "http://localhost:1211";
        String  urlApiLink = "/api/employees/";
        String  fullUrl = urlIp+urlApiLink;
        //Employee[] employees = new Employee[0];
        List employeeList = null;
        Employee[] employees = new Employee[0];

        try {
            //Pass the desired URL as an object
            URL url = new URL(fullUrl);

            //Type cast the URL object into a HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //Set the request type
            conn.setRequestMethod(String.valueOf(GET));

            //Open a connection stream to the corresponding API
            conn.connect();

            //Get the corresponding response code.
            int responsecode = conn.getResponseCode();

            //We will store JSON values here as Strings
            String inline = "";

            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                //Use the method Scanner to read each line from the API and fetch the data in string format.
                Scanner sc = new Scanner(url.openStream());

                //Append all lines of response into a single String
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                System.out.println("JSON Response in String format");
                System.out.println(inline);
                sc.close();
            }


            RestTemplate restTemplate    =   new RestTemplate();

            //HttpHeaders headers =   new HttpHeaders();
            //headers.set("Accept","application/json");
            //HttpEntity entity  =   new HttpEntity(headers);

            ResponseEntity<Employee[]> responseEntity  =   restTemplate.getForEntity(fullUrl, Employee[].class);

            employees    = responseEntity.getBody();


        }catch (Exception exception){
            System.out.println(exception);
            exception.printStackTrace();
        }
        //return employeeList;
        return employees;

    }

    public Employee  appServiceSaveEmployee(Employee employee){

        String  urlIp = "http://localhost:1211";
        String  urlApiLink = "/api/save/";
        String  fullUrl = urlIp+urlApiLink;

        try {
            RestTemplate restTemplate    =   new RestTemplate();

            //HttpHeaders headers =   new HttpHeaders();
            //headers.set("Accept","application/json");
            //HttpEntity entity  =   new HttpEntity(headers);

            //ResponseEntity<Employee> responseEntity;

            restTemplate.postForObject(fullUrl, employee, ResponseEntity.class);

            //employee    = responseEntity.getBody();


        }catch (Exception exception){
            System.out.println(exception);
            exception.printStackTrace();
        }

        return employee;
    }

}
