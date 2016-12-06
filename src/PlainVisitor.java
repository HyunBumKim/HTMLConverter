
public class PlainVisitor implements MDElementVisitor {
	
	public void visit(Header header)
	{
		System.out.println("visit header");
		if(header.level == 0)
			Document.HtmlStr = Document.HtmlStr.substring(0,header.startIndex) + "<header>"
					+ Document.HtmlStr.substring(header.startIndex)+"</header>";
			
	}
	public void visit(PlainText plaintext)
	{
		System.out.println("visit PlainText");
		Document.HtmlStr += plaintext.text ;
	}
	public void visit(StyleText styletext)
	{
		
	}
	public void visit(Document document)
	{
		System.out.println("visit docuemnt ");
	}
	public void visit(Node node)
	{
		
	}
    
	public void visit(Token token) {
	
		System.out.println("visit token");
	}
	public void visit(QuotedBlock quotedBlock)
	{
		System.out.println("visit PlainText");
		Document.HtmlStr = Document.HtmlStr.substring(0,quotedBlock.startIndex) + "<blockquote>"
				+ Document.HtmlStr.substring(quotedBlock.startIndex)+"</blockquote>";
	}
	public void visit(Horizonta horizonta)
	{
		Document.HtmlStr +="\n<hr />\n";
	}
	
}
