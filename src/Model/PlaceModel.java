package Model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by Saint on 11/12/2015.
 */
public class PlaceModel implements Comparable<PlaceModel>{
    private String id;
    private String name;
    private int act;
    private int type;
    private String region;
    private String province;
    private String address;
    private String imgUrl;
    private String product;
    private int[] date;
    public int hits;
    private String contactNumber;

    public PlaceModel(String id, String name, int act, int type, String region, String province, String address, String product, String imgUrl, String contactNumber, int[] date) {
        this.id = id;
        this.name = name;
        this.act = act;
        this.type = type;
        this.date = date;
        this.region = region;
        this.province = province;
        this.address = address;
        this.imgUrl = imgUrl;
        this.product = product;
        this.hits = 0;
        this.contactNumber = contactNumber;
    }

    public int getAct(){return this.act;}
    public int getType(){return this.type;}
    public int[] getDate(){return this.date;}
    public String getName() {
        return name;
    }

    public JSONObject getJsonObject(){
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("name", this.name);
            json.put("act", this.act);
            json.put("type", this.type);
            String dates = "";
            for(int d : this.date) dates = dates+d+", ";
            json.put("month", dates);
            json.put("region", this.region);
            json.put("province", this.province);
            json.put("address", this.address);
            json.put("imgUrl", this.imgUrl);
            json.put("product", this.product);
        }
        catch(JSONException e){
            System.out.println(e);
        }
        return json;
    }

    @Override
    public int compareTo(PlaceModel o) {
        if (this.hits < o.hits){
            return -1;
        }else{
            return 1;
        }

    }
}