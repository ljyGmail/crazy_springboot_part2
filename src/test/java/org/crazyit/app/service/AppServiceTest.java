package org.crazyit.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AppServiceTest {
    @Autowired
    private AppService appService;

    @Test
    public void testSaveUserAndNews() {
        appService.saveUserAndNews();
    }

    @Test
    public void testGetUserAndNews() {
        appService.getUserAndNews();
    }

    @Test
    public void testUpdateUserAndNews() {
        appService.updateUserAndNews();
    }
}
