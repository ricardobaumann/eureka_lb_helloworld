package comment;

/**
 * Created by ricardobaumann on 5/24/17.
 */
public class Comment {

    private String username;

    private String comment;

    private String contentName;

    public Comment(String username, String comment, String contentName) {
        this.username = username;
        this.comment = comment;
        this.contentName = contentName;
    }

    public Comment() {
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public String getContentName() {
        return contentName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }
}
