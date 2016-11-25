
import java.util.ArrayList;

public class Node implements MDElement{
	public ArrayList<Token> tokenList;
	public String identity;
	public String text;
	
	public Node(String text)
	{
		tokenList =new ArrayList<Token>();
		this.text = text;//수정필요
	}
	public void updateTokenList()
	{
		
	}
	public void accept(MDElementVisitor v)
	{
		for(Token element : this.tokenList)
		{
			element.accept(v);
		}
		v.visit(this);
	}
}
