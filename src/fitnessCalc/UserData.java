package fitnessCalc;
class firstClient {
	private int age;
	private double weight;
	
	public firstClient() {
		setAge(age);
		setWeight(weight);
	}
	public firstClient(int age, double weight) {
		setAge(age);
		setWeight(weight);
	}
	
	public void setAge(int ageToSet) {
		age = ageToSet;
	}
	public void setWeight(double weightToSet) {
		weight = weightToSet;
	}
	public int getAge() {
		return age;
	}
	public double getWeight() {
		return weight;
	}
}