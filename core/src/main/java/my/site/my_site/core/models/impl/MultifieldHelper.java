package my.site.my_site.core.models.impl;

import my.site.my_site.core.models.impl.MultiFieldModelImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class MultifieldHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);
    private String name;
    private String city,state;


    private List<NastedHalper> detailsWithNastedMultifield;
    public MultifieldHelper(Resource resource){
        try {
            if(StringUtils.isNotBlank(resource.getValueMap().get("name", String.class))) {
                this.name = resource.getValueMap().get("name", String.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("city", String.class))) {
                this.city = resource.getValueMap().get("city", String.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("state", String.class))) {
                this.state = resource.getValueMap().get("state", String.class);
            }


        }catch (Exception e){
            LOG.info("\n BEAN ERROR : {}",e.getMessage());
        }

    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public List<NastedHalper> getDetailsWithNastedMultifield() {
        return detailsWithNastedMultifield;
    }

    public void setDetailsWithNastedMultifield(List<NastedHalper> detailsWithNastedMultifield) {
        this.detailsWithNastedMultifield = detailsWithNastedMultifield;
    }

     //  public List<NastedHalper> getBookEditons() {
//        return bookEditons;
//    }
//
//    public void setBookEditons(List<NastedHalper> bookEditons) {
//        this.bookEditons = bookEditons;
//    }
}