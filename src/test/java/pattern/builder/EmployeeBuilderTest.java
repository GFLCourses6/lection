package pattern.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EmployeeBuilderTest {
  @Test
  public void testEmployeeBuilder() {
    Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder("Jane Smith", "Finance");
    Employee employee = builder.build();

    assertEquals("Jane Smith", employee.getName());
    assertEquals("Finance", employee.getDepartment());

    ContactInfo retrievedContactInfo = employee.getContactInfo();
    assertNull(retrievedContactInfo);
  }

  @Test
  public void testEmployeeBuilderWithContactInfo() {
    ContactInfo contactInfo = new ContactInfo("987-654-3210", "jane@example.com");
    Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder("Jane Smith", "Finance")
        .setContactInfo(contactInfo);
    Employee employee = builder.build();

    assertEquals("Jane Smith", employee.getName());
    assertEquals("Finance", employee.getDepartment());

    ContactInfo retrievedContactInfo = employee.getContactInfo();
    assertNotNull(retrievedContactInfo);
    assertEquals("987-654-3210", retrievedContactInfo.getPhone());
    assertEquals("jane@example.com", retrievedContactInfo.getEmail());
  }
}
