package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Categorie;

/**
 * @author isa
 *
 */

@RepositoryRestResource(collectionResourceRel = "categorie", path = "categorie")
public interface CategorieRepository extends PagingAndSortingRepository<Categorie, Long> {

}
