package com.kvart;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {

        if (minutes > 60) {
            throw new IllegalArgumentException("bla-bla");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(TimeSpan timeSpan) {
        int thistime = hours * 60 + minutes;
        int timeS = timeSpan.getHours() * 60 + timeSpan.getMinutes();
        int sum = thistime + timeS;
        this.hours = sum / 60;
        this.minutes = sum % 60;

    }

    public void sub(TimeSpan timeSpan) {
        int thistime = hours * 60 + minutes;
        int timeS = timeSpan.getHours() * 60 + timeSpan.getMinutes();
        int sum = thistime - timeS;
        this.hours = sum / 60;
        this.minutes = sum % 60;
    }

    public void mult(double times) {
        int thistime = hours * 60 + minutes;
        double sum = thistime * times;
        this.hours = (int)sum / 60;
        this.minutes = (int) sum % 60;
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
