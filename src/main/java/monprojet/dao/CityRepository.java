package monprojet.dao;

import monprojet.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

// <City> = Type de l'objet manipulé
// <Integer> = Type de la clé
public interface CityRepository extends JpaRepository<City, Integer>
{
    /**
     * Trouve une ville par son nom.
     * Cette méthode sera automatiquement implémentée par Spring Data JPA.
     * @param name
     * @return La ville correspondant au nom fourni, ou null si pas trouvé.
     */
    public City findByName(String name);
}
