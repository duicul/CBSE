package org.movielister;

import org.moviefinder.MovieFinder;

public interface MovieLister {
  public String display();

public void bindFinder(MovieFinder finder);

public void unbindFinder(MovieFinder finder);
}
