package com.rockysingh.cache;

import com.rockysingh.cache.domain.User;
import com.rockysingh.cache.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootRedisCacheExampleApplication.class)
@WebAppConfiguration
public class SpringBootRedisCacheExampleApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RedisTemplate<String, User> redisTemplate;

  @Test
  public void contextLoads() {
  }

  @Test
  public void testUser() {
    User user = new User();
    user.setName("name");
    user.setAddress("shanghai");
    userRepository.save(user);
  }

  @Test
  public void testSave() {
    User user = new User();
    user.setId("200");
    user.setName("name");
    user.setAddress("shanghai");
    redisTemplate.opsForValue().set(user.getId(), user);
  }

}
