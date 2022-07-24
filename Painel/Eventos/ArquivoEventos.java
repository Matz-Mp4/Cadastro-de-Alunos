package Painel.Eventos;

//package Arquivo.JFileChooser;
import java.awt.event.*;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import Arquivo.ArquivoTexto;
import Arquivo.InterArquivo;
import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Painel.PainelArquivo;
import Painel.PainelMensagem;

public class ArquivoEventos {

  private InterArquivo arq = new ArquivoTexto();
  private PainelArquivo pnlArquivo;

  public ArquivoEventos(IArmazenagem cad, PainelArquivo pnlArquivo, PainelMensagem pnlMens) {
    this.pnlArquivo = pnlArquivo;
    setEventos(cad, pnlMens);
  }

  private void setEventos(IArmazenagem cad, PainelMensagem pnlMens) {

    pnlArquivo.getJbtnGravar().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setActionGravar(cad, pnlMens);
      }
    });

    pnlArquivo.getJbtnLer().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setActionLer(cad, pnlMens);
      }
    });

  }

  private void setActionLer(IArmazenagem cad, PainelMensagem pnlMens) {
    JFileChooser janelaArq = new JFileChooser();

    FileNameExtensionFilter txtFiltro = new FileNameExtensionFilter("Somente .txt", "txt"); // FileNameExtensionFilter
                                                                                            // txtFiltro = new
                                                                                            // FileNameExtensionFilter("Somente
                                                                                            // .txt e .bin" , "txt",
                                                                                            // "bin");
    janelaArq.setAcceptAllFileFilterUsed(false);
    janelaArq.addChoosableFileFilter(txtFiltro);

    int respostDoFileChooser = janelaArq.showOpenDialog(null);

    if (respostDoFileChooser == JFileChooser.APPROVE_OPTION) {

      File arqSelecionado = janelaArq.getSelectedFile();

      if (arq.ler(arqSelecionado, cad) == false) {
        GuiUtils.setRotuloMensagem(pnlMens, "Incapaz de ler o arquivo", Color.red, Color.white);
      } else {
        GuiUtils.setRotuloMensagem(pnlMens, "Aperte o botao RECARREGAR!", GuiUtils.COR_CERTO, Color.white);
      }
    } else {
      GuiUtils.setRotuloMensagem(pnlMens, "Nenhum arquivo selecionado.", GuiUtils.COR_LETRA, Color.white);
    }

  }

  private void setActionGravar(IArmazenagem cad, PainelMensagem pnlMens) {
    boolean veri = false;
    String nomeArq = "";

    try {
      nomeArq = JOptionPane.showInputDialog("Forneca o nome do arquivo: ");
      if (nomeArq != null) {
        veri = true;
        nomeArq = nomeArq + ".txt";
      }
    } catch (Exception ae) {
      veri = false;
    }
    if (veri == true) {
      if (arq.gravar(cad, nomeArq) == true) {
        GuiUtils.setRotuloMensagem(pnlMens, "Arquivo" + nomeArq + "foi salvo!!", GuiUtils.COR_CERTO, Color.white);
      } else {
        GuiUtils.setRotuloMensagem(pnlMens, "Incapaz de salvar!!", Color.red, Color.white);
      }
    }
  }
}
