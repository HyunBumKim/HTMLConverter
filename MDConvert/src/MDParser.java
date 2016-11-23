import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer; 

public class MDParser {
   
   ArrayList<String> fileContents;
   public String Parser(String st)
   {
      int i=0, start=0, end=0;
      
      //st�� ������ array�� �ʿ� �׷��� ���Ƿ� st1 array ����
      if((start = st.indexOf("***"))!=-1 || (start = st.indexOf("___"))!=-1){
          if((end=st.substring(start+3, st.length()).indexOf("***"))!=-1){
        	  //substring �̿��� start+3~end-1���� ����
          }
          if((end = st.substring(start+3, st.length()).indexOf("___"))!=-1){
        	  
          }
      }
      else if((start = st.indexOf("**"))!=-1 || (start = st.indexOf("__"))!=-1) {
    	  if((end=st.substring(start+2, st.length()).indexOf("**"))!=-1){
        	  //substring �̿��� start+2~end-1���� ����
          }
    	  if((end = st.substring(start+2, st.length()).indexOf("__"))!=-1){
        	  
          }
      }
      else if((start = st.indexOf("*"))!=-1 || (start = st.indexOf("_"))!=-1){
    	  if((end=st.substring(start+1, st.length()).indexOf("*"))!=-1){
        	  //substring �̿��� start+1~end-1���� ����
          }
    	  if((end = st.substring(start+1, st.length()).indexOf("_"))!=-1){
        	  
          }
      }else{
    	  //��ü string ����
      }
         
      return st;
   }
   
   public String FirstTextParser(String st)
   {
      String[] st1 = {}; 
      //st�� ������ array�� �ʿ� �׷��� ���Ƿ� st1 array ����
      for(int i=0;i<st.length();i++){
         st1[i] = st;
      }
      StringTokenizer st2 = new StringTokenizer(st, ".");
      if(st1[0]==">")
      {
         //st.substring(1)
         //st[1]���� plain string token���� ������
      }
      else if((st1[0]=="*" || st1[0]=="+" || st1[0]=="-") && (st1[1]==" " || st1[1]=="\t"))
      {
         //st.substring(2);
         //st[2]���� token parser���� ������
      }
      else if(isStringNum(st2.nextToken()))
      {
         //st1.nextToken;
         //st1.nextToken�� token parser���� ������
      }
      else if(st1[0]=="-" && st.replaceAll("-", "").length()==0)
      {
         //�ش� string �� ���� ������ �������� �����
      }
      else if(st1[0]=="=" && st.replaceAll("=", "").length()==0)
      {
         //�ش� string �� ���� ������ �������� �����
      }
      else if((st.replaceAll(" ", "").indexOf("***")==0) && st.replaceAll("*", "").length()==0)
      {
         //�ش� line�� ���ڸ� ���� ���� �� horizontal line ����
      }
      else if((st.replaceAll(" ", "").indexOf("---")==0) && st.replaceAll("-", "").length()==0)
      {
         //�ش� line�� ���ڸ� ���� ���� �� horizontal line ����
      }
   return st;
      
      /*
       * ������ list���¶�� �ش� �ٵ� list ������ ���
       * �� ��� ���� ������ �ǹ̰� ����
       * */
   }

   private boolean isStringNum(String nextToken) {
   // TODO Auto-generated method stub
   return false;
}

MDParser(String InputFileName)
   {
       fileContents = new ArrayList<String>();
       try{
             BufferedReader in = new BufferedReader(new FileReader(InputFileName));
             String s = null;
             //String temp = null;
             while((s = in.readLine()) != null)
             {
                fileContents.add(s);
             }
             in.close();
          }
          catch(IOException e)
          {
             System.err.println(e);
             System.exit(1);
          }
       /////////////////read done//////////////////   
   }
   
   
}