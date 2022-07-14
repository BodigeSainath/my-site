package my.site.my_site.core.models.impl;

import my.site.my_site.core.models.MultiFieldModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},adapters = MultiFieldModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class MultiFieldModelImpl implements MultiFieldModel {
    private static final Logger logger= LoggerFactory.getLogger(MultiFieldModelImpl.class);
    @Inject
    Resource resource;
    @Override
    public List<Map<String, String>> getMultiFieldDetailsWithMap() {
        List<Map<String, String>> detailsMap=new ArrayList<>();
        try {
            Resource detail=resource.getChild("multifielddetailswithmap");
            if(detail!=null){
                for (Resource res : detail.getChildren()) {
                    Map<String,String> map=new HashMap<>();
                    map.put("label",res.getValueMap().get("label",String.class));
                    map.put("link",res.getValueMap().get("link",String.class));
                    detailsMap.add(map);
                }
            }
        }catch (Exception e){
            logger.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        logger.info("\n SIZE {} ",detailsMap.size());
        return detailsMap;
    }

    public List<MultifieldHelper> getDetailsWithBean(){
        List<MultifieldHelper> detailsBean=new ArrayList<>();
        try {
            Resource resourceBean=resource.getChild("detailswithbean");
            if(resourceBean!=null){
                for (Resource bookBean : resourceBean.getChildren()) {
//                    LOG.info("\n PATH Bean {} ",bookBean.getPath());
//                    LOG.info("\n BEAN PRO {} ",bookBean.getValueMap().get("bookname",String.class));

                    detailsBean.add(new MultifieldHelper(bookBean));
                }
            }
        }catch (Exception e){
            logger.info("\n ERROR while getting Book Details With Bean {} ",e.getMessage());
        }
        return detailsBean;
    }

    public List<MultifieldHelper> getDetailsWithNastedMultifield() {
        List<MultifieldHelper> detailsNasted=new ArrayList<>();
        try {
            Resource resourceNasted=resource.getChild("detailswithnastedmultifield");
            if(resourceNasted!=null){
                for (Resource bookNasted : resourceNasted.getChildren()) {
                    MultifieldHelper multifieldHelper=new MultifieldHelper(bookNasted);
                    if(bookNasted.hasChildren()){
                        List<NastedHalper> bookNastedList=new ArrayList<>();
                        Resource nastedResource=bookNasted.getChild("detailswithnastedmultifield");
                        for(Resource nasted : nastedResource.getChildren()){
                            bookNastedList.add(new NastedHalper(nasted));
                        }
                        multifieldHelper.setDetailsWithNastedMultifield(bookNastedList);
                    }
                    detailsNasted.add(multifieldHelper);
                }
            }
        }catch (Exception e){
            logger.info("\n ERROR while getting Book Details With Nasted Multifield {} ",e.getMessage());
        }
        logger.info("\n SIZE Multifield {} ",detailsNasted.size());
        return detailsNasted;
    }
}
