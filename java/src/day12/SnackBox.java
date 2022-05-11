package day12;

public class SnackBox extends Product {
	
	private int count;
	
	public SnackBox(String name, int Price, int amount, int count) {
		super(name, Price, amount);
		this.count = count;
	}

	@Override
	public void print() {
		System.out.println(getName() + "[박스당 " + count + "개] : " + getPrice() +"원 - "+ getAmount());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
