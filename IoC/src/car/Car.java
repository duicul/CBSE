package car;

public abstract class Car {

private Engine e;
public Car(Engine e) {
	this.e=e;
}
public String show() {
	return e.show();
}
}
