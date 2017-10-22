import java.util.ArrayList;

/**
 * MxHeap class
 * - contains an array that will be sorted in place into a heap.
 * - contains vars for stop position, array size, max pos in array and heap size.
 */
public class MxHeap {
    private int stopPosition = 0;
    private int arrSize = 0;
    private int arrMaxPos = 0;
    private int heapSize = 0;
    private ArrayList<Integer> heapArr = new ArrayList<Integer>();
    private ArrayList<Integer> sortedArr = new ArrayList<Integer>();
    private boolean isHeap = false;

    public MxHeap() {
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
    }

    public MxHeap(ArrayList<Integer> arr) {
        heapArr = arr;
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
    }

    public int getArrSize() {
        return arrSize;
    }

    public int getArrMaxPos() {
        return arrMaxPos;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int getArrAtPos(int index) {
        return heapArr.get(index);
    }

    public void setArrAtPos(int index, int value) {
        heapArr.set(index, value);
    }

    public ArrayList<Integer> getHeapArr() {
        return heapArr;
    }

    public ArrayList<Integer> getSortedArr() {
        return sortedArr;
    }

    public void printHeapArr() {
        System.out.println("heapArr: " + heapArr + "\n");
    }

    public void printSortedArr() {
        System.out.println("sortedArr: " + sortedArr + "\n");
    }

    public boolean getIsHeap() {
        return isHeap;
    }

    public int getSortAtPos(int index) {
        return sortedArr.get(index);
    }

    /**
     * parent() method
     * - parent calculation for arrays starting at position zero.
     * @param pos
     * @return int
     */
    public int parent(int pos) {
        // Math.floor() only accepts double.
        double parentCalc = ((pos-1)/2);
        // Double can be converted to an intValue.
        Double parentDbl = Math.floor(parentCalc);
        // then return an int position.
        int parentPos = parentDbl.intValue();
        return parentPos;
    }

    /**
     * leftChild() method
     * - left child calculation for arrays starting at position zero.
     * @param pos
     * @return int
     */
    public int leftChild(int pos) {
        int leftPos = ((2*pos)+1);
        return leftPos;
    }

    /**
     * rightChild() method
     * - right child calculation for arrays starting at position zero.
     * @param pos
     * @return
     */
    public int rightChild(int pos) {
        int rightPos = ((2*pos)+2);
        return rightPos;
    }

    /**
     * swap() method
     * - exchanges value in pos1 with value in pos2 of ArrayList.
     * @param pos1
     * @param pos2
     */
    public void swap (int pos1, int pos2) {
        int val1 = heapArr.get(pos1);
        int val2 = heapArr.get(pos2);
        heapArr.set(pos1, val2);
        heapArr.set(pos2, val1);
    }

    /**
     * buildHeap() method
     * - gets called once with last position in array as incomingPos
     *      and creates a complete heap from the incoming ArrayList.
     * @param incomingPos
     */
    public void buildHeap(int incomingPos) {
        // initialize end position to leftChild of first element.
        int endPos = 1;
        while (endPos <= incomingPos) {
            siftUp(endPos);
            endPos++;
        }
        isHeap = true;
    }

    /**
     * siftUp() method
     * - does a partial, recursive sort from any position in the ArrayList.
     * @param endPos
     */
    public void siftUp(int endPos) {
        // TODO:  remove this output.
        // System.out.println("siftUp - endPos: " + endPos + " heapArr: " + heapArr + "\n");
        int childPos = endPos;
        while (childPos > stopPosition) {
            int parentPos = parent(childPos);
            if (heapArr.get(childPos) > heapArr.get(parentPos)) {
                swap(parentPos, childPos);
                childPos = parentPos;
                // recursive call.
                siftUp(childPos);
            } else {
                childPos = parentPos;
                // no swap needed.
            }
        }
    }

    public int extractMax() {
        int max = heapArr.get(0);
        ArrayList<Integer> sortedArr = new ArrayList<Integer>();
        heapArr.remove(0);
        // reset size and max position, then re-build the heap.
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
        buildHeap(arrMaxPos);
        return max;
    }

    /**
     * heapSort() method
     * - take the heap and process each element into a sorted array.
     * @return
     */
    public void heapSort() {
        int maxPos = arrMaxPos;
        for (int i = 0; i <= maxPos; i++) {
            int topVal = extractMax();
            sortedArr.add(i, topVal);
        }
    }
}   // end MxHeap class.
