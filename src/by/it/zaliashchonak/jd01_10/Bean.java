package by.it.zaliashchonak.jd01_10;

public class Bean {
    @Param( a=3, b=4)
    static double sum(int a, int b){
        return a+b;
    }
    @Param( a=4, b=5)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }
    @Param( a=6, b=7)
    double min(int a, int b){
        return a < b? a: b;
    }
    double max(int a, int b){
        return a > b? a: b;
    }

}