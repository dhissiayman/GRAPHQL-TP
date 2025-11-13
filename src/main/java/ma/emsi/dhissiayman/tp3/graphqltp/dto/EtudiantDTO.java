package ma.emsi.dhissiayman.tp3.graphqltp.dto;

import ma.emsi.dhissiayman.tp3.graphqltp.enu.Genre;

public record EtudiantDTO (
        String nom,
        String prenom,
        Genre genre,
        Long centreId
){ }