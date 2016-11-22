import java.io.FileInputStream;
import org.w3c.tidy.Tidy;
//import java.io.InputStream;
//import java.io.ByteArrayInputStream;

public class MainClass {
	
	public static void main(String[] argv){
		FileInputStream file = null;
		Tidy tidy = new Tidy();
		try {
			file = new FileInputStream("test.html");
		//	int size = file.available();
		//	int i =0;
		//	byte[] buf = new  byte[size];
			
			
			//if((i = file.read(buf))!=-1){
				//InputStream stream = new ByteArrayInputStream(buf);
				tidy.parse(file, System.out);
				
				if(tidy.getParseErrors() == 0)
					 System.out.println("Valid Syntax!");
				else
					System.out.println("Invalid Syntax!");		
			//}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
