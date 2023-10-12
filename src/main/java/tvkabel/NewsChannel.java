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
