import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

import java.util.Scanner;

public class Client {

    Scanner in;
    ListInteface lista;

    public Client() {
        in = new Scanner(System.in);

        try {
            lista =(ListInteface) Naming.lookup( "rmi://127.0.0.1/lista1");
        }
        catch(RemoteException e ) {
            System.out.println();
            System.out.println( "RemoteException: " + e.toString() );
        }
        catch(NotBoundException e ) {
            System.out.println();
            System.out.println( "NotBoundException: " + e.toString() );
        }
        catch(Exception e ) {
            System.out.println();
            System.out.println( "Exception: " + e.toString() );
        }
    }

    public void execute() {
        String entrada;
        String comando;
        int key;
        String value;

        try {
            System.out.println("Entre com um dos comandos a seguir:" +
                    "\n \t\tadd <key> <valor>\n\t\tget <key>\n\t\tremove <key>\n\t\tsize\n\t\tsair");
            while(true) {
                comando = in.next();
                if(comando.equalsIgnoreCase("add")) {
                    key = in.nextInt();
                    value = in.next();
                    lista.add(key,value);
                    System.out.println("Adicionou item");
                } else if(comando.equalsIgnoreCase("get")) {
                    key = in.nextInt();
                    value = (String) lista.get(key);
                    System.out.println("result: "+ value);
                }else if(comando.equalsIgnoreCase("remove")) {
                    key = in.nextInt();
                    value = (String) lista.remove(key);
                    System.out.println("result: "+ value);
                } else if(comando.equalsIgnoreCase("size")) {
                    value = String.valueOf(lista.size());
                    System.out.println("result: "+ value);
                }else {
                    System.out.println("Saindo do programa");
                    break;
                }
            }
            in.close();
        }catch(Exception e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.execute();

    }

}
