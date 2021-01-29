package com.amsidh.mvc;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = { UserRespository.class })
@RestController
@RequestMapping("/users")
public class SpringBootFabricOpenShitDemoApplication {

	@Autowired
	private UserRespository userRespository;

	@GetMapping
	public List<User> getAllUser() {
		return userRespository.findAll();
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		return userRespository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with userId" + userId));
	}

	@PostMapping
	public User getAllUser(@RequestBody User user) {
		return userRespository.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFabricOpenShitDemoApplication.class, args);
	}

}

@Repository
interface UserRespository extends MongoRepository<User, String> {

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String _id;
	private String name;
}

@RestController
@RequestMapping("/hello")
class TestController {
	@GetMapping
	public String hello() {
		return "Hello. Welcome to the world of springboot and Openshift Fabric";
	}

	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello " + name + " !. How are you feeling today";
	}

}