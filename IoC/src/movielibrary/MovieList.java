package movielibrary;

public class MovieList {
	private MovieSearch mf;
	public MovieList(MovieSearch mf) {
		this.mf=mf;
		System.out.println(this.mf.find());
		
	}
}
