package sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Building extends Employee{
    //Закрытые поля а методы доступа к ним через геттеры и сеттеры
    private double l;
    private double w;
    private double h;
    private int n;
    private String material;
    private String deadline;
    //Конструктор
    public Building(double l, double w, double h, int n) {
        this.l = l;
        this.w = w;
        this.h = h;
        this.n = n;
    }
    //Переопределение метода - изменение тела метода
    @Override
    public double payment() {
        double V = f(l,w,h,n);
        Date date_now = new Date();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long difference = 0;
        if (date != null) {
            difference = date.getTime() - date_now.getTime();
        }
        int days = (int)(difference / (24 * 60 * 60 * 1000));
        int number_emp = (int) Math.ceil(V/(days*work_volume));
        switch (material) {
            case "Древесина":
                return number_emp * pay_3 * days;
            case "Кирпич":
                return number_emp * pay_2 * days;
            case "Пеноблок":
                return number_emp * pay_1 * days;
        }
        return 0;
    }

    public double getL() {
        return l;
    }
    //Перегрузка методов - изменение аргументов метода. Одинаковые названия методов, но разные аргументы
    public void setL(double l) {
        this.l = l;
    }

    public void setL(String l) {
        this.l = Double.parseDouble(l);
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
