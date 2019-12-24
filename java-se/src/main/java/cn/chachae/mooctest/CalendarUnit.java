package cn.chachae.mooctest;

/**
 * @author chachae
 * @date 2019/9/27 11:04
 */
public abstract class CalendarUnit {
    int currentPos;

    void setCurrentPos(int pCurrentPos) {
        currentPos = pCurrentPos;
    }

    int getCurrentPos() {
        return currentPos;
    }

    protected abstract boolean increment();
    protected abstract boolean isValid();
}
