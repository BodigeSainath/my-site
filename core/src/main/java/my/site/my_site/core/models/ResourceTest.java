package my.site.my_site.core.models;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.osgi.service.component.annotations.Component;

@Component(service = ResourceTest.class)
public class ResourceTest {
    @ScriptVariable
    ResourceResolver resourceResolver;
    @ScriptVariable
    Resource resource=resourceResolver.getResource("/content/mysite/language-masters/home-page/jcr:content");
    ValueMap valueMap1=resource.adaptTo(ValueMap.class);
    String title=valueMap1.get(JcrConstants.JCR_TITLE,String.class);
    String resPath=valueMap1.get(JcrConstants.JCR_PATH,String.class);
    String create=valueMap1.get(JcrConstants.JCR_CREATED_BY,String.class);

    public String getTitle() {
        return title;
    }

    public String getResPath() {
        return resPath;
    }

    public String getCreate() {
        return create;
    }

    String pat=resource.getValueMap().get(JcrConstants.JCR_TITLE,String.class);

    PageManager pageManager=resourceResolver.adaptTo(PageManager.class);
    Page page=pageManager.getPage("/content/mysite/language-masters/home-page/jcr:content");
    String res=page.getProperties().get(JcrConstants.JCR_NAME,String.class);
  String valueMap=page.getProperties().get(JcrConstants.JCR_PATH,String.class);

    public String getRes() {
        return res;
    }

    public String getValueMap() {
        return valueMap;
    }

    public String getPat() {
        return pat;
    }
}
