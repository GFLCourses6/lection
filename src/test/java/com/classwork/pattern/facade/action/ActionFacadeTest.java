package com.classwork.pattern.facade.action;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ActionFacadeTest {

    private ActionFacade actionFacade;
    private Singleton singletonDataBase;
    private Singleton singletonFile;
    private Singleton singletonConsole;
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setup() {
        singletonFile = Mockito.mock(Singleton.class);
        singletonConsole = Mockito.mock(Singleton.class);
        singletonDataBase = Mockito.mock(Singleton.class);
        actionFacade = new ActionFacade();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Test ActionFacade performActions")
    void testActionFacadePerformActions() {
        when(singletonFile.action()).thenReturn(1);
        when(singletonConsole.action()).thenReturn(2);
        when(singletonDataBase.action()).thenReturn(3);
        actionFacade.performActions();
        assertEquals(1, singletonFile.action());
        assertEquals(2, singletonConsole.action());
        assertEquals(3, singletonDataBase.action());
        verify(singletonFile, times(1)).action();
        verify(singletonConsole, times(1)).action();
        verify(singletonDataBase, times(1)).action();
    }

    @Test
    @DisplayName("Test performActions action before and after SingletonFile")
    void testSingletonFileActions() {
        SingletonFile instance = SingletonFile.getInstance(1);
        assertEquals(1, instance.getValue());
        assertEquals(2, instance.action());
        when(singletonFile.action()).thenReturn(3);
        actionFacade.performActions();
        Integer action = singletonFile.action();
        assertEquals(3, action);
        verify(singletonFile, times(1)).action();
    }

    @Test
    @DisplayName("Test SingletonFile value")
    void testSingletonDataBaseValue() {
        SingletonFile instance = SingletonFile.getInstance(1);
        assertEquals(1, instance.getValue());
        assertEquals(2, instance.action());
    }

    @Test
    @DisplayName("Test SingletonDataBase action")
    void testSingletonDataBaseAction() {
        when(singletonDataBase.action()).thenReturn(1);
        Integer result = singletonDataBase.action();
        assertEquals(1, result);
        verify(singletonDataBase, times(1)).action();
    }

    @Test
    @DisplayName("Test SingletonFile action")
    void testSingletonFileAction() {
        when(singletonFile.action()).thenReturn(1);
        Integer result = singletonFile.action();
        assertEquals(1, result);
        verify(singletonFile, times(1)).action();
    }

    @Test
    @DisplayName("Test ActionFacade performActions System.out.print")
    void testPerformAction() {
        actionFacade.performActions();
        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        assertEquals("Action: 1", lines[0].trim());
        assertEquals("Action: 2", lines[1].trim());
        assertEquals("Action: 3", lines[2].trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(out);
    }
}