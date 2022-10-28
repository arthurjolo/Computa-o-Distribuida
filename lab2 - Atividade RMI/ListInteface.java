import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TableInterface extends Remote <E>{

	public void add(int index, E element) throws RemoteException;
	public E get(int index) throws RemoteException;
	public E remove(int index) throws RemoteException;
	public int size() throws RemoteException;	
}