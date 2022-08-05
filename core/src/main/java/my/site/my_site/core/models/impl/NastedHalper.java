package my.site.my_site.core.models.impl;
import org.apache.sling.api.resource.Resource;

import java.util.Date;

public class NastedHalper {

    private String city;
    private String state;
    public NastedHalper(Resource resource){
        if(resource.getValueMap().get("city", String.class)!=null) {
            this.city= resource.getValueMap().get("city", String.class);
        }
        if(resource.getValueMap().get("state",String.class)!=null){
            this.state=resource.getValueMap().get("state",String.class);
        }

    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
}
