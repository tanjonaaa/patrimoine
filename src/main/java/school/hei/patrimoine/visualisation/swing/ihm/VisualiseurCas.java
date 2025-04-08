package school.hei.patrimoine.visualisation.swing.ihm;

import static java.awt.EventQueue.invokeLater;

import java.util.List;
import school.hei.patrimoine.cas.pro3.PatrimoineDeBako;

public class VisualiseurCas {

  public static void main(String[] args) {
    invokeLater(() -> new MainIHM(List.of(new PatrimoineDeBako().get())));
  }
}
