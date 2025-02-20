package Pedro;
import java.io.*;

public class CrearFile 
{
    public static void crearArchivo()
    {
        File archivo = new File("/home/pedro/Documentos/Pedro/Liga-java/Liga/src/Pedro/Jugadores.txt");
        BufferedWriter bw;
        try 
        {
            if (archivo.exists())
            {
                System.out.println("Ya existe");
            }
            else
            {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.close();
            }   
        } catch (Exception IOException) {
            System.out.println("IO EXception");
        }
    }
}
