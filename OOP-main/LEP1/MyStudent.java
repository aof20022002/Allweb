class MyStudent {
    public static void main(String[] args) {
        Student student1 = new Student("YO","111111",null);
        Student student2 = new Student("Nat", "555555", student1);
        
        student1.setclassMate(student2);
        
        student1.print();
        student2.print();

    }
}
