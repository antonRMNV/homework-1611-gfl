package org.example.model.broadcast;

import org.example.model.host.Host;

import java.util.ArrayList;
import java.util.List;

public class Broadcast {
    private String title;
    private int maxDuration;
    private List<BroadcastPart> broadcast;
    private List<Host> hosts;

    {
        broadcast = new ArrayList<>();
        hosts = new ArrayList<>();
    }

    public Broadcast(String title, int maxDuration) {
        this.title = title;
        this.maxDuration = maxDuration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public List<BroadcastPart> getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(List<BroadcastPart> broadcast) {
        this.broadcast = broadcast;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    public void addHost(Host host) {
        hosts.add(host);
    }

    public void addPart(BroadcastPart broadcastPart) {
        if(calculateBroadcastDuration() + broadcastPart.getDuration() > maxDuration) {
            throw new IllegalArgumentException("Maximum broadcast duration exceeded");
        } else if(broadcastPart instanceof Adversiting || broadcastPart instanceof Interview) {
            if(calculateDurationOfPaidContent() + broadcastPart.getDuration() > calculateBroadcastDuration() / 2) {
                throw new IllegalArgumentException("The duration of paid content should not exceed half of the broadcast");
            } else {
                broadcast.add(broadcastPart);
            }
        } else {
            broadcast.add(broadcastPart);
        }
    }

    public int calculateBroadcastDuration() {
        return broadcast.stream()
                .mapToInt(BroadcastPart::getDuration)
                .sum();
    }

    public int calculateDurationOfPaidContent() {
        return broadcast.stream()
                .filter(x -> x instanceof Adversiting || x instanceof Interview)
                .mapToInt(BroadcastPart::getDuration)
                .sum();
    }

    public double calculateIncome() {
        return broadcast.stream()
                .mapToDouble(BroadcastPart::getIncome)
                .sum();
    }

    public void printBroadcastInfo() {
        System.out.printf("----------\nBroadcast title: %s. Duration: %.1f minutes (%d seconds). Income: %.2f$\nHost(-s): ",
                title, calculateBroadcastDuration() / 60., calculateBroadcastDuration(), calculateIncome());
        hosts.stream().map(Host::getName).forEach(x -> System.out.print(x + ". "));
        System.out.println("\n----------");
        broadcast.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return title + " ";
    }
}
