package monprojet.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Country
{
    // Identifiant technique
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    // Identifiant métier (code ISO)
    @Column(unique=true)
    @NonNull
    private String code;
    
    @Column(unique=true)
    @NonNull
    private String name;

    // mappedBy = sert à indiquer que c'est la même relation que la @ManyToOne de City
    @OneToMany(mappedBy = "country")
    // On exclut cette propriété du ToString : on ne veut pas afficher la liste des villes
    // Sinon, on affiche le pays, qui affiche sa liste de villes, qui affiche son pays, qui affiche sa liste de villes, etc
    @ToString.Exclude
    private List<City> cities = new ArrayList<>();
}
