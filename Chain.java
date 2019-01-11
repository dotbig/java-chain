//linkedlist
//import java.util.*;

public class Chain<T>{
	Link<T> head;
	Link<T> tail;

	public Chain(){
	}

	public Chain(T item){
		head = new Link<T>(item);
		tail = head;
	}


	public boolean add(T item){
		if (item == null){
			return false;
		}
		Link<T> newGuy = new Link<T>(item);
		if (head == null){
			head = newGuy;
			tail = head;
		} else {
			tail.next = newGuy;
			tail = newGuy;
		}
		return true;
	}


	public boolean addFront(T item){
		if (item == null){
			return false;
		}
		Link<T> newGuy = new Link<T>(item);
		if (head == null){
			head = newGuy;
		}
		newGuy.next = head;
		head = newGuy;
		return true;
	}


	public T first(){
		if (head == null){
			return null;
		}
		return head.data;
	}


	public T last(){
		if (head == null){
			return null;
		}
		return tail.data;
	}


	public T get(int index){
		if (head == null || index < 0){
			return null;
		}
		Link<T> current = head;
		int traversed = 0;
		while (traversed < index){
			current = current.next;
			traversed++;
		}
		return current.data;
	}


	public boolean insert(T item, int index){
		if (index < 0){
			return false;
		}
		Link<T> newGuy = new Link<T>(item);
		if (index == 0){ 
			newGuy.next = head;
			head = newGuy;
			return true;		
		}

		Link<T> current = head;
		int traversed = 1;
		while (traversed < index){
			if (current.next == null){
				return false;
			}
			current = current.next;
			traversed++;
		}
		newGuy.next = current.next;
		current.next = newGuy;
		return true;
	}


	public T extract(int index){
		T data;
		if (head == null || index < 0){
			return null;
		}
		if (index == 0){
			data = head.data;
			head = head.next;
			return data;
		}
		Link<T> current = head;
		int traversed = 1;
		while (traversed < index){
			if (current.next == null){
				return null;
			}
			current = current.next;
			traversed++;
		}
		if (current.next == tail){
			tail = current;
		}
		data = current.next.data;
		current.next = current.next.next;
		return data;
	}


	public int count(){
		int c = 0;
		Link<T> current = head;
		while (current != null){
			c++;
			current = current.next;
		}
		return c;
	}


	public void printChain(){
		if (head == null){
			System.out.println("chain "+this+" is empty");
			return;
		}
		System.out.println("printing chain "+this+": ");
		Link<T> current = head;
		while (current != null){
			System.out.print(current.data+", ");
			current = current.next;
		}
		System.out.println();
	}

}


//functions

//toStack
//	if(stack)
//		return
//	else 
//		stackitup


//toQueue
//	if(!stack)
//		returni
//	else
//		queueitup

