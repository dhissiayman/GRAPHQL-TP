package ma.emsi.dhissiayman.tp3.graphqltp.dto;

import ma.emsi.dhissiayman.tp3.graphqltp.entity.Centre;
import ma.emsi.dhissiayman.tp3.graphqltp.entity.Etudiant;
import ma.emsi.dhissiayman.tp3.graphqltp.repository.CentreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToEtudiant {
    @Autowired
    CentreRepository centreRepository;
    public void toEtudiant(Etudiant et, EtudiantDTO dto) {
        Centre centre= centreRepository.findById(dto.centreId()).orElse(null);
        if (dto != null) {
            BeanUtils.copyProperties(et,dto);
            et.setCentre(centre);
        }
    }
}