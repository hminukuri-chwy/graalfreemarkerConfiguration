package example.micronaut;

import com.amazonaws.services.lambda.runtime.Context;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Introspected
public class BookRequestStreamHandler extends MicronautRequestStreamHandler {

    @Override
    protected void execute(InputStream input, OutputStream output, Context context) throws IOException {
        System.out.println("In BookRequestStreamHandler");
        super.execute(input, output, context);
    }
}
