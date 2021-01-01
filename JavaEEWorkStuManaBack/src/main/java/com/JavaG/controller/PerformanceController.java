package com.JavaG.controller;


import com.JavaG.domain.ReportCard;
import com.JavaG.domain.Score;
import com.JavaG.service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 邓育永
 * @date 2020/12/15 23:19
 */
@RestController
@RequestMapping("/api/performance")
public class PerformanceController {
    @Autowired
    private ReportCardService reportCardService;    //用于查询成绩的service对象

    @CrossOrigin
    @RequestMapping("/reportcard")
    @ResponseBody
    public ReportCard reportcard(HttpServletRequest request) {

        //获取session
        HttpSession session = request.getSession(false);
        //从Session域中读取指定属性
        String sid = null;
        if(session !=null){
            sid = (String)session.getAttribute("sid");
        }

        ReportCard str =new ReportCard();   //创建一个用于作为查询条件的ReportCard对象
        str.setSid(Integer.parseInt(sid));  //用学号查询
        ReportCard result = reportCardService.selectReportCard(str);//查询成绩，返回给客户端

        return result;

    }

    @CrossOrigin
    @RequestMapping("/selectReportCardById")
    @ResponseBody
    public ReportCard selectReportCardByID(HttpServletRequest request) {

        String sid = request.getParameter("sid");

        ReportCard str =new ReportCard();   //创建一个用于作为查询条件的ReportCard对象
        str.setSid(Integer.parseInt(sid));  //用学号查询
        ReportCard result = reportCardService.selectReportCard(str);//查询成绩，返回给客户端

        return result;

    }


    @CrossOrigin
    @RequestMapping("/insertScore")
    @ResponseBody
    public void insertScore(HttpServletRequest request) {
        //获取用户的帐号，新建一个Use对象，以这个对象查询数据库中是否存在该用户
        String sid = request.getParameter("sid");
        //获取用户的帐号，新建一个Use对象，以这个对象查询数据库中是否存在该用户
        String course = request.getParameter("course");
        //获取用户的帐号，新建一个Use对象，以这个对象查询数据库中是否存在该用户
        String score = request.getParameter("score");

        Score insert_score = new Score(Integer.parseInt(sid),course,Integer.parseInt(score));
        reportCardService.insertScore(insert_score);



    }


}
