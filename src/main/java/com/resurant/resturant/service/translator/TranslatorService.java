package com.resurant.resturant.service.translator;

import com.resurant.resturant.model.BundleMessageModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TranslatorService {
static ResourceBundleMessageSource resourceBundleMessageSource;
TranslatorService(@Qualifier("messages") ResourceBundleMessageSource resourceBundleMessageSource){
    this.resourceBundleMessageSource =resourceBundleMessageSource;
}
public static BundleMessageModel getMessageInArAndEn(String code){
    return new BundleMessageModel
            (resourceBundleMessageSource.getMessage(code,null,new Locale("ar")),
                    resourceBundleMessageSource.getMessage(code,null,new Locale("en"))
                    );
}




}
