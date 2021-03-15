package example.micronaut;

import freemarker.template.Template;
import io.micronaut.function.aws.MicronautRequestHandler;
import lombok.NonNull;
import lombok.SneakyThrows;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class BookService {
    private FreeMarkerMessageComposerFactory freeMarkerMessageComposerFactory;

    public BookService(@NonNull FreeMarkerMessageComposerFactory freeMarkerMessageComposerFactory) {
        this.freeMarkerMessageComposerFactory = freeMarkerMessageComposerFactory;
    }

    @SneakyThrows
    public BookSaved save(Book input)  {
        boolean exists  = freeMarkerMessageComposerFactory.freemarkerConfiguration().isTemplateLoaderExplicitlySet();

        BookSaved bookSaved = new BookSaved();
        bookSaved.setName(input.getName());
        bookSaved.setIsbn(UUID.randomUUID().toString());
        return bookSaved;
    }
}

