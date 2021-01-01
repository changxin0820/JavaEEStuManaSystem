//package com.JavaG.teat;
//
//import com.JavaG.dao.StudentDao;
//import com.JavaG.domain.Student;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import  java.io.InputStream;
//
//public class
//
//test {
//    private InputStream in;
//    private SqlSessionFactory factory;
//    private SqlSession session;
//    private StudentDao studentDao;
//    @Before
//    public void init() throws Exception{
//        //1.读取配置文件
//        in = Resources.getResourceAsStream("SqlMapConfig.xml ");
//        //2.创建SqlSessionFactory工厂
//        factory = new SqlSessionFactoryBuilder().build(in);
//        //3.使用工厂生产SqlSession对象
//        session = factory.openSession();
//        //4.使用SqlSession创建Dao接口的代理对象;
//        studentDao = session.getMapper(StudentDao.class);
//    }
//    @After
//    public void destory() throws Exception{
//        //若没有写session.commit();则更新的数据没有进行更新
//        session.commit();
//        //6.释放资源
//        session.close();
//        in.close();
//
//    }
////    @Test
////    public void findAllTest(){
////        //5.使用代理对象执行方法
////        Integer id = 1111110334;
////        Student student=studentDao.findStudentDetailsById(id);
////        System.out.println(student);
////
////        }
////
////    }