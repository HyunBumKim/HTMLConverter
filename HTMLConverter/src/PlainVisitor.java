
public class PlainVisitor implements MDElementVisitor {
	public void visit(Header header)
	{
		if(header.level == 0)
			header.text = "<header>"+header.text +"</header>";
		else
			header.text = "<h"+String.valueOf(header.level)+">" + header.text +"</h"+String.valueOf(header.level)+">";
	}
	public void visit(PlainText plaintext)
	{
		
	}
	public void visit(StyleText styletext)
	{
		
	}
	public void visit(Document document)
	{
		
	}
	public void visit(Node node)
	{
		
	}

	public void visit(Token token) {
	
		
	}
}
