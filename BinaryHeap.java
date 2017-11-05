
public class BinaryHeap {
	
	//create a array
	private int[] HeapData = new int[10];
	private int size;
	
	//constructor
	public BinaryHeap() {
		size = 0;
	}
	
	//get the left child
	private int leftchild(int pos) {
		return (2 * pos) + 1;
	}
	
	//get the right child
	private int rightchild(int pos) {
		return (2 * pos) + 2;
	}
	
	//get the parent
	private int parent(int pos) {
		return ((pos -1) / 2);
	}
	
	//swap two position
	private void swap(int pos1, int pos2) {
		int temp;
		temp = HeapData[pos1];
		HeapData[pos1] = HeapData[pos2];
		HeapData[pos2] = temp;
	}
	
	//add element in the heap
	public void add(int elem) {
		
		//grow size if array is full
		if(HeapData.length == size) {
			grow_heap();
		}
		
		int current = size;
		HeapData[size++] = elem;
		while (HeapData[current] < HeapData[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	//remove the first element in the heap
	public int remove() {
		int priority = HeapData[0];
		swap(0, --size);
		if (size != 0) {
			siftdown(0);
		}
		return priority;
	}

	//find the smallest in the heap
	private void siftdown(int position) {
		if (leftchild(position) >= size) {
			return;
		}
		int child = leftchild(position);
		if (rightchild(position) < size && HeapData[rightchild(position)] < HeapData[child]) {
			child = rightchild(position);
		}
		if (HeapData[child] < HeapData[position]) {
			swap(child, position);
			siftdown(child);
		}
	}

	
	//grow the heap if it is full
	public void grow_heap(){

		int newsize = HeapData.length * 2;
		int[] newarr = new int[newsize];
		for(int i = 0; i < size; i++){
			newarr[i] = HeapData[i];
		}
		HeapData = newarr;
	}
}
