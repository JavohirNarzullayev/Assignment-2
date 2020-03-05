package Controller;

import Httprequest.ParseJSON;
import Model.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Objects;

public class PhotoController {
    // view elements
    Photo[] photos;// array Photos with link
    @FXML
    TextField searchField;
    @FXML
    ImageView imageView;
    @FXML
    ImageView loaderImageView;
    @FXML
    Button prevButton;
    @FXML
    Button nextButton;
    @FXML
    Label title;
    @FXML
    Label counter;
    Integer nowpage;//Currently page
    HashMap<Integer,Image> cache;

    @FXML
    private void searchImage() {
        System.out.println(" search button clicked ");
        try {

            photos = ParseJSON.parseJSON(searchField.getText().toLowerCase().trim().replace(" ",""));
            assert photos != null;
            nowpage=1;
            Image img=new Image(photos[0].links());
            cache=new HashMap<>();
            if (!cache.containsKey(nowpage)){
                cache.put(nowpage-1,img);
                imageView.setImage(img);
            }else {
                imageView.setImage(cache.get(nowpage));
            }
            title.setText(Objects.requireNonNull(photos)[0].getTitle());
            counter.setText(nowpage+"/"+ photos[0].getPer_page());
            prevButton.setDisable(false);
            nextButton.setDisable(false);
        } catch (MalformedURLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void nextImage() {
        System.out.println(" next button clicked ");

        if (nowpage!=-1&& photos[0].getPer_page()>=nowpage){
            nowpage++;

            counter.setText(nowpage+"/"+ photos[0].getPer_page());
            if (!cache.containsKey(nowpage)) {
                Image img=new Image(photos[nowpage].links());
                cache.put(nowpage,img);
                imageView.setImage(img);
            } else {
                imageView.setImage(cache.get(nowpage));
                System.out.println("caching...");

            }

            title.setText(photos[nowpage].getTitle());

    }}



    @FXML
    public void prevImage() {
        System.out.println(" prev button clicked ");
        if (nowpage!=1&& photos[0].getPer_page()>=nowpage){
            --nowpage;
        }
        if (cache.containsKey(nowpage)){
            imageView.setImage(cache.get(nowpage));
            System.out.println("caching...");
        }else {
            Image img=new Image(photos[nowpage].links());
            cache.put(nowpage,img);
            imageView.setImage(img);
        }

        counter.setText(nowpage+"/"+ photos.length);
            title.setText(photos[nowpage].getTitle());
    }



}