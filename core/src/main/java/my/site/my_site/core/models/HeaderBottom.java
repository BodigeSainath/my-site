package my.site.my_site.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderBottom {
    @SlingObject
    Resource resource;
    @SlingObject
    ResourceResolver resourceResolver;

    private static final Logger log= LoggerFactory.getLogger(HeaderBottom.class);

    public Iterator<Page> getPages(){
        //ResourceResolver resourceResolver= ResolverUtil.newResolver(resourceResolverFactory);
        PageManager pageManager=resourceResolver.adaptTo(PageManager.class);
        Page page=pageManager.getPage("/content/we-retail/language-masters/en/experience");
        Iterator<Page> pages=page.listChildren();
        return pages;

    }
}
