import java.util.ArrayList;

public class MakeMaxHeap {
    public static void main(String args[]) {
        // System.out.println("in MakeMaxHeap.main");
        MxHeap mH = new MxHeap();
        mH.printHeapArr();
        mH.buildHeap(mH.getArrMaxPos());
        mH.printHeapArr();
    }   // end main.
}       // end MakeMaxHeap class.
