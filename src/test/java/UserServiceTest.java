import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huangwei.cms.domain.User;
import com.huangwei.cms.enums.Gender;
import com.huangwei.cms.service.IArticleService;
import com.huangwei.cms.service.IUserService;
import com.huangwei.cms.vo.ArticleVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context/root-context.xml")
public class UserServiceTest {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IArticleService articleService;
	
	@Test
	public void registerTest() {
		assertNotNull(userService.register("wangwu", "123", Gender.FAMALE));
	}
	
	@Test
	public void userLoginTest() {
		assertNotNull(userService.login("lili", "123"));
		assertNotNull(userService.login("", ""));
	}
	
	@Test
	public void findArticleAuthorByIdTest( ) {
		ArticleVo article = articleService.findArticleAuthorById(7);
		System.out.println(article);
		ArticleVo findArticleById = articleService.findArticleById(1);
		System.out.println(findArticleById);
	}
	
}
