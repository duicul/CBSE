jar cfm ClientListener.jar ClientListener.mf org/extender/client/*.class
jar cfm MovieListerJSONListener.jar MovieListerJSONListener.mf org/extender/movielister/*.class
jar cfm MovieFinderWebListener.jar MovieFinderWebListener.mf org/extender/moviefinder/web/*.class
jar cfm MovieFinderDataBaseListener.jar MovieFinderDataBaseListener.mf org/extender/moviefinder/database/*.class
jar cfm Client.jar Client.mf org/rawservice/client/*.class
jar cfm MovieListerJSON.jar MovieListerJSON.mf org/rawservice/movielister/*.class
jar cfm MovieFinderWeb.jar MovieFinderWeb.mf org/rawservice/moviefinder/web/*.class
jar cfm MovieFinderDataBase.jar MovieFinderDataBase.mf org/rawservice/moviefinder/database/*.class
java -jar org.eclipse.osgi_3.15.0.v20190830-1434.jar  -console