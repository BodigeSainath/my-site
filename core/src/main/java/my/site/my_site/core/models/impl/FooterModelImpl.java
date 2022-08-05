package my.site.my_site.core.models.impl;

import my.site.my_site.core.models.FooterModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = FooterModel.class)
public class FooterModelImpl implements FooterModel {
    @ValueMapValue
    private String text;
    @ValueMapValue
    private  String description;
    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
