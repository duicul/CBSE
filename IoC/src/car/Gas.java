package car;

public class Gas extends Engine {

	public Gas(Tire t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		return "Gas "+super.show();
	}

}
