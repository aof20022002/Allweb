class MyDate {
    int day;
    int month;
    int year;

    void setDay(int d){
        if (d>31) {
            System.out.println("EROR DAY");
            d=0;
        }
        day = d;
    }
    void setMonth(int m){
        if (m>12) {
            System.out.println("EROR MONTH");
            m=0;
        }
        month = m;
    }
    void setYear(int y){
        year = y;
    }

    int getDay(){
        return day;
    }
    int getMonth(){
        return month;
    }
    int getYear(){
        return year;
    }
    void print(){
        System.out.println(day+"/"+month+"/"+year);
    }

    MyDate(){
        setDay(1);
        setMonth(1);
        setYear(2020);
    }

    MyDate(int Day,int Month,int Year){
        setDay(Day);
        setMonth(Month);
        setYear(Year);
    }
}
