import java.lang.SecurityManager;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.LinkedList;

//Executar:
// rmiregistry &
// java -Djava.security.policy=server.policy Server

public class Server {
	
    public Server() {

		try {

			if(System.getSecurityManager()==null){
				System.setProperty("java.security.policy","server.policy");
				System.setSecurityManager(new RMISecurityManager());
			}

			Runtime.getRuntime().exec("rmiregistry 1024");
	        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
	        Naming.rebind("rmi://127.0.0.1/lista1", new ActivityList());
	    }  
	    catch( Exception e ) {  
	        System.out.println( "Nao registrou o objeto: " + e );  
	    }	    
	}
	
	public static void main(String[] args) {
		new Server();
	}

}