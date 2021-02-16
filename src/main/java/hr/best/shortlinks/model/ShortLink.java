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
    private String incomingUrl;
    private String outcomingUrl;

    public ShortLink() {
    }

    public ShortLink(String name, String incomingUrl, String outcomingUrl) {
        this.name = name;
        this.incomingUrl = incomingUrl;
        this.outcomingUrl = outcomingUrl;
    }

    public ShortLink(Long id, String name, String incomingUrl, String outcomingUrl) {
        this.id = id;
        this.name = name;
        this.incomingUrl = incomingUrl;
        this.outcomingUrl = outcomingUrl;
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

    public String getIncomingUrl() {
        return incomingUrl;
    }

    public void setIncomingUrl(String from) {
        this.incomingUrl = from;
    }

    public String getOutcomingUrl() {
        return outcomingUrl;
    }

    public void setOutcomingUrl(String to) {
        this.outcomingUrl = to;
    }

    @Override
    public String toString() {
        return "LinkService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", from='" + incomingUrl + '\'' +
                ", to='" + outcomingUrl + '\'' +
                '}';
    }
}
