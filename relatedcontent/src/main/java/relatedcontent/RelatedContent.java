package relatedcontent;

/**
 * Created by ricardobaumann on 5/24/17.
 */
public class RelatedContent {

    private final Long id;

    private final String description;

    public RelatedContent(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
