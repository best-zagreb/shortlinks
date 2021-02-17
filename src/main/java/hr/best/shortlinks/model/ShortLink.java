package hr.best.shortlinks.model;

import javax.persistence.*;

@Entity(name="shortlink")
@Table
public class ShortLink {
    @Id
    @SequenceGenerator(
            name = "link_sequence",
            sequenceName = "link_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "link_sequence"
    )
    private Long id;
    private String name;
    private String siteUrl;
    private String shortenedUrl;

    public ShortLink() {
    }

    public ShortLink(String name, String siteUrl, String shortenedUrl) {
        this.name = name;
        this.siteUrl = siteUrl;
        this.shortenedUrl = shortenedUrl;
    }

    public ShortLink(Long id, String name, String siteUrl, String shortenedUrl) {
        this.id = id;
        this.name = name;
        this.siteUrl = siteUrl;
        this.shortenedUrl = shortenedUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String from) {
        this.siteUrl = from;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String to) {
        this.shortenedUrl = to;
    }

    @Override
    public String toString() {
        return "LinkService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", from='" + siteUrl + '\'' +
                ", to='" + shortenedUrl + '\'' +
                '}';
    }
}
