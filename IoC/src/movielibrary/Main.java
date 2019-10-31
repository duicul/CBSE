package movielibrary;

import Container.IoCContainer;

public class Main {

	public static void main(String[] args) {
		IoCContainer icc=new IoCContainer("config.txt");
		System.out.println(icc);
		icc.retrieve("movielibrary.MovieList");
		
	}

}
