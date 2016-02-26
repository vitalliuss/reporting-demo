package com.epam.automation;

import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Vitali_Shulha on 26-Feb-16.
 */
public class LogTest {

    @Test
    public void oneCanUseLog4J(){
        Logger logger = LogManager.getRootLogger();

        logger.info("Information message");
        logger.debug("Debug message");
        logger.trace("Trace message");
        logger.error("Error message");
        logger.warn("Warn message");
        logger.fatal("Fatal message");

    }

    @Test
    @Ignore
    public void ignoredTest(){}

    @Test
    public void oneCAnFail(){
        Assert.fail();
    }
}
