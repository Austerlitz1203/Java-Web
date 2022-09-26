package study9_26;

class ScientificBook  extends Book{
      String area;
      ScientificBook(String title,String author,int page,String ISBN,String area){
          super(title,author,page,ISBN);
          this.area=area;
      }
      public boolean Equal(ScientificBook b){
          return super.Equal(b) &&
                  area.equals(b.area);
      }
}
