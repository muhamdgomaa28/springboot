package com.controler;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.Response;

@RestController
public class RestWebController {
 
	List<Customer> cust = new ArrayList<Customer>();
 
	@RequestMapping(value = "welcome.html/getallcustomer", method = RequestMethod.GET)
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}
 
	@RequestMapping(value = "welcome.html/postcustomer", method = RequestMethod.POST)
	public Response postCustomer(@RequestBody Customer customer) {
		cust.add(customer);
		// Create Response Object
		Response response = new Response("Done", customer);
		return response;
	}
}