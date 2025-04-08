package school.hei.patrimoine.cas.pro3;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Argent.*;
import static school.hei.patrimoine.modele.Devise.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Supplier;
import school.hei.patrimoine.modele.Patrimoine;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;
import school.hei.patrimoine.modele.possession.TransfertArgent;

public class PatrimoineDeBako implements Supplier<Patrimoine> {
  private static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);

  @Override
  public Patrimoine get() {
    var Bako = new Personne("Bako");
    return Patrimoine.of(
        "Patrimoine de Bako", MGA, AU_8_AVRIL_2025, Bako, possessionsDeBakoAu8Avril2025());
  }

  private static Set<Possession> possessionsDeBakoAu8Avril2025() {
    var compteCourantBNI =
        new Compte("Compte courant à la BNI", AU_8_AVRIL_2025, ariary(2_000_000));

    var compteEpargneBMOI =
        new Compte("Compte épargne à la BMOI", AU_8_AVRIL_2025, ariary(625_000));

    var coffreFort = new Compte("Coffre fort à la maison", AU_8_AVRIL_2025, ariary(1_750_000));

    var salaire =
        new FluxArgent(
            "Salaire du CDI",
            compteCourantBNI,
            AU_8_AVRIL_2025,
            LocalDate.MAX,
            2,
            ariary(2_125_000));

    var virementEpargne =
        new TransfertArgent(
            "Epargne",
            compteCourantBNI,
            compteEpargneBMOI,
            AU_8_AVRIL_2025,
            LocalDate.MAX,
            3,
            ariary(200_000));

    var loyer =
        new FluxArgent(
            "Loyer colocation chambre",
            compteCourantBNI,
            AU_8_AVRIL_2025,
            LocalDate.MAX,
            26,
            ariary(-600_000));

    var trainDeVie =
        new FluxArgent(
            "Nourriture, transport, la vie quoi",
            compteCourantBNI,
            AU_8_AVRIL_2025,
            LocalDate.MAX,
            1,
            ariary(-700_000));

    var ordinateurPortable =
        new Materiel(
            "Acer Nitro de Bako", AU_8_AVRIL_2025, AU_8_AVRIL_2025, ariary(3_000_000), -0.12);

    return Set.of(
        compteCourantBNI,
        compteEpargneBMOI,
        coffreFort,
        salaire,
        virementEpargne,
        loyer,
        trainDeVie,
        ordinateurPortable);
  }
}
