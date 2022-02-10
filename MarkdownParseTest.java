import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks1() throws IOException{
        Path fileName = Path.of("test2.md");
	    String contents = Files.readString(fileName);
        assertEquals( List.of("link.com"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinks2() throws IOException{
        Path fileName = Path.of("test3.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("", "link.com"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinks3() throws IOException{
        Path fileName = Path.of("test4.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
   
}
//comments


/* import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.*;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html"));
    }
    @Test
    public void getLinksTwo() throws IOException{
        Path fileName = Path.of("test2.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("link.com"));
    }
} */
