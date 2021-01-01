package com.JavaG.dao;

import com.JavaG.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * 帐户dao接口
 */
@MapperScan
public interface AccountDao {

    // 查询所有账户
    public List<Account> findAll();

    // 保存帐户信息
    public void saveAccount(Account account);

}
