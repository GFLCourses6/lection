package pattern.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactInfoTest {
  @Test
  public void testContactInfo() {
    ContactInfo contactInfo = new ContactInfo("555-123-4567", "test@example.com");

    assertEquals("555-123-4567", contactInfo.getPhone());
    assertEquals("test@example.com", contactInfo.getEmail());
  }
}