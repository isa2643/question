package fr.gamedev.question.greeting;

/**
 * @author djer1
 *
 */
/** .*/
public class Greeting {

    /** .*/
    private final long id;
    /** .*/
    private final String content;

    /** .
     * @param theId ...
     * @param theContent ...*/
    public Greeting(final long theId, final String theContent) {
        this.id = theId;
        this.content = theContent;
    }

    /** @return the id.*/
    public long getId() {
        return id;
    }

    /** @return the content*/
    public String getContent() {
        return content;
    }

}
