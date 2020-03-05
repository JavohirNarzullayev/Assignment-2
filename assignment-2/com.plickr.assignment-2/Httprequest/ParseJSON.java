package Httprequest;
import Model.Photo;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public  class ParseJSON {
    static final String GLOBAL_URL="https://www.flickr.com/services/rest/?method=flickr.photos.search&";
    static final String API_KEY="api_key=d467727dc5c2918763fdceddc1b41855&tags=";
    static final String FORMAT="&format=json&nojsoncallback=1";

    public static Photo[] parseJSON(String tags) throws MalformedURLException {
    URL url=new URL(GLOBAL_URL+API_KEY+tags+FORMAT);
      try {
          System.out.println(url);
          HttpURLConnection connection=(HttpURLConnection)url.openConnection();
          connection.setRequestMethod("GET");
          connection.connect();
          BufferedReader json=new BufferedReader(new InputStreamReader(connection.getInputStream()));
          String line=json.readLine();
          json.close();
          //For pages or perpages for photo
          JsonElement pickets = new JsonParser().parse(line);
          JsonObject main= pickets.getAsJsonObject();
          JsonElement photo = main.getAsJsonObject("photos");
          //For link photo
          JsonArray anaphora = photo.getAsJsonObject().get("photo").getAsJsonArray();
          Photo[] photos = new Photo[anaphora.size()];
          //response photos array
            for(int i = 0; i < anaphora.size(); i++){
              String id=anaphora.get(i).getAsJsonObject().get("id").getAsString();
              String secret = anaphora.get(i).getAsJsonObject().get("secret").getAsString();
              String server=anaphora.get(i).getAsJsonObject().get("server").getAsString();
              String farm = anaphora.get(i).getAsJsonObject().get("farm").getAsString();
              String title=anaphora.get(i).getAsJsonObject().get("title").getAsString();
              int per_page=anaphora.size();
              photos[i] = new Photo();
              photos[i].setId(id);
              photos[i].setFarm(farm);
              photos[i].setServer(server);
              photos[i].setSecret(secret);
              photos[i].setPer_page(per_page);
              photos[i].setTitle(title);
              System.out.println(photos[i].toString());
          }
              return photos;//return photos array
          //add items property for photo link
            } catch (IOException e) {
             e.printStackTrace();
         }
       return null;
    }
}
