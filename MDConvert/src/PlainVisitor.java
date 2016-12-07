import java.util.ArrayList;

public class PlainVisitor implements MDElementVisitor {
	
	public void visit(Header header)
	{
		if(header.level == 0)
		{
			Document.HtmlStr = Document.HtmlStr.substring(0,header.startIndex) +"<header>\n"
					+ Document.HtmlStr.substring(header.startIndex)+"</header>"+"\n";
		}
		else 
		{
			String head = "<h"+ Integer.toString(header.level)+">";
			String end = "</h"+ Integer.toString(header.level)+">";
			Document.HtmlStr = Document.HtmlStr.substring(0,header.startIndex) + head+"\n"
					+ Document.HtmlStr.substring(header.startIndex)+end+"\n";
		}
	}
	public void visit(PlainText plaintext)
	{
		Document.HtmlStr += plaintext.text ;
	}
	public void visit(StyleText styletext)
	   {
	      System.out.println("visit style");
	      if(styletext.type==5){
	    	  
	         if(Document.HtmlStr.isEmpty()){
	            Document.HtmlStr= "<em>" + Document.HtmlStr.substring(0, styletext.startIndex) + "</em>";
	         }else{
	            Document.HtmlStr= Document.HtmlStr.substring(0, styletext.startIndex) + "<em>"
	                  + Document.HtmlStr.substring(styletext.startIndex) + "</em>";
	         }
	      }else if(styletext.type==6){
	         if(Document.HtmlStr.isEmpty()){
	            Document.HtmlStr= "<strong>" + Document.HtmlStr.substring(0, styletext.startIndex) + "</strong>";
	         }
	         else{
	            Document.HtmlStr= Document.HtmlStr.substring(0, styletext.startIndex) + "<strong>"
	                  + Document.HtmlStr.substring(styletext.startIndex) + "</strong>";
	         }
	      }else if(styletext.type==7){
	         if(Document.HtmlStr.isEmpty()){
	            Document.HtmlStr= "<em><strong>" + Document.HtmlStr.substring(0, styletext.startIndex) + "</em></strong>";
	         }
	         else{
	            Document.HtmlStr= Document.HtmlStr.substring(0, styletext.startIndex) + "<em><strong>"
	                  + Document.HtmlStr.substring(styletext.startIndex) + "</strong></em>";
	         }
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
		Document.HtmlStr = Document.HtmlStr.substring(0,quotedBlock.startIndex) +"<blockquote>\n"
				+ Document.HtmlStr.substring(quotedBlock.startIndex)+"</blockquote>"+"\n";
	}
	public void visit(Horizonta horizonta)
	{
		Document.HtmlStr = Document.HtmlStr.substring(0,horizonta.startIndex)+"\n<hr />\n";
	}
	@Override
	public void visit(CodeBlock codeBlock) {
		Document.HtmlStr = Document.HtmlStr.substring(0,codeBlock.startIndex)  +"<pre><code>\n"
				+ codeBlock.contents+"</pre></code>\n";
		
	}
	
}
