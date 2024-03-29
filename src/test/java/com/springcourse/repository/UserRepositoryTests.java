package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void AsaveTest() {
		User user = new User(null, "Bruno", "brunoalb.silva@hotmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = this.userRepository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest() {
		User user = new User(1L, "Bruno Silva", "brunoalb.silva@hotmail.com", "123", Role.ADMINISTRATOR, null, null);
		User updateUser = this.userRepository.save(user);
		
		assertThat(updateUser.getName()).isEqualTo("Bruno Silva");
	}
	
	@Test
	public void getByIdTest() {
		Optional<User> result = this.userRepository.findById(1L);
		User user = result.get();
		
		assertThat(user.getPassword()).isEqualTo("123");
	}
	
	@Test
	public void listTest() {
		List<User> users = this.userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(1);
	}
	
	@Test
	public void loginTest() {
		Optional<User> result = this.userRepository.login("brunoalb.silva@hotmail.com", "123");
		User loggedUser = result.get();
		
		assertThat(loggedUser.getId()).isEqualTo(1L);
	}
}