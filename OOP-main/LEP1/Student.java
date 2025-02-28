class Student {
    String name;
    String id;
    Student classMate;

    void setclassMate(Student sm){
        classMate = sm ; 
    }

    void print(){
        System.out.println(name+"-"+id+"-"+classMate.name);
    }

    Student(String Name,String Id,Student ClassMate){
        name=Name;
        id=Id;
        setclassMate(ClassMate);
    }
//     public class Family(){
//         public static void main(String[] args){
             
//         }
//    }
}
