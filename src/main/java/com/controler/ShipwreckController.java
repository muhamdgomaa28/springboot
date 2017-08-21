package com.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Shipwreck;
import com.services.shipservices;


@RestController
public class ShipwreckController {
	
	

    @Autowired
   shipservices shipservice;

	@RequestMapping(value="api/v1/shipwrecks")
	public List<Shipwreck> vv(){
		
		return ShipwreckStub.list();
	}

    @RequestMapping(value = "/shipwrecd/{id}/ship", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shipwreck> GetAllByTopicId(@PathVariable("id") String id) {
        return shipservice.getAll(id);
    }

    @RequestMapping(value = "/shipwrecd/{shipwrecdid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Shipwreck Getspecific(@PathVariable("shipwrecdid") String shipwrecdid) {

        return shipservice.getSpecific(shipwrecdid);

    }
	
	
	

}
