package cn.chachae.mooctest;

/**
 * @author chachae
 * @date 2019/9/27 11:05
 */
public class Day extends CalendarUnit {
    private Month m;

    public Day(int pDay, Month m) {
        setDay(pDay, m);
    }

    @Override
    public boolean increment() {
        currentPos += 1;
        if (currentPos <= m.getMonthSize()) {
            return true;
        } else {
            return false;
        }
    }

    public void setDay(int pDay, Month m) {
        setCurrentPos(pDay);
        this.m = m;
        if (!this.isValid()) {
            throw new IllegalArgumentException("Not a valid day");
        }
    }

    public int getDay() {
        return currentPos;
    }

    @Override
    public boolean isValid() {
        if (m != null && m.isValid()) {
            if (this.currentPos >= 1 && this.currentPos <= m.getMonthSize()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Day) {
            if (this.currentPos == ((Day) o).currentPos
                    && this.m.equals(((Day) o).m)) {
                return true;
            }
        }
        return false;
    }
}

