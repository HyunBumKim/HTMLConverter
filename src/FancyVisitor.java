
import java.util.ArrayList;

public class FancyVisitor implements MDElementVisitor {

	public FancyVisitor()
	{
		Document.HtmlStr +="<head>\n"
					+"\n<style type = text/css>"
					+"\n strong {color:red}"
					+"\n em {color:blue}"
					+"\n hr {border:yellow 2px dashed;}"
					+"\n #box1 {border:5px solid #D1F0E7; "
					+ "border-radius:10px;}"
					+ "\n #box2 {border:5px double #CCEEFF;"
					+ "border-radius:10px;}"
					+ "\nbody { background-image:url(back.png);}"
					+"\n #quotedBack {background-color : #CCCCCC}"
					+"\n #codeBox {background-color : #F0D1EE}"
					+"\n</style>"
					+"\n</head>"
					+"\n <body>";
	}
	
	public void visit(Header header)
	{
			
			String head = "<h"+ Integer.toString(header.level)+" style=\"color:lightblue\">";
			String end = "</h"+ Integer.toString(header.level)+">";
			Document.HtmlStr = Document.HtmlStr.substring(0,header.startIndex) + head+"\n"
					+ Document.HtmlStr.substring(header.startIndex)+end+"\n";
	
	}
	public void visit(PlainText plaintext)
	{
		Document.HtmlStr += plaintext.text ;
	}
	public void visit(StyleText styletext)
	   {
	      if(styletext.type==5)
	      {
	            Document.HtmlStr= Document.HtmlStr.substring(0, styletext.startIndex) + "<em>"
	                  + Document.HtmlStr.substring(styletext.startIndex) + "</em>";
	      }
	      else if(styletext.type==6)
	      {
	            Document.HtmlStr= Document.HtmlStr.substring(0, styletext.startIndex) + "<strong>"
	                  + Document.HtmlStr.substring(styletext.startIndex) + "</strong>";
	      }
	      else if(styletext.type==7)
	      {
	         Document.HtmlStr= Document.HtmlStr.substring(0, styletext.startIndex) + "<em><strong>"
	                  + Document.HtmlStr.substring(styletext.startIndex) + "</strong></em>";
	      }
	   }
	public void visit(Document document)
	{

	}
	public void visit(Node node)
	{
		
	}
    
	public void visit(Token token) {

	}
	public void visit(QuotedBlock quotedBlock)
	{
		Document.HtmlStr = Document.HtmlStr.substring(0,quotedBlock.startIndex) +"<blockquote id = \"quotedBack\">\n"
				+ Document.HtmlStr.substring(quotedBlock.startIndex)+"</blockquote>"+"\n";
	}

	public void visit(Horizonta horizonta)
	{
		Document.HtmlStr = Document.HtmlStr.substring(0,horizonta.startIndex)+"\n<hr>\n";
	}
	public void visit(CodeBlock codeBlock) {
		int i =0;
		
		for(i =0;i<codeBlock.contents.length();i++)
		{
			if(codeBlock.contents.charAt(i)=='&')
				codeBlock.contents = codeBlock.contents.substring(0,i)+"&amp;"+ codeBlock.contents.substring(i+1);
			if(codeBlock.contents.charAt(i)=='<')
				codeBlock.contents = codeBlock.contents.substring(0,i)+"&lt;"+ codeBlock.contents.substring(i+1);
			if(codeBlock.contents.charAt(i)=='>')
				codeBlock.contents = codeBlock.contents.substring(0,i)+"&gt;"+ codeBlock.contents.substring(i+1);
		}
		
		Document.HtmlStr = Document.HtmlStr.substring(0,codeBlock.startIndex)  +"<pre><code id= \"codeBox\">\n"
				+ codeBlock.contents+"</code></pre>\n";
		
	}
    public void visit(ItemList itemlist){
		      if(itemlist.IsOrdered==1){
		         
		         Document.HtmlStr = Document.HtmlStr.substring(0,itemlist.startIndex)
		        		 +"<ol id = \"box1\">\n"+Document.HtmlStr.substring(itemlist.startIndex)+"</ol>\n";
		      }
		      else
		         Document.HtmlStr = Document.HtmlStr.substring(0,itemlist.startIndex)
		         +"<ul id=\"box2\">\n"+Document.HtmlStr.substring(itemlist.startIndex)+"</ul>\n";
		      
		   }
	@Override
	public void visit(Link link) {
		Document.HtmlStr = Document.HtmlStr.substring(0,link.startIndex)+Document.HtmlStr.substring(link.startIndex);
		
	}
	@Override
	public void visit(Image image) {
		Document.HtmlStr = Document.HtmlStr.substring(0,image.startIndex)+image.linkElements;
	}
}
