package school.hei.patrimoine.pro3;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Devise.*;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.pro3.PatrimoineDeBako;

@Slf4j
public class PatrimoineDeBakoTest {

  @Test
  void patrimoine_de_bako_au_31_decembre_2025() {
    var patrimoineDeBako = new PatrimoineDeBako().get();

    var valeurPatrimoineProjete =
        patrimoineDeBako
            .projectionFuture(LocalDate.of(2025, DECEMBER, 31))
            .getValeurComptable(MGA)
            .ppMontant();

    log.error("{}", valeurPatrimoineProjete);
  }
}
