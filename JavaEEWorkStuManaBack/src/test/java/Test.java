import com.JavaG.domain.Score;
import com.JavaG.domain.User;
import com.JavaG.service.ReportCardService;
import com.JavaG.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @author 邓育永
 * @date 2020/12/19 15:28
 */
public class Test {
    @org.junit.Test
    public void testLogin(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserService service = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setUsername("1006");
        user.setPassword("1");
        User result =service.login(user);
        if(result!=null){
            System.out.println("登录成功");
        }
        else System.out.println("帐号或密码错误，请重新输入");
        System.out.println(result);
    }
    @org.junit.Test
    public void testToken(){
        String  token = UUID.randomUUID() + "";
        System.out.println(token);
    }

    @org.junit.Test
    public void testInsertScore(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ReportCardService service = (ReportCardService) ctx.getBean("reportCardService");


        Score score = new Score(1004,"语文",111);
        service.insertScore(score);


    }

}


