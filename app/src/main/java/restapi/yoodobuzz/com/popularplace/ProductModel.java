package restapi.yoodobuzz.com.popularplace;

import java.util.ArrayList;

public class ProductModel {
    private String pname;

     String area;

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    ArrayList<String>image;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }



    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


}
