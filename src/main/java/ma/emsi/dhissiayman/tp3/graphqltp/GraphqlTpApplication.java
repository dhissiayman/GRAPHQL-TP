package ma.emsi.dhissiayman.tp3.graphqltp;

import ma.emsi.dhissiayman.tp3.graphqltp.entity.Centre;
import ma.emsi.dhissiayman.tp3.graphqltp.entity.Etudiant;
import ma.emsi.dhissiayman.tp3.graphqltp.enu.Genre;
import ma.emsi.dhissiayman.tp3.graphqltp.repository.CentreRepository;
import ma.emsi.dhissiayman.tp3.graphqltp.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlTpApplication implements CommandLineRunner {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CentreRepository centreRepository;
    public static void main(String[] args) {
        SpringApplication.run(GraphqlTpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Centre centre1=Centre.builder()
                .nom("Maarif").adresse("Biranzarane").build();
        centreRepository.save(centre1);
        Centre centre2=Centre.builder()
                .nom("Oranges").adresse("Oulfa").build();
        centreRepository.save(centre2);
        Etudiant et1=Etudiant.builder()
                .nom("Adnani").prenom("Brahim").genre(Genre.HOMME)
                .centre(centre1).build();
        etudiantRepository.save(et1);

}
}