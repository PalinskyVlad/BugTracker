package com.bugtracker.test;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
public class Logging {

    private static final Logger logger = Logger.getLogger(Logging.class);

    @Test
    public void loggingTest() {
        MDC.put("username", "TesbtUser");
        logger.info("test message");
        MDC.put("username", "TesbtUser");
        logger.info("test message2");
        MDC.put("username", "TesbtUser2");
        logger.info("test message3");
        MDC.put("username", "TesbtUser2");
        logger.info("test message4");
        MDC.put("username", "TesbtUser3");
        logger.info("test message5");
        MDC.put("username", "TesbtUser3");
        logger.info("test message6");
        MDC.put("username", "TesbtUser4");
        logger.info("test message7");
        MDC.put("username", "TesbtUser4");
        logger.info("test message8");
    }
}
