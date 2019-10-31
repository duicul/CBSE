package car;

public class Lada extends Car {

	public Lada(Engine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String show() {
		return "Lada "+super.show();
	}

}
