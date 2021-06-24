package fitnesscalc;

/**
 * Represents the client we got information on.
 *
 *@author Alejandro Figueredo
 */

public class Client {
  /**
   * The age of the client must be a whole number.
   */
  private int age;
  /**
   * The weight of the client is inserted in pounds and later converted into kilograms.
   */
  private double weight;

  /**
   * Original constructor of the object Client.
   */
  public Client() {
  }

  /**
   * Constructor with the parameters indicated below.
   * 
   * @param age indicates the age of the client that was inputed.
   * @param weight indicates the weight of the client that was inputed (in pounds).
   */
  public Client(int age, double weight) {
    setAge(age);
    setWeight(weight);
  }

  /**
   * Process use to get the user input.
   * 
   * @param ageToSet represented the age inputed by the user.
   */
  public void setAge(int ageToSet) {
    age = ageToSet;
  }

  /**
   * Process use to get the user input.
   * 
   * @param weightToSet represented the weight inputed by the user.
   */
  public void setWeight(double weightToSet) {
    weight = weightToSet;
  }

  /**
   * Process use to return the user input.
   * 
   * @return this client's age.
   */
  public int getAge() {
    return age;
  }

  /**
   * Process use to return the user input.
   * 
   * @return this client's weight.
   */
  public double getWeight() {
    return weight;
  }
}



