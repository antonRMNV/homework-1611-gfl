package org.example.model.broadcast;

public class Adversiting implements BroadcastPart {
    private static final int PRICE_PER_SECOND = 5;
    private int duration;
    private String title;

    public Adversiting(int duration, String name) {
        this.duration = duration;
        this.title = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }
    @Override
    public double getIncome() {
        return getDuration() * PRICE_PER_SECOND;
    }

    @Override
    public String toString() {
        return "Adversiting | " +
                "Title: " + title +
                ", Duration: " + duration + " seconds";
    }
}
