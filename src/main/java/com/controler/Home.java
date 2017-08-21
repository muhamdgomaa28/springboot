package com.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Shipwreck;
import com.services.shipservices;

@RestController
public class Home {

    @Autowired
   shipservices shipservice;

//	
	@RequestMapping("/koko")
	public String mm(Shipwreck s){
//		s.setName("koko");
    	s.setLatitude(12.3);
    	s.setDepth(5);
    	s.setDescription("2222lplplp");
    	s.setCondition("sssss");
    	s.setYearDiscovered(262);
    	s.setLongitude(3.3);
    	
shipservice.insertship(s);
		return"kokko";
	}
//	
//}
}