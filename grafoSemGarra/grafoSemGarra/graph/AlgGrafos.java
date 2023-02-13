package graph;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AlgGrafos
{
    public static void main(String[] args) {

    	Scanner graph = new Scanner(System.in);
    	new DisplayFiles().showGraphOptions();
    	System.out.println("Select the graph you want to verify if it is a Claw-Free graph by typing the file name:");
    	String file = graph.nextLine();
    	
    	Digraph g1 = new Digraph();

        try (Scanner scanner = new Scanner(new FileReader("myfiles" + System.getProperty("file.separator")
        	+ file))) {

            String linha;
            String[] valores;

            while (scanner.hasNextLine()){
                linha = scanner.nextLine();
                valores = linha.split(" ");

                for(int i=0; i<valores.length; i++){
                    if(!valores[i].equals("=") && i==0){
                        g1.add_vertex(Integer.parseInt(valores[i]));

                    }
                    else if(!valores[i].equals("=")){

                        g1.add_vertex(Integer.parseInt(valores[i]));
                        g1.add_edge(Integer.parseInt(valores[0]), Integer.parseInt(valores[i]));


                    }

                }

            }
            
            g1.identifica_semGarra();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + e.getMessage());
        }
    }
}
