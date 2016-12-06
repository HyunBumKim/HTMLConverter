import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays; 

public class MDParser {
	
	ArrayList<String> fileContents;
	String strContents=null;

	MDParser(String InputFileName)
	{
		 fileContents = new ArrayList<String>();
		 try{
	          BufferedReader in = new BufferedReader(new FileReader(InputFileName));
	          String s = null;
	          //String temp = null;
	          while((s = in.readLine()) != null){
	             fileContents.add(s);
	             strContents += (s+"\n");
	          }
	          //dc.set(temp);
	          in.close();
	       }
	       catch(IOException e){
	          System.err.println(e);
	          System.exit(1);
	       }
	}
	
	/*
	void blockParser(String strContents, ArrayList<String> contents){
		String[] tokenStrs = {"=","-","_",">","#",">","    ","\t","*","+"};
		int i,j =0;
		String plainStr="";
		String str;
		
		while(true){
	
					
		}
		
		
	}*/
	/*
	boolean realParser(String str, int j)
	{
		int index;
		String buff="";
		
		//index == -1 means that this string deosn't have a Style token, 
		//but this means that it can be a style token.
		index = indexOfToken(str,j);
		if(index==-1)
			{
			buff+= str;
			return true;
			}
		else 
		{
			j++;
			buff += str.substring(0,index);
			index = indexOfToken(str.substring(index+1),j);
			
		}
	}
	
	*/
	
   public int indexOfToken(String str,int seq)
   {
	   String[] tokenStrs = {"=","-","#",">","    ","\t","*","+"};
	   int[] index={0,0,0,0,0,0,0,0};
	   
	   if(str.contains(tokenStrs[0]))
		   index[0] = str.indexOf("=");
	   if(str.contains(tokenStrs[1]))
		   index[1] = str.indexOf("-");
	   if(str.contains(tokenStrs[2]))
		   index[2]=str.indexOf("#");
	   if(str.contains(tokenStrs[3]))
		  index[3]=str.indexOf(">");
	   if(str.contains(tokenStrs[4]))
		   index[4]=str.indexOf("    ");
	   if(str.contains(tokenStrs[5]))
		   index[5]=str.indexOf("\t");
	   if(str.contains(tokenStrs[6]))
		   index[6]=str.indexOf("*");
	   if(str.contains(tokenStrs[7]))
		   index[7]=str.indexOf("+");
		   
	   if((index[0]+index[1]+index[2]+index[3]+index[4]+index[5]+index[6]+index[7])==0)
		   return -1;
	   else
	   {
		   Arrays.sort(index);
		   return index[seq];
	   }
		   
   }
	
	
}
