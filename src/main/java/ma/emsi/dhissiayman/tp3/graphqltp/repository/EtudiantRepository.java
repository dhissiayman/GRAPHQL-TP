package ma.emsi.dhissiayman.tp3.graphqltp.repository;

import ma.emsi.dhissiayman.tp3.graphqltp.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long>
{
}