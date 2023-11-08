package pattern.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeTest {
  @Test
  public void testEmployee() {
    ContactInfo contactInfo = new ContactInfo("123-456-7890", "employee@example.com");
    Employee employee = new Employee.EmployeeBuilder("John Doe", "HR")
        .setContactInfo(contactInfo)
        .build();

    assertEquals("John Doe", employee.getName());
    assertEquals("HR", employee.getDepartment());

    ContactInfo retrievedContactInfo = employee.getContactInfo();
    assertNotNull(retrievedContactInfo);
    assertEquals("123-456-7890", retrievedContactInfo.getPhone());
    assertEquals("employee@example.com", retrievedContactInfo.getEmail());
  }
}
