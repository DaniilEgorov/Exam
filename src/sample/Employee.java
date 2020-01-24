package sample;

public abstract class Employee implements Volume{
    //Статические элементы
    public final static double pay_1 = 1000.0;
    public final static double pay_2 = 1500.0;
    public final static double pay_3 = 2000.0;
    public final static double work_volume = 2.0;
    public double payment(){
        return 0;
    }

    @Override
    public double f(double l, double w, double h, int n) {
        return (l*w*0.4 +(l+w+0.4)*0.16*h)*n+(l+0.2)*(w+0.2)*0.4;
    }
}
