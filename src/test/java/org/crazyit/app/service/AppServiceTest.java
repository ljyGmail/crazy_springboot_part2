package org.crazyit.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.TransactionManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AppServiceTest {
    @Autowired
    private AppService appService;

    @Autowired // 获取Spring容器
    private ApplicationContext ctx;

    @Test
    public void testSaveUserAndNews() {
        appService.saveUserAndNews();
    }

    @Test
    public void testUpdateUserAndNews() {
        System.out.println("==> " + ctx.getBeansOfType(TransactionManager.class));
        appService.updateUserAndNews();
    }
}
