
public class MarkdownConv {
//private static ArrayList<String> node;
	static String InputFileName = null;
    static String OutputFileName = null;
    static String Style = null;
    
    
public static void main(String[] args) {
	CommandLineInterface CLInterface = new CommandLineInterface(args);
	InputFileName = CLInterface.InputFileName;
	OutputFileName = CLInterface.OutputFileName;
	Style = CLInterface.Style;
	
	MDParser parser = new MDParser(InputFileName);
	
	
	
 }
}

