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

    /** .*/
    public long getId() {
        return id;
    }

    /** .*/
    public String getContent() {
        return content;
    }

}
