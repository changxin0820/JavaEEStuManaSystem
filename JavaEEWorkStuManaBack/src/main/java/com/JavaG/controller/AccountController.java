package com.JavaG.controller;

import com.JavaG.domain.Account;
import com.JavaG.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帐户web
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public List<Account> findAll(){
        System.out.println("表现层：查询所有账户...");
        // 调用service的方法
        List<Account> list = accountService.findAll();//gugiu
        for(Account account:list){
            System.out.println(account);
        }
        return list;
    }

        /**
     * 保存
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

}
