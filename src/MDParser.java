import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer; 

public class MDParser {
	
	ArrayList<String> fileContents;
	public String Parser(String st){
		int i=0;
		if(st.indexOf("**")!=-1)
		
		
	}
	
	public String FirstTextParser(String st){
		
		StringTokenizer st1 = new StringTokenizer(st, ".");
		if(st[0]=='>'){
			//st.substring(1)
			//st[1]���� plain string token���� ������
		}
		else if((st[0]=="*" || st[0]=="+" || st[0]=="-") && (st[1]==" " || st[1]=="\t")){
			//st.substring(2);
			//st[2]���� token parser���� ������
		}
		else if(isStringNum(st1.nextToken())){
			//st1.nextToken;
			//st1.nextToken�� token parser���� ������
		}
		else if(st[0]=="-" && st.replaceAll("-", "").length()==0){
			//�ش� string �� ���� ������ �������� �����
		}
		else if(st[0]=="=" && st.replaceAll("=", "").length==0){
			//�ش� string �� ���� ������ �������� �����
		}
		else if((st.replaceAll(" ", "").indexOf("***")==0) && st.replaceAll("*", "").length()==0){
			//�ش� line�� ���ڸ� ���� ���� �� horizontal line ����
		}
		else if((st.replaceAll(" ", "").indexOf("---")==0) && st.replaceAll("-", "").length()==0){
			//�ش� line�� ���ڸ� ���� ���� �� horizontal line ����
		}
		
		/*
		 * ������ list���¶�� �ش� �ٵ� list ������ ���
		 * �� ��� ���� ������ �ǹ̰� ����
		 * */
	}

	MDParser(String InputFileName)
	{
		 fileContents = new ArrayList<String>();
		 try{
	          BufferedReader in = new BufferedReader(new FileReader(InputFileName));
	          String s = null;
	          //String temp = null;
	          while((s = in.readline()) != null){
	             fileContents.add(s);
	          }
	          in.close();
	       }
	       catch(IOException e){
	          System.err.println(e);
	          System.exit(1);
	       }
		 /////////////////read done//////////////////
		 
	}
	
	
}
