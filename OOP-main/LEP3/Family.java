package OOP.LEP3;

public class Family {
    public static void main(String [] args){
        People beckham = new People("beckham",'M',"THAI");
        People Victoria = new People("Victoria",'F',"USA");

        Children brooklyn = new Children("brooklyn", 'M', "สุขุมวิท",beckham, Victoria);
        Children harper = new Children("harper", 'F',"สุขุมวิท2", beckham, Victoria);

        System.out.println(brooklyn.name);
        System.out.println(harper.name);

        System.out.println(brooklyn);
        System.out.println(harper);
    
        System.out.println(brooklyn.getFather());

        System.out.println(brooklyn.getFather());
        System.out.println(brooklyn.getMother());

        System.out.println(brooklyn.getFather().getWorkplace());
        System.out.println(brooklyn.getMother().getWorkplace());


        System.out.println(harper.getWorkplace());

        boolean harper1 = harper.equals(Victoria);
        if (harper1==true) {
            System.out.println("รักแม่ที่สุดเลย HBD");
        }else{
            System.out.println("นี่ไม่ใช่แม่หนูซักหน่อย");
        }
        
        System.out.println(brooklyn.respectTo(beckham));
        System.out.println(brooklyn.respectTo(Victoria));
        System.out.println(harper.respectTo(beckham));
    
    }
}
