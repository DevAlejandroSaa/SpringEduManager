package cl.edu.core.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18nConfig {

    @Value("${spring.web.locale:es_CL}")
    private String defaultLocale;

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasenames("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(parseLocale(defaultLocale));
        messageSource.setFallbackToSystemLocale(false);

        return messageSource;
    }

    public String getMessage(String key) {
        return messageSource().getMessage(key, null, parseLocale(defaultLocale));
    }

    private Locale parseLocale(String locale) {
        return Locale.forLanguageTag(locale.replace('_', '-'));
    }

}
