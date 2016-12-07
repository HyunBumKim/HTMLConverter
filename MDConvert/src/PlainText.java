import java.util.ArrayList;

public class PlainText extends Token {
	String text;
	
    public PlainText(String text) {
		super(null);
		this.text = text;
		type = 1;
	}

	public void accept(MDElementVisitor v)
	{
		startIndex = Document.HtmlStr.length();
		
		v.visit(this);
	
	}
}
