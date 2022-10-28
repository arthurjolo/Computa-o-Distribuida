import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 
import java.util.List;
import java.util.ArrayList;

public class Table extends UnicastRemoteObject implements TableInterface <E>{
	List<E> lista;
	
	public Table() throws RemoteException {
		lista = new List<>();
	}

    @Override
	public E add(int key, E element) throws RemoteException {
		return lista.add(index, element);
	}
	
	@Override
	public E get(int index) throws RemoteException {
		return lista.insert(index);
	}

	@Override
	public E remove(int index) throws RemoteException {
		return lista.remove(index);		
	}

    @Override
	public int size() throws RemoteException {
		return lista.size();		
	}

}