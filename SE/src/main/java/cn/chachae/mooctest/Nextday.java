package cn.chachae.mooctest;

/**
 * @author chachae
 * @date 2019/9/27 11:06
 */
public class Nextday {

    public static Date nextDay(Date d) {
        Date dd = new Date(d.getMonth().getCurrentPos(), d.getDay().getCurrentPos(), d.getYear().getCurrentPos());
        dd.increment();
        return dd;
    }

}