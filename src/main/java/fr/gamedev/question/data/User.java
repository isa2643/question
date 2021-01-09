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
public class User {

    /** .*/
    @GeneratedValue(generator = "seq_gen_user")
    @GenericGenerator(name = "seq_gen_user", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_user"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;
    //TODO grp3 by DJE : JavaDoc : le @ n'est pas utile.
    /** @login.*/
    private String login;
    //TODO grp3 by DJE : JavaDoc : le @ n'est pas utile.
    /** @lastName.*/
    private String lastName;
    /** Tag.*/
    @ManyToMany
    //TODO grp3 by DJE : ORM : cette liste devrait être initialisée.
    private List<Tag> interests;

    /**
     * @return the interests
     */
    public List<Tag> getInterests() {
        return interests;
    }

    /**
     * @param theInterests the interests to set
     */
    public void setInterests(final List<Tag> theInterests) {
        this.interests = theInterests;
    }

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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param theLogin the login to set
     */
    public void setLogin(final String theLogin) {
        this.login = theLogin;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param theLastName the lastName to set
     */
    public void setLastName(final String theLastName) {
        this.lastName = theLastName;
    }

}
