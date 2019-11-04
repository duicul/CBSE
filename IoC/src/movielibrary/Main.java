package movielibrary;

import Container.IoCContainer;
import car.BMW;
import car.Lada;

public class Main {

	public static void main(String[] args) {
		IoCContainer icc=new IoCContainer("config1.txt");
		System.out.println(icc);
		BMW bmwvara=(BMW)icc.retrieve("car.BMW","bmwvara");
		System.out.println(bmwvara.show());
		Lada ladaiarna=(Lada)icc.retrieve("car.Lada","ladaiarna");
		System.out.println(ladaiarna.show());
		
	}

}
