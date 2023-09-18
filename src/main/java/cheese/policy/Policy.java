package cheese.policy;


public class Policy {
  private float price;
  private float coverage;
  private String name;

  public Policy(String name, float price, float coverage) {
    this.name = name;
    this.price = price;
    this.coverage = coverage;
  }

  public float getPrice() {
    return price;
  }

  public float getCoverage() {
    return coverage;
  }

  public String getName() {
    return name;
  }
  
  @Override
  public String toString() {
    return "Policy: " + name + " " + price + " " + coverage;
  }
  
  public String toFileString() {
    return name + ";" + price + ";" + coverage + ",";
  }
}
