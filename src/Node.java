
import java.util.ArrayList;

public class Node implements MDElement{
	public ArrayList<Token> tokenList;
	public String identity;
	
	public Node create(String text)
	{
		return new Node();//�����ʿ�
	}
	public void updateTokenList()
	{
		
	}
	public void accept(MDElementVisitor v)
	{
		
	}
}
