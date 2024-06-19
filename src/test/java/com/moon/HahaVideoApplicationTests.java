package com.moon;

import com.moon.pojo.User;
import com.moon.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HahaVideoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println("This is Unit Test class");
    }

    @Test
    void testUserInsert(){
        /* org.junit.jupiter.api.extension.ParameterResolutionException:
          No ParameterResolver registered for parameter
          @Test func no need parameters
         */
        User user = new User();
        user.setFaceImage("");
        user.setName("moonjay");
        user.setNickname("moonjay");
        user.setPwd("123456");

        try {
            userService.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("user insert func completed!");
        }
    }

    @Test
    void testFindByNP(){
        try {
            User u = userService.findUser("moonjay", "123456");
            System.out.println(u.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
