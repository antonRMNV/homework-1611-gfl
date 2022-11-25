package org.example;

import org.example.model.broadcast.*;
import org.example.model.host.Host;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Broadcast broadcast = new Broadcast("Good Morning 25.11.2022", 1240);
        List<Broadcast> archiveOfBroadcasts = new ArrayList<>();
        archiveOfBroadcasts.add(broadcast);

        Host host1 = new Host.Builder()
                .name("Anton Romanov")
                .experience(5)
                .broadcasts(archiveOfBroadcasts)
                .build();

        Host host2 = new Host.Builder()
                .name("Mykola Fedorovskyi")
                .CV("Host from Kyiv. Over 10 years of radio experience. Currently the main host of UAtop Radio")
                .broadcasts(archiveOfBroadcasts)
                .build();

        broadcast.addHost(host1);
        broadcast.addHost(host2);

        broadcast.addPart(new Song(180, "Tom Odell", "Another Love"));
        broadcast.addPart(new Adversiting(14, "Cola-Cola New Year"));
        broadcast.addPart(new Song(215, "Ed Sheeran", "Perfect"));
        broadcast.addPart(new Adversiting(8, "IT School STEP"));
        broadcast.addPart(new Song(230, "Shakira", "Waka Waka"));
        broadcast.addPart(new Song(260, "ABBA", "Happy New Year"));
        broadcast.addPart(new Adversiting(20, "City-Center"));
        broadcast.addPart(new Adversiting(7, "Vodafone"));
        broadcast.addPart(new Interview(300, "Eugeny Berkunsky"));

        broadcast.printBroadcastInfo();

        // Information about permanent host
        System.out.println("\n" + host1);

        // Information about invited host
        System.out.println("\n" + host2);
    }
}