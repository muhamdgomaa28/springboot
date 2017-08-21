package com.controler;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.ajaxresponsebody;
import com.model.serachcertaria.SearchCriteria;
import com.services.UserService;

@RestController
	public class SearchController {

	    UserService userService;

	    @Autowired
	    public void setUserService(UserService userService) {
	        this.userService = userService;
	    }

	    @PostMapping("/api/search")
	    public ResponseEntity<?> getSearchResultViaAjax(
	            @Valid @RequestBody SearchCriteria search, Errors errors) {

	        ajaxresponsebody result = new ajaxresponsebody();

	        //If error, just return a 400 bad request, along with the error message
	        if (errors.hasErrors()) {

	            result.setMsg(errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(",")));

	            return ResponseEntity.badRequest().body(result);

	        }

	        List<com.model.User> users = userService.findByUserNameOrEmail(search.getUsername());
	        if (users.isEmpty()) {
	            result.setMsg("no user found!");
	        } else {
	            result.setMsg("success");
	        }
	        result.setResult(users);

	        return ResponseEntity.ok(result);

	    }

	

}
