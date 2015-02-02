
public class Queue {

	protected QueueKnoten head,tail;
	
	public void enqueue(Object o){
		QueueKnoten nk = new QueueKnoten(o);
		if (isEmpty())
			head = nk;
		else
			tail.next = nk;
		tail = nk;
	}
	
	public void dequeue(){
		if (isEmpty())
			return;
		head = head.next;
	}
	
	public Object get(){
		return (head != null)?head.content:null;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	
	private class QueueKnoten{
		private QueueKnoten next;
		private final Object content;
		public QueueKnoten(Object _o){
			this.content = _o;
		}
	}

	
	//Testing methods
	public static void main(String[] a){
		Queue q = new Queue();
		
		for (int i=0;i<10;i++)
			q.enqueue(i);
		
		while (!q.isEmpty())
			printTail(q).dequeue();
		System.out.println("End");
	}
	
	private static Queue printTail(Queue q){
		System.out.println("Tail:" + q.get());
		return q;
	}
}
