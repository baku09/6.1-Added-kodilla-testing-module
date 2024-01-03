package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog(){
        //Given
        String logMessage = " Testowanie wiadmości";
        //When
        Logger.INSTANCE.log(logMessage);
        String lastlog = Logger.INSTANCE.getLastLog();
        //Then
        assertEquals(logMessage, lastlog);
    }

    @Test
    public void testSingleton(){
        //Given
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        //When
        logger1.log("logger 1");
        logger2.log("logger 2");
        //Then
        assertEquals(logger1.getLastLog(), logger2.getLastLog());
    }
}
