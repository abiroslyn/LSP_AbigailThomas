import java.util.*;
class Main
{
public static void main(String args[]) // testing class
{
IntegerSet i1=new IntegerSet();
i1.add(1);
i1.add(2);
i1.add(3);
i1.add(4);
IntegerSet i2=new IntegerSet();
i2.add(3);
i2.add(4);
i2.add(5);
i2.add(6);
i2.add(7);
  
System.out.println(i1.contains(3));
System.out.println(i2.contains(8));
  
IntegerSet i3=i1.union(i2);
  
IntegerSet i4=i1.intersection(i2);
  
System.out.println("IntegerSet-1: "+i1.toString());
System.out.println("IntegerSet-2: "+i2.toString());
System.out.println("Union: "+i3.toString());
System.out.println("Intersection: "+i4.toString());
  
}
}
// prototype of a node in IntegerSet
class Node
{
int data;
Node left,right;
Node(int data)
{
this.data=data;
}
}
class IntegerSet
{
Node root=null;
String str="";
boolean add(int data) // method that adds an element into IntegerSet
{
Node node=new Node(data);
if(root==null)
root=node;
else
{
Node temp=root;
while(temp!=null)
{
if(temp.data>data)
{
if(temp.left==null)
{
temp.left=node;
return true;
}
else
{
temp=temp.left;
}
}
else
{
if(temp.right==null)
{
temp.right=node;
return true;
}
else
{
temp=temp.right;
}
}
}
}
return false;
}
  
IntegerSet union(IntegerSet i2) // method that finds the union of 2 sets and returns new IntegerSet
{
TreeSet<Integer> ts=new TreeSet<Integer>();
addIntoHash(i2.root,ts); // add elements of i2 into hash
getUnion(root,ts); // after execution of this method, ts contains union of 2 integer sets
return addIntoIntegerSet(ts); // add all elements of ts into new IntegerSet and return it
}
void getUnion(Node root,TreeSet<Integer> ts) // union() method make use of this method to find union of 2 sets
{
if(root==null)
return;
getUnion(root.left,ts); // make inorder traversal
if(!ts.contains(root.data)) // if any new element is found which is not in ts, then add new element into ts
ts.add(root.data);
getUnion(root.right,ts);
}
  
IntegerSet addIntoIntegerSet(TreeSet<Integer> ts) // method that adds all elements of ts into new IntegerSet and returns it
{
IntegerSet is=new IntegerSet();
Iterator<Integer> it=ts.iterator();
while(it.hasNext())
{
is.add(it.next());
}
return is;
}
  
void addIntoHash(Node node,TreeSet<Integer> ts) // method that adds elements of IntegerSet into treeset
{
if(node==null)
return;
addIntoHash(node.left,ts);
ts.add(node.data);
addIntoHash(node.right,ts);
}
  
IntegerSet intersection(IntegerSet i2) // method that finds the intersection of 2 sets and returns new IntegerSet
{
TreeSet<Integer> ts1=new TreeSet<Integer>();
addIntoHash(root,ts1); // add elements of set1 into ts1
TreeSet<Integer> ts2=new TreeSet<Integer>();
addIntoHash(i2.root,ts2); // add elements of set2 into ts2
TreeSet<Integer> ts=new TreeSet<Integer>();
Iterator<Integer> it=ts1.iterator();
while(it.hasNext())
{
int value=it.next();

if(ts2.contains(value)) // if any common element is found, add it into ts
ts.add(value);
}
return addIntoIntegerSet(ts);
}
  
boolean contains(int data) // method that says whether an element is present inset or not
{
Node node=root;
while(node!=null)
{
if(node.data==data)
return true;
else if(node.data>data)
node=node.left;
else
node=node.right;
}
return false;
}
  
public String toString() // method that returns the sring type of values in IntegerSet
{
str="";
inorder(root);
return str;
}
  
void inorder(Node node)
{
if(node==null)
return;
inorder(node.left);
str+=String.valueOf(node.data)+" ";
inorder(node.right);
  
}
}
