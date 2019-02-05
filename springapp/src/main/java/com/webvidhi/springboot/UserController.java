package com.webvidhi.springboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webvidhi.springboot.model.User;

@EnableCaching
@RestController
public class UserController {
	
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/mUser", method = RequestMethod.POST)
	@CachePut("Users")
	public User user(@RequestParam(value="userName", defaultValue="demo") String userName) {
		
		 User user = new User(counter.incrementAndGet(),userName);
		 
		 return user;
	}
	

	
	@Cacheable("Users")
	@RequestMapping(value = "/mUser", method = RequestMethod.GET)
	public User cacheduser(@RequestParam(value="userName") String userName) {
		
		 System.out.println("Fetching user");
		 User user = new User(counter.incrementAndGet(),userName);
		 
		 return user;
	}
	
}
