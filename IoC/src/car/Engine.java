package car;

public abstract class Engine {
private Tire t;
public Engine(Tire t) {
	this.t=t;
}
public String show() {
	return t.show();
}
}
