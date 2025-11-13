package ma.emsi.dhissiayman.tp3.graphqltp.services;

import ma.emsi.dhissiayman.tp3.graphqltp.dto.DtoToEtudiant;
import ma.emsi.dhissiayman.tp3.graphqltp.dto.EtudiantDTO;
import ma.emsi.dhissiayman.tp3.graphqltp.entity.Etudiant;
import ma.emsi.dhissiayman.tp3.graphqltp.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    DtoToEtudiant dtoToEtudiant;
    @Autowired
    EtudiantRepository etudiantRepository;
    public List<Etudiant> getStudents() {
        return etudiantRepository.findAll();
    }
    public Etudiant getEtudiant(Long id){
        return etudiantRepository.findById(id).orElse(null);
    }
    public Etudiant addEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant=new Etudiant();
        dtoToEtudiant.toEtudiant(etudiant, etudiantDTO);
        etudiantRepository.save(etudiant);
        return etudiant;
    }
    public Etudiant updateEtudiant(Long id, EtudiantDTO etudiantDTO){
        if(etudiantRepository.findById(id).isPresent()){
            Etudiant etudiant=etudiantRepository.findById(id).get();
            dtoToEtudiant.toEtudiant(etudiant,etudiantDTO);
            return etudiantRepository.save(etudiant);
        }
        return null;
    }
    public String deleteEtudiant(Long id){
        if(etudiantRepository.findById(id).isPresent()){
            Etudiant et=etudiantRepository.findById(id).get();
            etudiantRepository.deleteById(id);
            return String.format("l'étudiant %s est bien supprimé !",id);
        }
        return String.format("l'étudiant %s n'existe pas !",id);
    }
}