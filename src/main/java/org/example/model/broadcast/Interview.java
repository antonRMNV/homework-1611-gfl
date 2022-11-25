package org.example.model.broadcast;

public class Interview implements BroadcastPart {
    private static final int PRICE_PER_MINUTE = 30;
    private int duration;
    private String respondent;

    public Interview(int duration, String respondent) {
        this.duration = duration;
        this.respondent = respondent;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
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
    public int getIncome() {
        return getDuration() * PRICE_PER_MINUTE / 60;
    }

    @Override
    public String toString() {
        return "Interview | " +
                "Respondent: " + respondent +
                ", Duration: " + duration + " seconds";
    }
}
