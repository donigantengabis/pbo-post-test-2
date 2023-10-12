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
