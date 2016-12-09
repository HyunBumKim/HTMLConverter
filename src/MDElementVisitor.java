
public interface MDElementVisitor {
	public void visit(Node node);
	public void visit(Header header);
	public void visit(PlainText plaintext);
	public void visit(StyleText styletext);
	public void visit(QuotedBlock quotedBlock);
	//...and so on...>>
	public void visit(Document document);
	//public void visit(Token token);
	public void visit(Token token);
	public void visit(Horizonta horizonta);
	public void visit(CodeBlock codeBlock);
	public void visit(ItemList itemlist);
	public void visit(Link link);
	public void visit(Image image);
}
