
package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author isa
 *
 */
@Entity
public class Tag {

    /** .*/
    @GeneratedValue(generator = "seq_gen_tag")
    @GenericGenerator(name = "seq_gen_tag", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_tag"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })

    @Id
    //TODO grp3 by DJE : JavaDoc : ce commentaire devrait être sur la ligne 19.
    //TODO grp3 by DJE : JavaDoc : le @ n'est pas utile.
    /** @id.*/
    private long id;

    //TODO grp3 by DJE : JavaDoc : le @ n'est pas utile.
    /** @categorie.*/
    @ManyToOne
    private Categorie categorie;

    /**
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param theCategorie the categorie to set
     */
    public void setCategorie(final Categorie theCategorie) {
        this.categorie = theCategorie;
    }

    /** @value.*/
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
