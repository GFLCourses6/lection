package pattern.builder;

import pattern.builder.ContactInfo;

public class Employee {
  private String name;
  private ContactInfo contactInfo;
  private String department;

  private Employee(EmployeeBuilder employeeBuilder) {
    name = employeeBuilder.name;
    contactInfo = employeeBuilder.contactInfo;
    department = employeeBuilder.department;
  }

  public String getName() {
    return name;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public String getDepartment() {
    return department;
  }

  public static class EmployeeBuilder {
    private String name;
    private ContactInfo contactInfo;
    private String department;

    public EmployeeBuilder(String name, String department) {
      this.name = name;
      this.department = department;
    }

    public EmployeeBuilder setContactInfo(ContactInfo contactInfo) {
      this.contactInfo = contactInfo;
      return this;
    }

    public Employee build() {
      return new Employee(this);
    }
  }
}

