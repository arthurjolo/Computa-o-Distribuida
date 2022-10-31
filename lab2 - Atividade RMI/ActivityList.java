import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ActivityList extends UnicastRemoteObject implements ListInteface{
	HashMap<Integer, String> lista;

	private Lock lock = new ReentrantLock();
	
	public ActivityList() throws RemoteException {
		
		lista = new HashMap<Integer, String>();
		Lock lock = new ReentrantLock();
		
	}

	@Override
	public void add(int index, Object element) throws RemoteException {
		lock.lock();
		lista.put(index, (String) element);
		lock.unlock();
	}

	@Override
	public Object get(int index) throws RemoteException {
		lock.lock();
		Object element = lista.get(index);
		lock.unlock();
		return element;
	}

	@Override
	public Object remove(int index) throws RemoteException {
		lock.lock();
		Object element = lista.remove(index);
		lock.unlock();
		return element;
	}

	@Override
	public int size() throws RemoteException {
		return lista.size();
	}


}