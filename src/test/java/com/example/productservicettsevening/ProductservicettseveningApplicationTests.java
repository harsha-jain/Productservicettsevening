package com.example.productservicettsevening;

import com.example.productservicettsevening.InheritanceExample.joinedclass.JTMentorRepository;
import com.example.productservicettsevening.InheritanceExample.joinedclass.Mentor;
import com.example.productservicettsevening.InheritanceExample.joinedclass.User;
import com.example.productservicettsevening.InheritanceExample.joinedclass.JTUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductservicettseveningApplicationTests {

   /* @Autowired
    private JTUserRepository userRepository;

    @Autowired
    private JTMentorRepository jtMentorRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testDifferenceInheritances(){
        User user=new User();
        user.setEmail("harsha@gmail.com");
        user.setPassword("password");
        userRepository.save(user);

        Mentor mentor=new Mentor();
        mentor.setEmail("aditi@gmail.com");
        mentor.setPassword("pssword");
        mentor.setNumberOfSession(4);
        mentor.setNumberOfMentees(50);
        jtMentorRepository.save(mentor);
    }*/
}
