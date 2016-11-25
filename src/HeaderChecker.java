
public class HeaderChecker {

	public int headerLevel;
	public String text;
	
	public HeaderChecker(String text)
	{
		int i =0;
		for(i=1;i<text.length();i++)
		{
			if(text.charAt(0)==text.charAt(i))
			{
				headerLevel = i;
			}
			else
			{
				headerLevel++;
				break;
			}
		}
		
		text = new String(createHeaderText(text));
	}
	public String createHeaderText(String text)
	{
		String str = text;
		int i =0;
		
		for(i =text.length()-1 ;i >0 ; i--)
		{
			if(text.charAt(i)!=text.charAt(0))
			{
				break;
			}
		}
		
		return str.substring(this.headerLevel, i+1);
	}
	
	
}
