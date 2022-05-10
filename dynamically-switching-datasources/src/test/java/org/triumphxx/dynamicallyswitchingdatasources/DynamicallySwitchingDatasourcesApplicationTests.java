package org.triumphxx.dynamicallyswitchingdatasources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.triumphxx.dynamicallyswitchingdatasources.service.UserService;

@SpringBootTest
public class DynamicallySwitchingDatasourcesApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.println("userService.master() = " + userService.master());
        System.out.println("userService.slave() = " + userService.slave());
    }

}
