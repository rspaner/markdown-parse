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
    @Test 
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("snippet-1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("google.com", "ucsd.edu"), MarkdownParse.getLinks(contents));
    }
    @Test 
    public void testSnippet2() throws IOException{ 
        Path fileName = Path.of("snippet-2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com","example.com"), MarkdownParse.getLinks(contents));
    }

        
    @Test 
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("snippet-3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), MarkdownParse.getLinks(contents));
    }
    
}

