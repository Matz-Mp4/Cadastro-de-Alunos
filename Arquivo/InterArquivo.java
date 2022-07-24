package Arquivo;
import java.io.File;
import Model.Armazenagem.IArmazenagem;

public interface InterArquivo{
    public boolean ler(File arq, IArmazenagem cad);
    public boolean gravar(IArmazenagem cad, String nome);
}