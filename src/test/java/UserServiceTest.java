import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bawei.cms.domain.User;
import com.bawei.cms.enums.Gender;
import com.bawei.cms.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context/root-context.xml")
public class UserServiceTest {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void registerTest() {
		assertNotNull(userService.register("wangwu", "123", Gender.FAMALE));
	}
	
	@Test
	public void userLoginTest() {
		assertNotNull(userService.login("lili", "123"));
		assertNotNull(userService.login("", ""));
	}
	
}
