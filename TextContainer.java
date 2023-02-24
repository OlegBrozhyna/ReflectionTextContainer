package HomeWork2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.awt.SystemColor.TEXT;

@SaveTo(path = "D:\\InfoContainer.txt ")
public class TextContainer {

    private final String text;

    public TextContainer(final String text) {
        this.text = text;
    }

    @Saver
    public void save(final String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(this.text);
        }
    }
}





