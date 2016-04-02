
public class SortedInsertLL {

	public class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	
	public void add(int data){
		Node newNode = new Node(data);
		Node cur = head;
		
		if(head==null || head.data>=newNode.data){
			newNode.next=head;
			head = newNode;
			return;
		}else{
			
			while(cur.next!=null && cur.next.data<newNode.data){
				cur=cur.next;
			}
			
			newNode.next = cur.next;
			cur.next = newNode;
			
		}
	}
	
	public void display(){
		Node cur = head;
		
		while(cur!=null){
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
	public static void main(String[] args){
		SortedInsertLL list = new SortedInsertLL();
		
		list.add(200);
		list.add(50);
		list.add(70);
		list.add(30);
		list.add(40);
		list.add(100);
		
		list.display();
		
	}
	
}
