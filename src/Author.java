/**
 * Created by higuchijay on 3/8/15.
 */
public class Author {
    public String authorID;
    public String authorTitle;
    public String authorFirstName;
    public String authorLastName;
    public String participatingRole;

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorTitle() {
        return authorTitle;
    }

    public void setAuthorTitle(String authorTitle) {
        this.authorTitle = authorTitle;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getParticipatingRole() {
        return participatingRole;
    }

    public void setParticipatingRole(String participatingRole) {
        this.participatingRole = participatingRole;
    }

    public Author(String authorID, String authorTitle, String authorFirstName, String authorLastName, String participatingRole) {
        this.authorID = authorID;
        this.authorTitle = authorTitle;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.participatingRole = participatingRole;
    }
}
