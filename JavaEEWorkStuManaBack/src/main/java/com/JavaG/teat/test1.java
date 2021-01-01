package com.JavaG.teat;

import com.JavaG.dao.AcademyDao;
import com.JavaG.dao.StudentDao;
import com.JavaG.domain.Academy;
import com.JavaG.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import  java.io.InputStream;
import java.util.List;

public class

test1 {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AcademyDao studentDao;
    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml ");
        //2.创建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象;
        studentDao = session.getMapper(AcademyDao.class);
    }
    @After
    public void destory() throws Exception{
        //若没有写session.commit();则更新的数据没有进行更新
        session.commit();
        //6.释放资源
        session.close();
        in.close();

    }
    @Test
    public void findAllTest(){
        //5.使用代理对象执行方法
        List<Academy> academies=studentDao.findAllAcademies();
        for(Academy academy:academies){
            System.out.println(academy);
        }

    }

}