import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ActivityList extends UnicastRemoteObject implements ListInteface{
	HashMap<Integer, String> lista;
	
	public ActivityList() throws RemoteException {
		lista = new HashMap<Integer, String>();
	}

	@Override
	public void add(int index, Object element) throws RemoteException {
		lista.put(index, (String) element);
	}

	@Override
	public Object get(int index) throws RemoteException {
		return lista.get(index);
	}

	@Override
	public Object remove(int index) throws RemoteException {
		return lista.remove(index);
	}

	@Override
	public int size() throws RemoteException {
		return lista.size();
	}


}