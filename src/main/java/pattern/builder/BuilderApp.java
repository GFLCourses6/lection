package pattern.builder;

public class BuilderApp {
  public static void main(String[] args) {
    ContactInfo contactInfo = new ContactInfo("123-456-7890", "employee@example.com");

    Employee employee = new Employee.EmployeeBuilder("John Doe", "HR")
        .setContactInfo(contactInfo)
        .build();

    System.out.println("Employee Name: " + employee.getName());
    System.out.println("Department: " + employee.getDepartment());

    if (employee.getContactInfo() != null) {
      System.out.println("Contact Info:");
      System.out.println("Phone: " + employee.getContactInfo().getPhone());
      System.out.println("Email: " + employee.getContactInfo().getEmail());
    } else {
      System.out.println("Contact Info: Not provided");
    }
  }
}

