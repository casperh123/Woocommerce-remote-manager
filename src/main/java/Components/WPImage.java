package Components;

import com.jsoniter.annotation.JsonCreator;
import com.jsoniter.annotation.JsonIgnore;
import com.jsoniter.annotation.JsonProperty;
import javafx.scene.image.Image;

public class WPImage extends AbstractComponent {

    private String alt;

    private String src;

    //Read-Only
    @JsonProperty("date_created")
    private String dateCreated;

    //Read-Only
    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;

    //Read-Only
    @JsonProperty("date_modified")
    private String dateModified;

    //Read-Only
    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;

    @JsonIgnore
    private Image image;

    @JsonCreator
    public WPImage() {
    }

    public WPImage(int id,
                   String name,
                   String alt,
                   String src,
                   String dateCreated,
                   String dateCreatedGmt,
                   String dateModified,
                   String dateModifiedGmt) {
        this.id = id;
        this.name = name;
        this.alt = alt;
        this.src = src;
        this.dateCreated = dateCreated;
        this.dateCreatedGmt = dateCreatedGmt;
        this.dateModified = dateModified;
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public int getId() {
        return id;
    }

    public String getAlt() {
        return alt;
    }

    public String getSrc() {
        return src;
    }

    public String getDateCreated() {
        return dateCreated;
    }
    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }
    public String getDateModified() {
        return dateModified;
    }
    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }
    public String getImageUrl() {
        return src;
    }

    public Image getImage() {
        if(image == null && src != null) {
            image = new Image(src, 300, 300, true, true, true);
        }
        return image;
    }

    public String toString() {
        return "Image \n" +
                "ID: " + id + " Date created: " + dateCreated;
    }
}
