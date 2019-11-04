package comp;

public class Pc {
private Cpu c;
private Hdd h;
private Ram r;
public Pc(Cpu c,Hdd h,Ram r) {
	this.c=c;
	this.h=h;
	this.r=r;}

public String show() {
	return "Cpu "+c.show()+" Hdd "+h.show()+" Ram "+r.show();}
}
