import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.tidy.Tidy;

public class HtmlGenerator {

   HtmlGenerator(String outputFileName, Document document,String style)
   {
      try {
            ////////////////////////////////////////////////////////////////
            //BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));

            /*
            MDElementVisitor visitor = null;

            switch(style)
            {
            case "plain":
               visitor = new PlainVisitor();
               break;
            case "fancy":
               visitor = new FancyVisitor();
               break;
            case "slide":
               visitor = new SlideVisitor();
               break;
            }

            document.accept(visitor);
*/
            //out.write(document.elements.get(0).text); out.newLine();
            //out.write(s); out.newLine();
           BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
           String s="<p>My cat is very grumpy</p>";
           out.write(s); out.newLine();
			out.close();

           FileInputStream file = new FileInputStream(outputFileName);
           Tidy tidy = new Tidy();
           tidy.parse(file,System.out);

           if(tidy.getParseErrors() == 0)
                System.out.println("Valid html Syntax!");
           else
               System.out.println("Invalid html Syntax!");
           //file.close();

            ////////////////////////////////////////////////////////////////
          } catch (IOException e) {
              System.err.println(e); // 에러가 있다면 메시지 출력
              System.exit(1);
          }
   }


}