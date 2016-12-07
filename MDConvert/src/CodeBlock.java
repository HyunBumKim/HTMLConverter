
public class CodeBlock extends Node{
	public String contents;
	public CodeBlock(String contents) {
		super(null);
		this.contents = new String();
		this.contents = contents; 
		
	}
	public void accept(MDElementVisitor v)
	{
		startIndex = Document.HtmlStr.length();
		v.visit(this);
		
	}
}
