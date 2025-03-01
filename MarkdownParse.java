// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {  
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            
            System.out.println(currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if (nextCloseBracket + 1 == openParen && (nextOpenBracket == 0|| markdown.charAt(nextOpenBracket - 1) != '!' )) {
            //&& //markdown.charAt(nextOpenBracket - 1) != '`' )) {

                toReturn.add(markdown.substring(openParen + 1, closeParen));
                int whiteSpace =  markdown.indexOf(" ", openParen);
                //int backtick = markdown.indexOf("`", openParen);
                //int nestedParen = markdown.indexOf("(", openParen+1);
                        for (int i = openParen; i < closeParen; ++i){
                            if (whiteSpace == i ){
                            //|| nestedParen == i 
                            //|| backtick == i) {
                                toReturn.remove(markdown.substring(openParen + 1, closeParen));

                            }
                
                        }
                        //}
                        
                    }

            currentIndex = closeParen + 1;
            System.out.println(currentIndex);
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
      
    }
}
