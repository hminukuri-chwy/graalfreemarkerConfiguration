package example.micronaut;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import lombok.NonNull;
import lombok.SneakyThrows;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Introspected
public class BookRequestHandler extends MicronautRequestHandler<Book, BookSaved> {  // <1>

    @Inject
    private BookService bookService;

    @SneakyThrows
    @Override
    public BookSaved execute(Book input)  {
        return bookService.save(input);
    }
}
