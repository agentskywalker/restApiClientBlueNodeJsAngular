package com.agentskywalker.office.employeemanagement.apiclient.controller;

import com.agentskywalker.office.employeemanagement.apiclient.common.entity.Employee;
import com.agentskywalker.office.employeemanagement.apiclient.service.AppService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static org.springframework.http.HttpMethod.GET;

@Controller
@RequestMapping("/direct/api")
public class DirectApiController {

    public static Logger logger = LoggerFactory.getLogger(DirectApiController.class);

    @Autowired
    AppService appService;

    @GetMapping("/employee/{sid}")
    //public String getAppEmployees(Map<String, Object> model) {
    public void getAppEmployeeBySid(@PathVariable String sid) {
        //List<Employee>  employeeList = new List<Employee>();

        String urlIp = "http://localhost:1211";
        String urlApiLink = "/api/employee/";
        //String  sid =   "n683452";
        String fullUrl = urlIp + urlApiLink + sid;

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


                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                System.out.println("JSON Response in String format");
                System.out.println(inline);
                sc.close();
            }

            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser parse = new JSONParser();

            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject) parse.parse(inline);


            System.out.println("sid : " + jobj.get("sid"));
            System.out.println("first_name: " + jobj.get("first_name"));
            System.out.println("last_name: " + jobj.get("last_name"));
            System.out.println("role: " + jobj.get("role"));
            System.out.println("email: " + jobj.get("email"));
            System.out.println("mgr_id: " + jobj.get("mgr_id"));
            System.out.println("dob: " + jobj.get("dob"));
            System.out.println("ssn: " + jobj.get("ssn"));

            //Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
            JSONArray jsonarr_1 = (JSONArray) jobj.get("results");

            //Get data for Results array
            for (int i = 0; i < jsonarr_1.size(); i++) {
                //Store the JSON objects in an array
                //Get the index of the JSON object and print the values as per the index
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                //Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
                JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
                System.out.println("Elements under results array");
                System.out.println("\nPlace id: " + jsonobj_1.get("place_id"));
                System.out.println("Types: " + jsonobj_1.get("types"));

                //Get data for the Address Components array
                System.out.println("Elements under address_components array");
                System.out.println("The long names, short names and types are:");
                for (int j = 0; j < jsonarr_2.size(); j++) {
                    //Same just store the JSON objects in an array
                    //Get the index of the JSON objects and print the values as per the index
                    JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
                    //Store the data as String objects
                    String str_data1 = (String) jsonobj_2.get("long_name");
                    System.out.println(str_data1);
                    String str_data2 = (String) jsonobj_2.get("short_name");
                    System.out.println(str_data2);
                    System.out.println(jsonobj_2.get("types"));
                    System.out.println("\n");
                }

            }
            //Disconnect the HttpURLConnection stream
            conn.disconnect();


        } catch (Exception exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }


        ///return employeeList;
        /*model.put("message", "Welcome to Spring Java");
        logger.info("Controller : Endpoint :: WebController : /");
        return "index";*/
    }

    @GetMapping("/employees")
    //public String getAppEmployees(Map<String, Object> model) {
    public void getAppEmployees() {

        String urlIp = "http://localhost:1211";
        String urlApiLink = "/api/employees/";
        String fullUrl = urlIp + urlApiLink;

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


            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            HttpEntity entity = new HttpEntity(headers);

//          ResponseEntity<String>  responseEntity  =   restTemplate.exchange(fullUrl, GET, entity, String.class);
            ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(fullUrl, Employee[].class);

            Employee[] employees = responseEntity.getBody();

            /*System.out.println(employees[1].toString());
            System.out.println(employees[2].toString());
            System.out.println(employees[3].toString());*/

            //Traditional For Each
            System.out.println("Traditional For Each");
            for (Employee num : employees) {
                System.out.println(num.toString());
            }

            /*
            //Lambda For Each
            System.out.println("Lambda For Each");
            ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
            //sout doesn't work, need to be different method for it to work
            employeeArrayList.forEach((n) -> System.out.println(n));*/



            /*if(responseEntity.getStatusCode() == HttpStatus.OK){

                JSONParser  jsonParser  =   new JSONParser();

                JSONObject jsonObject =   (JSONObject) JSONValue.parse(responseEntity.getBody());
                //JSONArray jsonArray = (JSONArray) jsonParser.parse(responseEntity.getBody());

                System.out.println("Using RestTemplate");
                System.out.println(jsonObject.toString());
                //System.out.println(jsonArray.toString());

            }*/


            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser parse = new JSONParser();

            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject) parse.parse(inline);


            System.out.println("sid : " + jobj.get("sid"));
            System.out.println("first_name: " + jobj.get("first_name"));
            System.out.println("last_name: " + jobj.get("last_name"));
            System.out.println("role: " + jobj.get("role"));
            System.out.println("email: " + jobj.get("email"));
            System.out.println("mgr_id: " + jobj.get("mgr_id"));
            System.out.println("dob: " + jobj.get("dob"));
            System.out.println("ssn: " + jobj.get("ssn"));

        } catch (Exception exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }

    }

}
