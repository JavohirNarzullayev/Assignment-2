package Model;

public class Photo {
 private String id;
 private String secret;
 private String server;
 private String farm;
 private int per_page;
 private String title;
    static String linkToReplace = "https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg";


    public Photo(){
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }
    public int getPer_page() {
        return per_page;
    }

    public String links(){
            String link = Photo.linkToReplace;
            link = link.replace("{farm-id}", getFarm());
            link = link.replace("{server-id}", getServer());
            link = link.replace("{id}", getId());
            link = link.replace("{secret}", getSecret());
            return link;
        }





    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", secret=" + secret +
                ", server=" + server +
                ", farm=" + farm +
                ", perpage=" + per_page +
                ", perpage=" + title +
                '}';
    }}



