package com.example.demobcknd.controllers;

import com.example.demobcknd.models.user;
import com.example.demobcknd.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // This means that this class is a Controller
@CrossOrigin // allow crossorigin
@RequestMapping(path = "/user", method = { RequestMethod.GET, RequestMethod.POST }) // This means URL's start with /demo
																																										// (after Application path)
public class userController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data

	userService userS = new userService();


	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> newuser(@RequestBody user newuser) {

		userS.addUser(newuser);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}


@RequestMapping(path = "/all", method = RequestMethod.GET)
public ResponseEntity<Iterable<user>> getAllUsers() {
	Iterable<user> users = userS.findAllUsers();
	return new ResponseEntity<Iterable<user>>(users, HttpStatus.OK);
}



	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
        user myuser = userS.findUser(id);
        return new ResponseEntity<user>(myuser, HttpStatus.OK);
    }


	@RequestMapping("/delete/{id}")
	public @ResponseBody String deleteUserID(@PathVariable("id") int id) {

		return userS.deleteUser(id);
	}

	@RequestMapping("/update/{id}")
	public @ResponseBody String updateUser(@PathVariable("id") int id, @RequestParam String name,
			@RequestParam String email) {
		return userS.updateUser(id, email, name);
	}

}
