
import java.util.ArrayList;

public class Node implements MDElement{
	public ArrayList<Token> tokenList;
	public String identity;
	public String str;
	
	public Node(String str)
	{
		this.str = str;
	}
	public Node create(String text)
	{
		return new Node();//수정필요
	}
	public void updateTokenList()
	{
		
	}
	public void accept(MDElementVisitor v)
	{
		
	}
}
