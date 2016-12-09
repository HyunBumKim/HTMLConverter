import java.util.ArrayList;

public class ItemList extends Node{
   public int IsOrdered;
   
   public ItemList(ArrayList<String> text, int isordered) {
      super(text);
      this.IsOrdered = isordered;
   }
   public void accept(MDElementVisitor v)
   {
      startIndex = Document.HtmlStr.length();

      if(this.elements != null)
      {
         for(MDElement element : this.elements)
         {
            element.accept(v);
         }
      }
         v.visit(this);
      
   }

}