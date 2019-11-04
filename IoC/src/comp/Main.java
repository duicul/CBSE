package comp;

import Container.IoCContainer;

public class Main {

	public static void main(String[] args) {
		IoCContainer icc=new IoCContainer("config2.txt");
		System.out.println(icc);
		Pc mypc=(Pc)icc.retrieve("comp.Pc");
		System.out.println(mypc.show());
	}

}
