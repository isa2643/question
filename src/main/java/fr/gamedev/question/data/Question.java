package fr.gamedev.question.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author djer1
 *
 */
@Entity
public class Question {
    /** .*/
    @GeneratedValue(generator = "seq_gen_question")
    @GenericGenerator(name = "seq_gen_question", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_question"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    //TODO grp3 by DJE : JavaDoc : ce commentaire devrait être sur la ligne 19.
    //TODO grp3 by DJE : JavaDoc : le @ n'est pas utile.
    /** @id.*/
    private long id;
    //TODO grp3 by DJE : JavaDoc : le @ n'est pas utile.
    /** @content.*/
    private String content;
    /** Tag.*/
    @ManyToMany
    //TODO grp3 by DJE : ORM : cette liste devrait être initialisée.
    private List<Tag> tags;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param theId the id to set
     */
    public void setId(final long theId) {
        this.id = theId;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param theContent the content to set
     */
    public void setContent(final String theContent) {
        this.content = theContent;
    }

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param theTags the tags to set
     */
    public void setTags(final List<Tag> theTags) {
        this.tags = theTags;
    }

}
