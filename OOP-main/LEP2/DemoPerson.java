package OOP.LEP2;
class DemoPerson {
    public static void main(String[] args) {
        Person dome = new Person("dome");
        Person ploy = new Person("ploy");
        Person ken = new Person("ken",'M',"0854715236");
        Person may = new Person("may",'F',"0952545876");
        Person ann = new Person("ann",'F',"0625478524");
        Person fon = new Person("fon",'F',"0958745896");
        
        dome.gender='M';
        dome.setTelno("0965874525");
        
        ploy.gender='F';
        ploy.setTelno("0845215365");

        System.out.println(dome.getPhone(ploy));
        dome.getFan(ploy);
        dome.setFan(ploy);
        ploy.setFan(dome);
        dome.getFan(ploy);

        dome.getFan(may);

        dome.setGig(may);
        dome.setGig(ann);

        dome.setGig(fon);

        dome.getGig(ken);
        dome.getGig(ken);

        dome.getPersonInfo();
        ploy.getPersonInfo();
        ken.getPersonInfo();








        
        




    
    }
}
