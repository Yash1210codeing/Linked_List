package Linked_List;
public class Linked_List {
public class Node{
	int val;
	Node next;
    }
   private Node head; //1st Node Address
   private int size; // number of node
   private Node tail; // last Node of Linkedlist
   // o(1)
   public void addfirst(int item) {
	   Node nn=new Node();
	   nn.val=item;
	   if(size==0) {
		   head=nn;
		   tail=nn;
		   size++;
	   }else {
		   nn.next=head;
		   head=nn;
		   size++;
	   }
   }
   //o(1)
   public void addlast(int item) {
	   if(size==0) {
		   addfirst(item);
	   }else {
		   Node nn=new Node();
		   nn.val=item;
		   tail.next=nn;
		   tail=nn;
		   size++;
	   }
   }
   //o(N)
   public void addindex(int item,int k) throws Exception{
	   if(k==0) {
		   addfirst(item);		   
	   }else if(k==size){
		   addlast(item);
	   }else {
		   Node k_1th=GetNode(k-1);
		   Node nn=new Node();
		   nn.val=item;
		   nn.next=k_1th.next;
		   k_1th.next=nn;
		   size++;
	   }
   }
   private Node GetNode(int k)throws Exception{
	   if(k<0||k>=size) {
		   throw new Exception("k out of bond");
	   }
	   Node temp=head;
	   for(int i=0;i<k;i++) {
		   temp=temp.next;
	   }
	   return temp;
   }
   public void Display() {
	   Node temp=head;
	   while(temp!=null) {
		   System.out.print(temp.val+"->");
		   temp=temp.next;
	   }
	   System.out.println(".");
   }
   //O(1)
   public int getfirst() throws Exception{
	   if(head==null) {
		   throw new Exception("List is empty");
	   }
	   return head.val;
   }
   //O(1)
   public int getlast() throws Exception {
	  if(head==null) {
		  throw new Exception(" List is Empty");
	  }
	  return tail.val;
   }
   //O(N)
   public int getatindex(int k)throws Exception  {
	   return GetNode(k).val;	   
   }
  // O(1)
   public int removefirst() {
	   Node temp=head;
	  if(size==1) {
		  head=null;
		  tail=null;
	  }else {
		  head=head.next;
		  temp.next=null;
	  }
	  size--;
	  return temp.val;
   }
   public int removelast() throws Exception{
	   if(size==1) {
		   return removefirst();
	   }else {
		   Node prev=GetNode(size-2);
		//   System.out.println(prev.val);
		   Node temp=tail;
		   tail=prev;
		   tail.next=null;
		   size--;
		   return temp.val;
	   }
   }
   public int removeatindex(int k)throws Exception {
	   if(k==0) {
		   return removefirst();		   
	   }else if(k==size-1) {
		   return removelast();
	   }else {
		   Node prev=GetNode(k-1);
		 //  Node curr=GetNode(k);
		   Node curr=prev.next;
		   prev.next=curr.next;
		   curr.next=null;
		   size--;return curr.val;
	   }
   }
   
  }