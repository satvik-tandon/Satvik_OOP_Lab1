import java.util.*;

class Employee {

  private String name;

  public Employee(String name) {
    this.name = name;
  }

  public Employee() {
    this.name = "";
  }

  String getDepartment(int department) {
    Map<Integer, String> dep = new HashMap<>();
    dep.put(1, "tech");
    dep.put(2, "admin");
    dep.put(3, "hr");
    dep.put(4, "legal");
    return dep.get(department);
  }

  String getName() {
    return name;
  }

  String generatePassword(int length) {
    Random random = new Random();
    StringBuilder password = new StringBuilder();
    String characters =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";
    for (int i = 0; i < length - 3; i++) password.append(
      characters.charAt(random.nextInt(characters.length()))
    );

    return password.toString();
  }

  String getEmail(String name, int departmentNumber) {
    String email = "";
    for (int i = 0; i < name.length(); i++) {
      char ch = name.charAt(i);
      if (ch == 32) continue; else email += Character.toLowerCase(ch);
    }
    email += "@" + getDepartment(departmentNumber) + ".greatlearning.com";
    return email;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println( "Please enter the department from the following\n1. Technical\n2. Admin\n3. Human Resources\n4. Legal\n");
    int n = sc.nextInt();
    String flush = sc.nextLine();
    System.out.print("Name of the employee: ");
    String name = sc.nextLine();
    Employee obj = new Employee(name);
    String password = obj.generatePassword(12);
    String email = obj.getEmail(name, n);
    System.out.println("Dear " + name + ", your generated credentials are as follows:");
    System.out.println("Email\t\t--->\t" + email + "\nPassword\t--->\t" + password);
    sc.close();
  }
}
