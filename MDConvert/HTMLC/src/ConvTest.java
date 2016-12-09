import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConvTest {

	@Test
	public void testSimple1() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+"aaaaa\n"+	"<blockquote>\n"+
				"block\n"+	"</blockquote>\n"+		"<head>\n"+		"<strong>HTMLConverter</strong></head>\n"+
				"<h3>\n"+	"header</h3>\n\n"+		"<hr />\n"+		"<blockquote>\n"+	" quoted block\n"+
				"quoted block nested\n"+	"gkgkgkgkg\n"+		"</blockquote>\n"+		"<pre><code>\n"+
				"code block\n"+		"code block\n"+		"</pre></code>\n"+	"ssssssss\n"+	"<pre><code>\n"+
				"code block\n\n"+		"code block1\n"+		"</pre></code>\n";
		MDParser parser = new MDParser();
		Document document = new Document("test.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple2() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+"<strong>HTMLConverter</strong><strong>*asdf</strong>";
		MDParser parser = new MDParser();
		Document document = new Document("test1.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test1.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple3() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+
						"<strong>HTMLConverter</strong><em>*asdf</em>s*d\n";
		MDParser parser = new MDParser();
		Document document = new Document("test2.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test2.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple4() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+"<em><strong>HTMLConverter</strong></em><em><strong>sdf</strong></em>";
		MDParser parser = new MDParser();
		Document document = new Document("test3.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test3.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple5() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+"<em><strong>sdf</strong></em>sdf<strong>wer</strong>s<em>c</em>s\n";
		MDParser parser = new MDParser();
		Document document = new Document("test4.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test4.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple6() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+"<em><strong>sdf</strong></em>";
		MDParser parser = new MDParser();
		Document document = new Document("test5.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test5.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple7() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"+"<em>s</em>";
		MDParser parser = new MDParser();
		Document document = new Document("test6.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test6.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	
	@Test
	public void testSimple8() {
		String expContents="";
		expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"
						+"<em>s</em>f<strong>*sdf</strong>sd<em>*sd</em>";
		MDParser parser = new MDParser();
		Document document = new Document("test7.md", parser);
		HtmlGenerator converter = new HtmlGenerator("test7.html",document,"plain");
		assertEquals(expContents,converter.result);
	}
	@Test
	public void testSimple9(){
		  String expContents="";
	      expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"
	    		+ "<head>\nabcd\n</head>\n"
	            + "<ul>\n<li>asbc</li>\n<li>fdsafds</li>\n<li>fdsafdsa</li>\n"
	            + "</ul>\n<ol>\n<li>435243</li>\n<li>fdsaf</li>\n"
	            + "<li>fder45y6</li>\n<li>fafdsf</li>\n</ol>\n\n"
	            + "<hr />\n<h2>\nabcd\n</h2>\n<blockquote>\n 1234\n abcd\n"
	            + " 12345\n</blockquote>\n"
	            + "<pre><code>\ncode\n{\nhere is code\n}\n"
	            + "</pre></code>\n";
	      MDParser parser = new MDParser();
	      Document document = new Document("test9.md", parser);
	      HtmlGenerator converter = new HtmlGenerator("test9.html",document,"plain");
	      assertEquals(expContents,converter.result);
	   }
	
	@Test
	public void testSimple10(){
		  String expContents="";
	      expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"
	    		  +"abcd 1234\n"
	    		  +"<img scr = \"image_route\"  alt = \"image\" tyle = \"image title\">\n"
	    		  +"abcd 1234\n"
	    		  +"<img scr = \"image_route \"\"\"  alt = \"image\">\n";
	      MDParser parser = new MDParser();
	      Document document = new Document("test10.md", parser);
	      HtmlGenerator converter = new HtmlGenerator("test10.html",document,"plain");
	      assertEquals(expContents,converter.result);
	   }
	
	@Test
	public void testSimple11(){
		  String expContents="";
	      expContents="<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n<html>\n"
	    		  +"<h4>\nsadf</h4>\n";
	      MDParser parser = new MDParser();
	      Document document = new Document("test11.md", parser);
	      HtmlGenerator converter = new HtmlGenerator("test11.html",document,"plain");
	      assertEquals(expContents,converter.result);
	   }
	
	public static void main(String [] args) {
		ConvTest test = new ConvTest();
		test.testSimple1();
		test.testSimple2();
		test.testSimple3();
		test.testSimple4();
		test.testSimple5();
		test.testSimple6();
		test.testSimple7();
		test.testSimple8();
		test.testSimple9();
		test.testSimple10();
		test.testSimple11();
	}
}
