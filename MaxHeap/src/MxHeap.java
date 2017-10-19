import java.util.ArrayList;

public class MxHeap {
    private int stopPosition = 0;

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
     * @param arr
     */
    public void swap (ArrayList<Integer> arr, int pos1, int pos2) {
        int val1 = arr.get(pos1);
        int val2 = arr.get(pos2);
        arr.set(pos1, val2);
        arr.set(pos2, val1);
    }

    /**
     * buildHeap() method
     * - gets called once with last position in array as incomingPos
     *      and creates a complete heap from the incoming ArrayList.
     * @param arr
     * @param incomingPos
     */
    public void buildHeap(ArrayList<Integer> arr, int incomingPos) {
        // int sizePos = (arr.size()-1);
        int endPos = 1;    // initialize to leftChild of first element.
        while (endPos < incomingPos) {
            siftUp(arr, endPos);
            endPos++;
        }
    }

    /**
     * siftUp() method
     * - does a partial, recursive sort from any position in the ArrayList.
     * @param arr
     * @param endPos
     */
    public void siftUp(ArrayList<Integer> arr, int endPos) {
        // TODO:  remove this output.
        System.out.println("siftUp - endPos: " + endPos + " arr: " + arr + "\n");
        int childPos = endPos;
        while (childPos > stopPosition) {
            int parentPos = parent(childPos);
            if (arr.get(childPos) > arr.get(parentPos)) {
                swap(arr, parentPos, childPos);
                childPos = parentPos;
                // recursive call.
                siftUp(arr, childPos);
            } else {
                childPos = parentPos;
                // no swap needed.
            }
        }
    }
}
