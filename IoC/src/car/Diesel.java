package car;

public class Diesel extends Engine {

	public Diesel(Tire t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		return "Diesel "+super.show();
	}

}
