
package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author isa
 *
 */

@Entity
public class Categorie {
    /** id.*/
    @GeneratedValue(generator = "seq_gen_categorie")
    @GenericGenerator(name = "seq_gen_categorie", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_categorie"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })

    @Id
    /** id.*/
    private long id;

    /** value.*/
    private String value;

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
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param theValue the value to set
     */
    public void setValue(final String theValue) {
        this.value = theValue;
    }

}
