package com.example.Day8;

import com.example.Day8.entity.*;
import com.example.Day8.repository.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Day8ApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepositor;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BlogRepository blogRepository;

	@Test
	void save_category() {
		Faker faker = new Faker();
		for (int i = 0; i < 5; i++) {
			Category category = new Category();
			category.setName(faker.name().name());
			categoryRepository.save(category);
		}
	}

	@Test
	void save_role() {
		Faker faker = new Faker();
		for (int i = 0; i < 3; i++) {
			Role role = new Role();
			role.setName(faker.name().name());
			roleRepositor.save(role);
		}

	}

	@Test
	void save_user() {
		Faker faker = new Faker();
		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setName(faker.name().fullName());
			user.setAvatar(faker.internet().avatar());
			user.setPassword(faker.internet().password());
			user.setRoles(roleRepositor.findAll());
			userRepository.save(user);

			for (int j = 0; j < 50; j++) {
				Blog blog = new Blog();
				blog.setContent(faker.lorem().paragraph());
				blog.setSlug(faker.internet().slug());
				blog.setDescription(faker.lorem().characters());
				blog.setThumbnail(faker.internet().image());
				blog.setTitle(faker.lorem().sentence());
				blog.setCategories(categoryRepository.findAll());
				blog.setUser(user);

				for (int k = 0; k < 100; k++) {
					Comment comment = new Comment();
					comment.setContent(faker.lorem().paragraph());
					comment.setUser(user);
				}
			}
		}
	}
}
