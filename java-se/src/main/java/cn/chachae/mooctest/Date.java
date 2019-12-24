package cn.chachae.mooctest;

/**
 * @author chachae
 * @date 2019/9/27 11:05
 */
public class Date {
    private Day d;
    private Month m;
    private Year y;

    public Date(int pMonth, int pDay, int pYear) {
        y = new Year(pYear);
        m = new Month(pMonth, y);
        d = new Day(pDay, m);
    }

    public void increment() {
        if (!d.increment()) {
            if (!m.increment()) {
                y.increment();
                m.setMonth(1, y);
            }
            d.setDay(1, m);
        }
    }

    public void printDate() {
        System.out.println(m.getMonth() + "/" + d.getDay() + "/" + y.getYear());
    }

    public Day getDay() {
        return d;
    }

    public Month getMonth() {
        return m;
    }

    public Year getYear() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Date) {
            if (this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)
                    && this.d.equals(((Date) o).d)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return (m.getMonth() + "/" + d.getDay() + "/" + y.getYear());
    }
}
