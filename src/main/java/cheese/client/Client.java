package cheese.client;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import cheese.policy.Policy;

public class Client {
  private String name;
  private String address;
  private String phone;
  private String email;
  private LocalDate birthDate;
  private List<Policy> policies;

  public Client(String name, String address, String phone, String email, LocalDate birthDate) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.birthDate = birthDate;
    this.policies = new ArrayList<Policy>();
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getEmail() {
    return this.email;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public List<Policy> getPolicies() {
    return this.policies;
  }

  public void addPolicy(Policy policy) {
    this.policies.add(policy);
  }

  public void removePolicy(Policy policy) {
    this.policies.remove(policy);
  }

  @Override
  public String toString() {
    return "Client: " + this.name + "\n" +
      "Address: " + this.address + "\n" +
      "Phone: " + this.phone + "\n" +
      "Email: " + this.email + "\n" +
      "Birth Date: " + this.birthDate + "\n" +
      "Policies: " + this.policies + "\n";
  }
  
  public String toFile() {
    return this.name + " | " +
      this.address + " | " +
      this.phone + " | " +
      this.email + " | " +
      this.birthDate + " | " +
      this.policies + "\n";
  }
}
