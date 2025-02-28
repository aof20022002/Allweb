package OOP.LEP3;

class People {
   public String name;
   public char gender;
   private String workplace;

   People(String name,char gender){
     this.name=name;
     this.gender=gender;
   }
   People(String name,char gender,String workplace){
        this(name, gender);
        this.workplace=workplace;
   }
   
   public void setWorkplace(String workplace){
     this.workplace = workplace;
   }
   public String getWorkplace(){
     return this.workplace;
   }
   @Override
   public String toString() {
       return this.name;
   }
}
class Children extends People implements GoodChild{
    private People father;
    private People mother;
    private String school;

    public Children(String name,char gender,People father,People mother){
        super(name, gender);
        this.father = father;
        this.mother = mother;

    }
     Children(String name, char gender,String school, People father, People mother){
        this(name, gender, father, mother);
        this.school = school;
     }
     public String toString(){  
          if (this.gender == 'M'){
               return this.name + "(Boy)";
          }else{
               return this.name + "(Girl)";
          }
         
     }
     public void setFather(People father){
          this.father = father ;
     }
     public People getFather(){
          return father ;
      }
      public void setMother(People mother){
          this.mother = mother ;
     }
     public People getMother(){
          return mother ;
      }

      public String getWorkplace(){
          return "ยังเรียนหนังสืออยู่เลย" + this.school;
      }
      
     @Override
     public boolean equals(Object re) {
         if (this.mother == re) {
          return true ;
         }
         return false;
     }

     @Override
     public String respectTo(People people) {
          
          String m = "";
          if (this.father == people) 
          {
               m="คุณพ่อ";
          }else if (this.mother == people) 
          {
               m="คุณแม่";
          }
          if (this.gender == 'M') {
               return "สวัสดีครับ " + m;
          }else if (this.gender == 'F') {
               return "สวัสดีค่ะ " + m;
          }{
               return "สวัสดีจร้า";
          }
         
     }
     
}
interface  GoodChild{
     String respectTo(People people);
}

