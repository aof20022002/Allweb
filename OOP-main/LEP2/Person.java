package OOP.LEP2;

class Person {
    public String name;
    public char gender;
    private String telno;
    private Person fan;
    private Person gig[] = new Person[2];

    Person(String name){
        this.name = name;
    }
    Person(String name,char gender,String telno){
        this.name=name;
        this.gender=gender;
        this.telno=telno;
    }
    public String toString(){
        return name;
    }

    public void setTelno(String telno){
        this.telno=telno;
    }
    String getPhone(Person person){
        if (person.gender == this.gender ) {
            return "ม่ายบอก";
        }
        else{
            return this.telno;
        }
    }
    public void setFan(Person fan){
        if (fan.gender == this.gender) {
            System.out.println("เดี๋ยวฟ้าผ่านะ เป็นแฟนกันไม่ได้");
        }else{
            if (this.fan == null) {
                this.fan=fan;
            }else{
                System.out.println("เปลี่ยนแฟนตอนนี้ไม่ได้นะ");
            }
            
        }
        
        
    }
    public void getFan(Person fan){
        if (this.fan != fan) {
            System.out.println("ยังไม่มีแฟนจ้า");
        }else{
            System.out.println("สุดที่รักไงละจ๊ะ");
        }
    }

    public void setGig(Person fan){
        if (gig[0] == null) {
            gig[0]=fan;
        }else if (gig[1] == null) {
            gig[1]=fan;
        }else{
            System.out.println("แค่ 2 คนพอแล้ว ดูแลไม่ไหว");
        }
    }
    public void getGig(Person F){
       if (this.gender == F.gender) {
           for(int i=0; i < gig.length;i++){
                System.out.println("คนที่ "+(i+1)+" ชื่อ "+gig[i]);
           }
       }else{
            System.out.println("ฉันไม่มีกิ๊ก");
       }
    }
    public void removeGig(){
        for(int i=0; i < gig.length;i++){
               gig[i]=null;
           
        }
    }
    public void removeGig(Person gig){
        for(int i=0; i < this.gig.length;i++){
            if(this.gig[i] == gig)
                this.gig[i]=null;
           }
    }

    public void getPersonInfo(){
        String sex = "";
        if (this.gender == 'M') {
            sex = "Male";
        }else{
            sex = "female";
        }
        System.out.println("\nชื่อ :"+this.name
                          +"\nSex:["+sex
                          +"] \nphone number:" +this.telno
                          +"\nFan:"+this.fan        
                            );
    }
}
