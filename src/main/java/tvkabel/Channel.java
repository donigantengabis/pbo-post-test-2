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
