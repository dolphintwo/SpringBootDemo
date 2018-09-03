package com.dolphintwo.demo;

import com.dolphintwo.demo.entity.Doge;
import com.dolphintwo.demo.entity.User;
import com.dolphintwo.demo.rabbit.Sender;
import com.dolphintwo.demo.repository.DogeRepository;
import com.dolphintwo.demo.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private Sender sender;

	@Autowired
	private DogeRepository dogeRepository;

	@Before
	public void setup() {
		userRepository.deleteAllUsers();
		dogeRepository.deleteAll();
	}


	@Test
	@Transactional
	public void testJpa() throws Exception {
		// 创建10条记录
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 20));
		userRepository.save(new User("CCC", 30));
		userRepository.save(new User("DDD", 40));
		userRepository.save(new User("EEE", 50));
		userRepository.save(new User("FFF", 60));
		userRepository.save(new User("GGG", 70));
		userRepository.save(new User("HHH", 80));
		userRepository.save(new User("III", 90));
		userRepository.save(new User("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());

		userRepository.deleteAllUsers();

	}


	@Test
	public void testRedis() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
		stringRedisTemplate.delete("aaa");
	}


	@Test
	public void testRabbit() throws Exception {
		sender.send();
	}

	@Test
	public void testMongo() throws Exception {

		// 创建三个User，并验证User总数
		dogeRepository.save(new Doge(1L, "didi", 30));
		dogeRepository.save(new Doge(2L, "mama", 40));
		dogeRepository.save(new Doge(3L, "kaka", 50));
		Assert.assertEquals(3, dogeRepository.findAll().size());

		// 删除一个User，再验证User总数
		Doge d = dogeRepository.findOne(1L);
		dogeRepository.delete(d);
		Assert.assertEquals(2, dogeRepository.findAll().size());

		// 删除一个User，再验证User总数
		d = dogeRepository.findByName("mama");
		dogeRepository.delete(d);
		Assert.assertEquals(1, dogeRepository.findAll().size());
	}

	@Test
	@Rollback
	public void testCache() throws Exception {

		userRepository.save(new User("KKK", 110));

		User u1 = userRepository.findByName("KKK");
		System.out.println("第一次查询：" + u1.getAge());

		User u2 = userRepository.findByName("KKK");
		System.out.println("第二次查询：" + u2.getAge());

		u1.setAge(120);
		userRepository.save(u1);
		User u3 = userRepository.findByName("KKK");
		System.out.println("第三次查询：" + u3.getAge());

		userRepository.delete(userRepository.findByName("KKK"));
	}

}
