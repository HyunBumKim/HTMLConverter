
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
		this.text = (ArrayList<String>)text.clone();//수정필요
		this.elements = new ArrayList<MDElement>();
		
		System.out.println("---------------elements----------"+text.size());
		int i =0;
		for(i=0;i<text.size();i++)
			System.out.println("elements"+i+"번째"+text.get(i));
		System.out.println("------------------------------------"+text.size());
		
		(new MDParser()).FirstTextParser(this.text,this.elements);
		
		
		
	}
	public Node()
	{
		
	}
	public void updateTokenList()
	{
		
	}
	
	public void accept(MDElementVisitor v)
	{
		
		startIndex = Document.HtmlStr.length();
		if(this.elements != null)
		{
			System.out.println("Node");
			for(MDElement element : this.elements)
			{
				element.accept(v);
			}
			v.visit(this);
		}
	}
}
