package com.learninglogsterminal;

import com.learninglogsterminal.entity.Topic;
import com.learninglogsterminal.service.TopicService;
import java.util.List;
import java.util.Scanner;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║        Learning Logs Terminal — Main Menu            ║
 * ║                                                      ║
 * ║   This file is PROVIDED for you. No changes needed!  ║
 * ║   Study how it works — it calls YOUR code.           ║
 * ╚══════════════════════════════════════════════════════╝
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TopicService topicService = new TopicService();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     Welcome to Learning Logs Terminal    ║");
        System.out.println("║     Track what you learn, level up!      ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        boolean running = true;

        while (running) {
            System.out.println("┌──────────────────────────────┐");
            System.out.println("│         MAIN MENU            │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Add a new Topic          │");
            System.out.println("│  2. View all Topics          │");
            System.out.println("│  3. Exit                     │");
            System.out.println("└──────────────────────────────┘");
            System.out.print("Choose an option (1-3): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter topic name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("⚠ Topic name cannot be empty!\n");
                    } else {
                        Topic topic = topicService.addTopic(name);
                        System.out.println("✓ Topic added: " + topic);
                        System.out.println("  Total topics: " + topicService.getTopicCount());
                        System.out.println();
                    }
                }
                case "2" -> {
                    List<Topic> topics = topicService.getAllTopics();

                    if (topics == null || topics.isEmpty()) {
                        System.out.println("No topics yet. Add your first topic!\n");
                    } else {
                        System.out.println("\n── Your Topics ──────────────────");
                        for (Topic topic : topics) {
                            System.out.println("  " + topic);
                        }
                        System.out.println("─────────────────────────────────");
                        System.out.println("  Total: " + topicService.getTopicCount() + " topic(s)\n");
                    }
                }
                case "3" -> {
                    running = false;
                    System.out.println("\nHappy Learning! See you next time.\n");
                }
                default -> System.out.println("Invalid option. Please choose 1, 2, or 3.\n");
            }
        }

        scanner.close();
    }
}
