package org.extender.movielister;

import java.util.List;

public interface MovieLister {
  public String display(MovieFinder mf);
  public String display(List<MovieFinder> mf);
}
