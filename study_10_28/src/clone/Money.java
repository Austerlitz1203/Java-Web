package clone;

public class Money implements Cloneable{
   double money=12.5;

   @Override
   protected Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}
