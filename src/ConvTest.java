import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConvTest {
   String expContents="";

   @Test
   public void testSimple1() {
	   /*+ asbc
	   - fdsafds
	   * fdsafdsa
	   */
      expContents="<ul>\n"
      		+ "<li>asbc</li>\n"
      		+ "<li>fdsafds</li>\n"
      		+ "<li>fdsafdsa</li>\n"
      		+ "</ul>";
      MDParser parser = new MDParser();
      Document document = new Document("test.md", parser);
      HtmlGenerator converter = new HtmlGenerator("test.html",document,"plain");
      assertEquals(expContents,converter.result);
      
   }
   
   @Test
   public void testSimple2(){
	   /*1. 435243
		2. fdsaf
		3. fder45y6
		34. fafdsf
		*/
	   
	   expContents="<ol>\n"
	   		+ "<li>435243</li>\n"
	   		+ "<li>fdsaf</li>\n"
	   		+ "<li>fder45y6</li>\n"
	   		+ "<li>fafdsf</li>\n"
	   		+ "</ol>";
       MDParser parser = new MDParser();
       Document document = new Document("test.md", parser);
       HtmlGenerator converter = new HtmlGenerator("test.html",document,"plain");
       assertEquals(expContents,converter.result);
   }
   
   @Test
   public void testSimple3(){
	   expContents="<header>\nabcd\n</header>\n"
	   		+ "<ul>\n<li>asbc</li>\n<li>fdsafds</li>\n<li>fdsafdsa</li>\n"
	   		+ "</ul>\n<ol>\n<li>435243</li>\n<li>fdsaf</li>\n"
	   		+ "<li>fder45y6</li>\n<li>fafdsf</li>\n</ol>\n"
	   		+ "<hr />\n<h2>\nabcd\n</h2>\n<blockquote>\n 1234\n abcd\n"
	   		+ " 12345\n</blockquote>";
	   MDParser parser = new MDParser();
	   Document document = new Document("test.md", parser);
	   HtmlGenerator converter = new HtmlGenerator("test.html",document,"plain");
	   assertEquals(expContents,converter.result);
   }
   
   public static void main(String [] args) {
      ConvTest test = new ConvTest();
      test.testSimple3();
   }
}