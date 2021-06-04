package com.paul.zamtel_api.controller;

import com.paul.zamtel_api.model.DAOUser;
import com.paul.zamtel_api.model.ZamtelEndPoint;
import com.paul.zamtel_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ResourceController {
//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@RequestMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	@RequestMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}

	@PostMapping(path="/addUser")
	public @ResponseBody  String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String role ){
		DAOUser user = new DAOUser();
		user.setPassword(bcryptEncoder.encode(password));
		user.setUsername(username);
		if (role.equalsIgnoreCase("ROLE_ADMIN") || role.equalsIgnoreCase("ROLE_USER")){
			userDao.save(user);
			return "Saved";
		}else{
			return "Role is supposed to be either ROLE_ADMIN or ROLE_USER";
		}
	}

	@GetMapping("/getOne")
	public @ResponseBody String getOne(@RequestParam String username){
		DAOUser user = new DAOUser();
		return "Welcome "+username;
	}

	@RequestMapping("/fromExternal")
	public @ResponseBody String getExternal(){
		RestTemplate restTemplate = new RestTemplate();

//		ZamtelEndPoint zamtelEndPoint = restTemplate.getForObject(
//				"https://quoters.apps.pcfone.io/api/random", ZamtelEndPoint.class
//		);
		String results= restTemplate.getForObject(
				"https://apps.zamtel.co.zm/zamtelAssessment", String.class
		);

		return results;
	}

}
