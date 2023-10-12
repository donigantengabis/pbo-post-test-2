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
