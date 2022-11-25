package org.example.model.broadcast;

public class Song implements BroadcastPart {
    private String singer;
    private String song;
    private int duration;

    public Song(int duration, String singer, String song) {
        this.duration = duration;
        this.singer = singer;
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
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
        return 0;
    }

    @Override
    public String toString() {
        return "Song | " +
                "Singer: " + singer +
                ", Song: " + song +
                ", Duration: " + duration + " seconds";
    }
}
