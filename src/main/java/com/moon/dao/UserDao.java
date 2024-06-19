package com.moon.dao;

import com.moon.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author moonjay
 */
@Transactional
public interface UserDao extends JpaRepository<User,Integer> {
    /**用户名和密码都正确的情况下查询
     * @param name
     * @param pwd
     * @return: user
     * */

    @Query(value = "select * from t_users u where u.username = ?1 and u.password = ?2", nativeQuery = true)
    User findUserByNameAndPwd(String name, String pwd);
}
