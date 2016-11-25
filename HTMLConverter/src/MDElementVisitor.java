
public interface MDElementVisitor {
	public void visit(Node node);
	public void visit(Header header);
	public void visit(PlainText plaintext);
	public void visit(StyleText styletext);
	//...and so on...>>
	public void visit(Document document);
	//public void visit(Token token);
	public void visit(Token token);
}
