package com.ua;

import com.ua.di.AbstractFactory;
import com.ua.di.DIFactory;
import com.ua.di.exception.ConstructorException;
import com.ua.di.exception.NonExistentService;
import com.ua.di.service.DBIntegrationService;
import com.ua.di.service.FileIntegrationService;
import com.ua.di.service.ServiceBuildFactory;
import com.ua.di.service.StringIntegrationService;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceBuildFactoryTest {

    //    @Test
    //    void testServicesCreation() {
    //        ServiceBuildFactory buildFactory = new ServiceBuildFactory();
    //        Set<Class<?>> services = buildFactory.getServices();
    //
    //        for (Class<?> service : services) {
    //            Object createdService = buildFactory.create(service);
    //            assertNotNull(createdService, "Service not found for: " + service);
    //        }
    //    }
    //
    //    @Test
    //    void testServiceInstantiation() {
    //        ServiceBuildFactory buildFactory = new ServiceBuildFactory();
    //        Set<Class<?>> services = buildFactory.getServices();
    //
    //        for (Class<?> clazz : services) {
    //            if (!clazz.isInterface()) {
    //                assertDoesNotThrow(() -> {
    //                    Object service =
    //                            clazz.getDeclaredConstructor().newInstance();
    //                }, "Failed to instantiate service: " + clazz);
    //            }
    //        }
    //    }

    //    @Test
    //    void testServiceInstantiation() {
    //        ServiceBuildFactory buildFactory = new ServiceBuildFactory();
    //        Set<Class<?>> services = buildFactory.getServices();
    //        buildFactory.build(services);
    //        for (Class<?> clazz : services) {
    //            if (!clazz.isInterface()) {
    //                assertDoesNotThrow(() -> buildFactory.create(clazz));
    //            }
    //        }
    //    }

    @Test
    void testServicesCreation() {
        ServiceBuildFactory buildFactory = new ServiceBuildFactory();
        Set<Class<?>> services = buildFactory.getServices();
        assertEquals(0, services.size());
    }

    @Test
    void testServiceNotFound() {
        ServiceBuildFactory buildFactory = new ServiceBuildFactory();
        assertThrows(ConstructorException.class,
                () -> buildFactory.create(NonExistentService.class));
    }

    @Test
    void testStringIntegrationService() {
        AbstractFactory factory = new DIFactory();
        StringIntegrationService service = factory.create(StringIntegrationService.class);
        String regex = service.parseStringByRegex("Alice;Bob;Charlie");
        assertEquals("Alice Bob Charlie", regex);
    }

    @Test
    void testFileIntegrationService() {
        String path = "src\\main\\resources\\log4j2.xml";
        AbstractFactory factory = new DIFactory();
        FileIntegrationService service = factory.create(FileIntegrationService.class);
        String fileNameByPath = service.getFileNameByPath(path);
        assertNotNull(fileNameByPath);
    }

    @Test
    void testDBIntegrationService() {
        AbstractFactory factory = new DIFactory();
        DBIntegrationService service = factory.create(DBIntegrationService.class);

        String book = service.getBookByYearAndAuthor("1984", "Orwell");
        assertEquals("SELECT * FROM book WHERE year = '1984' AND author = 'Orwell'", book);

        String author = service.getBookByYearOrAuthor("1984", "Orwell");
        assertEquals("SELECT * FROM book WHERE year = '1984' OR author = 'Orwell'", author);
    }
}
