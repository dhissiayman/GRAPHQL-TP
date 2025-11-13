package ma.emsi.dhissiayman.tp3.graphqltp.services;


import ma.emsi.dhissiayman.tp3.graphqltp.entity.Centre;
import ma.emsi.dhissiayman.tp3.graphqltp.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {

    @Autowired
    private CentreRepository centreRepository;

    // Utilisée par @QueryMapping getAllCentres()
    public List<Centre> centres() {
        return centreRepository.findAll();
    }

    // Utilisée par @QueryMapping getCentre(@Argument int id)
    public Centre getCentre(long id) {
        return centreRepository.findById(id).orElse(null);
    }

    // (Optionnel) méthodes CRUD si tu en as besoin plus tard

    public Centre addCentre(Centre centre) {
        return centreRepository.save(centre);
    }

    public Centre updateCentre(Long id, Centre centre) {
        return centreRepository.findById(id)
                .map(c -> {
                    c.setNom(centre.getNom());
                    c.setAdresse(centre.getAdresse());
                    return centreRepository.save(c);
                })
                .orElse(null);
    }

    public String deleteCentre(Long id) {
        if (centreRepository.findById(id).isPresent()) {
            centreRepository.deleteById(id);
            return String.format("Le centre %s est bien supprimé !", id);
        }
        return String.format("Le centre %s n'existe pas !", id);
    }
}
