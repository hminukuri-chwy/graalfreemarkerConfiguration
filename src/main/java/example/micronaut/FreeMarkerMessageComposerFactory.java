package example.micronaut;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.Introspected;
import lombok.NonNull;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Factory
@Introspected
public class FreeMarkerMessageComposerFactory {
    private final String freemarkerTemplatePath;

    public FreeMarkerMessageComposerFactory(@NonNull @Value("${email.local.template.dir}") String freemarkerTemplatePath) {
        this.freemarkerTemplatePath = freemarkerTemplatePath;
    }

    @Singleton
    public Configuration freemarkerConfiguration() throws IOException {
        freemarker.template.Configuration configuration =
                new freemarker.template.Configuration(Configuration.VERSION_2_3_28);
        configuration.setDirectoryForTemplateLoading(new File(freemarkerTemplatePath));
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return  configuration;
    }
}


