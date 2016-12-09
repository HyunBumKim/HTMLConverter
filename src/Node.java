
import java.util.ArrayList;

public class Node implements MDElement{
	public String identity;
	public ArrayList<String> text;
	public ArrayList<MDElement> elements;
	public int startIndex;
	public int type;
	
	@SuppressWarnings("unchecked")
	public Node(ArrayList<String> text)
	{	
		this.elements = new ArrayList<MDElement>();
		
		if(text !=null)
		{
		this.text = (ArrayList<String>)text.clone();

		if(elements!=null)
			(new MDParser()).FirstTextParser(this.text,this.elements);
		
		}
		
	}
	public Node()
	{
		text =new ArrayList<String>();
		elements =new  ArrayList<MDElement>();
	}
	
	public void updateTokenList()
	{
		
	}
	
	public void accept(MDElementVisitor v)
	{
		
		startIndex = Document.HtmlStr.length();
		if(this.elements != null)
		{

			for(MDElement element : this.elements)
			{
				element.accept(v);
			}
			v.visit(this);
		}
	}
}
