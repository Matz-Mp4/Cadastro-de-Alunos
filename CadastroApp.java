import GuiEssentials.GuiUtils;
import Model.Armazenagem.IArmazenagem;
import Model.Armazenagem.Array.CadastroArray;
import Model.Armazenagem.ListaLigada.CadastroMultiLista;

public class CadastroApp {

  public static void main(String[] args) {
    // IArmazenagem cad = new CadastroArray(GuiUtils.entrarQuantCad());
    // Ler o README.txt
    IArmazenagem cad = new CadastroMultiLista();
    new CadastroJanela(cad);
    
    
  }
}
