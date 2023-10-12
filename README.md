# Nama: Doni Arya Rachmadi
# NIM : 2209116033

<h2> Tema TV Kabel</h2>

## 1. Source Code
### Main.java
```Java
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
```

### CableTVSystem.java
```Java
package tvkabel;

import java.util.ArrayList;

public class CableTVSystem {
    private static final ArrayList<Channel> channels = new ArrayList<>();

    public static void addChannel(Channel channel) {
        channels.add(channel);
    }

    public static void showAllChannels() {
        for (Channel channel : channels) {
            channel.showProgram();
        }
    }

    public static boolean deleteChannel(int channelNumber) {
        for (Channel channel : channels) {
            if (channel.getChannelNumber() == channelNumber) {
                channels.remove(channel);
                return true;
            }
        }
        System.out.println("Channel not found!");
        return false;
    }

    public static boolean updateChannel(int channelNumber, Channel channel) {
        for (Channel c : channels) {
            if (c.getChannelNumber() == channelNumber) {
                c.setChannelNumber(channel.getChannelNumber());
                c.setName(channel.getName());
                if (c instanceof NewsChannel && channel instanceof NewsChannel) {
                    ((NewsChannel) c).setNewsTitle(((NewsChannel) channel).getNewsTitle());
                    ((NewsChannel) c).setNewsContent(((NewsChannel) channel).getNewsContent());
                } else if (c instanceof EntertaimentChannel && channel instanceof EntertaimentChannel) {
                    ((EntertaimentChannel) c).setProgramName(((EntertaimentChannel) channel).getProgramName());
                    ((EntertaimentChannel) c).setProgramGenre(((EntertaimentChannel) channel).getProgramGenre());
                }
                break;
            }
        }
        return false;
    }
}
```

### Channel.java
```java
package tvkabel;

abstract class Channel {
    private final String name;
    private int channelNumber;

    public Channel(String name, int channelNumber) {
        this.name = name;
        this.channelNumber = channelNumber;
    }

    public final String getName() {
        return name;
    }

    public final int getChannelNumber() {
        return channelNumber;
    }

    public final void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public abstract void showProgram();

    public final void setName(String name) {
    }
}

```
### EntertaimentChannel.java
```Java
package tvkabel;

public class EntertaimentChannel extends Channel {
    private String programName;
    private String programGenre;

    public EntertaimentChannel(String name, int channelNumber, String programName, String programGenre) {
        super(name, channelNumber);
        this.programName = programName;
        this.programGenre = programGenre;
    }

    public final String getProgramName() {
        return programName;
    }

    public final String getProgramGenre() {
        return programGenre;
    }

    public final void setProgramName(String programName) {
        this.programName = programName;
    }

    public final void setProgramGenre(String programGenre) {
        this.programGenre = programGenre;
    }

    @Override
    public final void showProgram() {
        System.out.println("> Entertaiment channel <");
        System.out.println("Channel name: " + getName());
        System.out.println("Channel number: " + getChannelNumber());
        System.out.println("Program name: " + programName);
        System.out.println("Program genre: " + programGenre);
        System.out.println();
    }
}

```

### NewsChannel.java
```Java
package tvkabel;

public class NewsChannel extends Channel{
    private String newsTitle;
    private String newsContent;

    public NewsChannel(String name, int channelNumber, String newsTitle, String newsContent) {
        super(name, channelNumber);
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public final String getNewsTitle() {
        return newsTitle;
    }

    public final String getNewsContent() {
        return newsContent;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public void showProgram() {
        System.out.println("> News channel <");
        System.out.println("Channel name: " + getName());
        System.out.println("Channel number: " + getChannelNumber());
        System.out.println("News title: " + newsTitle);
        System.out.println("News content: " + newsContent);
        System.out.println();
    }
}

```

## 2. Penjelasan Source Code tiap Class.

### Main.java
Pada Program Main.java terdapat method main yang berfungsi untuk menjalankan program. Pada method main terdapat beberapa pilihan yang dapat dipilih oleh user. Pilihan tersebut antara lain:

1. Add channel
2. Show all channels
3. Delete channel
4. Update channel
5. Exit

Pada pilihan 1, user dapat memilih untuk menambahkan channel berita atau channel hiburan. Jika user memilih untuk menambahkan channel berita, maka user akan diminta untuk memasukkan nama channel, nomor channel, judul berita, dan isi berita. Jika user memilih untuk menambahkan channel hiburan, maka user akan diminta untuk memasukkan nama channel, nomor channel, nama program, dan genre program. Setelah user memasukkan data-data tersebut, maka channel akan ditambahkan ke dalam arraylist channels.

Pada pilihan 2, user dapat melihat semua channel yang telah ditambahkan. Untuk setiap channel, akan ditampilkan nama channel, nomor channel, judul berita, dan isi berita jika channel tersebut merupakan channel berita. Jika channel tersebut merupakan channel hiburan, maka akan ditampilkan nama channel, nomor channel, nama program, dan genre program.

Pada pilihan 3, user dapat menghapus channel yang telah ditambahkan. User akan diminta untuk memasukkan nomor channel yang ingin dihapus. Jika channel dengan nomor channel tersebut ditemukan, maka channel tersebut akan dihapus dari arraylist channels.

Pada pilihan 4, user dapat mengupdate channel yang telah ditambahkan. User akan diminta untuk memasukkan nomor channel yang ingin diupdate. Jika channel dengan nomor channel tersebut ditemukan, maka user akan diminta untuk memasukkan nama channel baru. Setelah itu, user akan diminta untuk memilih apakah channel tersebut merupakan channel berita atau channel hiburan. Jika user memilih untuk mengupdate channel berita, maka user akan diminta untuk memasukkan judul berita dan isi berita baru. Jika user memilih untuk mengupdate channel hiburan, maka user akan diminta untuk memasukkan nama program dan genre program baru. Setelah itu, channel akan diupdate.

Pada pilihan 5, program akan berhenti.

### CableTVSystem.java
Pada program CableTVSystem.java terdapat class CableTVSystem yang berfungsi untuk menyimpan arraylist channels dan melakukan operasi-operasi terhadap arraylist tersebut. Terdapat 4 method pada class CableTVSystem, yaitu:

1. addChannel, berfungsi untuk menambahkan channel ke dalam arraylist channels.
2. showAllChannels, berfungsi untuk menampilkan semua channel yang telah ditambahkan.
3. deleteChannel, berfungsi untuk menghapus channel dari arraylist channels.
4. updateChannel, berfungsi untuk mengupdate channel yang telah ditambahkan.

### Channel.java
Pada program Channel.java terdapat class Channel yang merupakan class abstract. Class Channel memiliki 2 atribut, yaitu name dan channelNumber. Terdapat getter dan sette pada class Channel, yaitu:

1. getName, berfungsi untuk mengembalikan nilai atribut name.
2. getChannelNumber, berfungsi untuk mengembalikan nilai atribut channelNumber.
3. setName, berfungsi untuk mengubah nilai atribut name.
4. setChannelNumber, berfungsi untuk mengubah nilai atribut channelNumber.

### EntertaimentChannel.java
Pada program EntertaimentChannel.java terdapat class EntertaimentChannel yang merupakan subclass dari class Channel. Class EntertaimentChannel memiliki 2 atribut tambahan, yaitu programName dan programGenre. Terdapat 2 method tambahan pada class EntertaimentChannel, yaitu:

1. getProgramName, berfungsi untuk mengembalikan nilai atribut programName.
2. getProgramGenre, berfungsi untuk mengembalikan nilai atribut programGenre.
3. setProgramName, berfungsi untuk mengubah nilai atribut programName.
4. setProgramGenre, berfungsi untuk mengubah nilai atribut programGenre.


### NewsChannel.java
Pada program NewsChannel.java terdapat class NewsChannel yang merupakan subclass dari class Channel. Class NewsChannel memiliki 2 atribut tambahan, yaitu newsTitle dan newsContent. Terdapat 2 method tambahan pada class NewsChannel, yaitu:

1. getNewsTitle, berfungsi untuk mengembalikan nilai atribut newsTitle.
2. getNewsContent, berfungsi untuk mengembalikan nilai atribut newsContent.
3. setNewsTitle, berfungsi untuk mengubah nilai atribut newsTitle.
4. setNewsContent, berfungsi untuk mengubah nilai atribut newsContent.

## 3. Screenshot Output Program
### Tampilan awal program

![image](https://github.com/donigantengabis/pbo-post-test-2/assets/126888649/232ddcc0-c4e5-445a-bcb3-8deed9f0b083)


Saat program dijalankan, user akan melihat tampilan seperti di atas. User dapat memilih salah satu pilihan yang tersedia dengan memasukkan angka yang sesuai dengan pilihan tersebut. Jika user memasukkan angka selain 1, 2, 3, 4, atau 5, maka akan muncul pesan "Invalid choice".

### Tampilan setelah user memilih pilihan 1

![image-1](https://github.com/donigantengabis/pbo-post-test-2/assets/126888649/315d9708-e7b7-4249-a67f-1aacc372d8e8)


Jika user memilih pilihan 1, maka user akan diminta untuk memilih apakah user ingin menambahkan channel berita atau channel hiburan. Jika user memilih untuk menambahkan channel berita, maka user akan diminta untuk memasukkan nama channel, nomor channel, judul berita, dan isi berita. Jika user memilih untuk menambahkan channel hiburan, maka user akan diminta untuk memasukkan nama channel, nomor channel, nama program, dan genre program. Setelah user memasukkan data-data tersebut, maka channel akan ditambahkan ke dalam arraylist channels.

### Tampilan setelah user memilih pilihan 2
![image-2](https://github.com/donigantengabis/pbo-post-test-2/assets/126888649/d00f8e04-be53-4fa1-91bc-94dca2440010)


Jika user memilih pilihan 2, maka user akan melihat semua channel yang telah ditambahkan. Untuk setiap channel, akan ditampilkan nama channel, nomor channel, judul berita, dan isi berita jika channel tersebut merupakan channel berita. Jika channel tersebut merupakan channel hiburan, maka akan ditampilkan nama channel, nomor channel, nama program, dan genre program.

### Tampilan setelah user memilih pilihan 3
![image-3](https://github.com/donigantengabis/pbo-post-test-2/assets/126888649/c6c3bc9c-664c-43da-95f4-821a30745167)


Jika user memilih pilihan 3, maka user akan diminta untuk memasukkan nomor channel yang ingin dihapus. Jika channel dengan nomor channel tersebut ditemukan, maka channel tersebut akan dihapus dari arraylist channels.

### Tampilan setelah user memilih pilihan 4

![image-5](https://github.com/donigantengabis/pbo-post-test-2/assets/126888649/e5603c55-5606-4dfb-a4d4-e99306281c7d)


Jika user memilih pilihan 4, maka user akan diminta untuk memasukkan nomor channel yang ingin diupdate. Jika channel dengan nomor channel tersebut ditemukan, maka user akan diminta untuk memasukkan nama channel baru. Setelah itu, user akan diminta untuk memilih apakah channel tersebut merupakan channel berita atau channel hiburan. Jika user memilih untuk mengupdate channel berita, maka user akan diminta untuk memasukkan judul berita dan isi berita baru. Jika user memilih untuk mengupdate channel hiburan, maka user akan diminta untuk memasukkan nama program dan genre program baru. Setelah itu, channel akan diupdate.
