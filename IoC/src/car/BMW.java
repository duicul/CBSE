package car;

public class BMW extends Car {
	public BMW(Engine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		return "BMW "+super.show();
	}

}
