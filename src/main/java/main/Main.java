package main;

import tvkabel.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----------------------------------");
            System.out.println("         Cable TV System          ");
            System.out.println("----------------------------------");
            System.out.println("1. Add channel");
            System.out.println("2. Show all channels");
            System.out.println("3. Delete channel");
            System.out.println("4. Update channel");
            System.out.println("5. Exit");
            System.out.println("----------------------------------");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Add news channel");
                    System.out.println("2. Add entertaiment channel");
                    System.out.print("Choice: ");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice2) {
                        case 1:
                            System.out.print("Channel name: ");
                            String name = scanner.nextLine();
                            System.out.print("Channel number: ");
                            int channelNumber = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("News title: ");
                            String newsTitle = scanner.nextLine();
                            System.out.print("News content: ");
                            String newsContent = scanner.nextLine();
                            NewsChannel newsChannel = new NewsChannel(name, channelNumber, newsTitle, newsContent);
                            CableTVSystem.addChannel(newsChannel);
                            break;
                        case 2:
                            System.out.print("Channel name: ");
                            String name2 = scanner.nextLine();
                            System.out.print("Channel number: ");
                            int channelNumber2 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Program name: ");
                            String programName = scanner.nextLine();
                            System.out.print("Program genre: ");
                            String programGenre = scanner.nextLine();
                            EntertaimentChannel entertaimentChannel = new EntertaimentChannel(name2, channelNumber2, programName, programGenre);
                            CableTVSystem.addChannel(entertaimentChannel);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                case 2:
                    CableTVSystem.showAllChannels();
                    break;
                case 3:
                    System.out.print("Channel number: ");
                    int channelNumberToDelete = scanner.nextInt();
                    if (CableTVSystem.deleteChannel(channelNumberToDelete)) {
                        System.out.println("Delete successfully");
                    } else {
                        System.out.println("Delete failed");
                    }
                    break;
                case 4:
                    System.out.println("----------------------------------");
                    System.out.println("Update Channel");
                    System.out.print("Channel number: ");
                    int channelNumberToUpdate = scanner.nextInt();
                    System.out.print("Channel name: ");
                    String name = scanner.nextLine();
                    scanner.nextLine();

                    int choice3;
                    System.out.println("1. Update News Channel");
                    System.out.println("2. Update Entertainment Channel");
                    System.out.print("Choice: ");
                    choice3 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice3) {
                        case 1:
                            System.out.print("News title: ");
                            String newsTitle = scanner.nextLine();
                            System.out.print("News content: ");
                            String newsContent = scanner.nextLine();
                            NewsChannel newsChannel = new NewsChannel(name, channelNumberToUpdate, newsTitle, newsContent);
                            CableTVSystem.updateChannel(channelNumberToUpdate, newsChannel);
                            System.out.println("Update news title and content successfully");
                            break;
                        case 2:
                            System.out.print("Program name: ");
                            String programName = scanner.nextLine();
                            System.out.print("Program genre: ");
                            String programGenre = scanner.nextLine();
                            EntertaimentChannel entertaimentChannel = new EntertaimentChannel(name, channelNumberToUpdate, programName, programGenre);
                            CableTVSystem.updateChannel(channelNumberToUpdate, entertaimentChannel);
                            System.out.println("Update program name and genre successfully");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our service <3");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
    }
}
