package sort.strategy;

import sort.ArrayHelper;

public class Heap extends AbstractAlgorithm {
    @Override
    public void execute(int[] array) {
        setVariables(array);

        int[] heap = new int[n + 1];
        int root = 1;

        System.arraycopy(array, first, heap, root, n);

        buildMaxHeap(heap, root, n);
        heapSort(heap);

        System.arraycopy(heap, root, array, first, n);
    }

    private void buildMaxHeap(int[] heap, int root, int lastNode) {
        if (doesNotHaveChild(root, lastNode)) return;

        int leftChild = root * 2;
        int rightChild = leftChild + 1;
        buildMaxHeap(heap, leftChild, lastNode);
        buildMaxHeap(heap, rightChild, lastNode);

        locateTransientRootInMaxHeap(heap, root, lastNode);
    }

    private void locateTransientRootInMaxHeap(int[] heap, int root, int lastNode) {
        if (doesNotHaveChild(root, lastNode)) return;

        int leftChild = root * 2;
        int rightChild = leftChild + 1;

        int biggerChild = (doesNotHaveRightChild(rightChild, lastNode)) ?
                leftChild : findBiggerChild(heap, leftChild, rightChild);

        if (heap[root] < heap[biggerChild]) {
            ArrayHelper.swap(heap, root, biggerChild);
            locateTransientRootInMaxHeap(heap, biggerChild, lastNode);
        }
    }

    private void heapSort(int[] heap) {
        int n = heap.length - 1;

        for (int last = n; last > 1; last--) {
            ArrayHelper.swap(heap, 1, last);
            locateTransientRootInMaxHeap(heap, 1, last - 1);
        }
    }

    private boolean doesNotHaveChild(int root, int last) {
        int lastParent = last / 2;
        return root > lastParent;
    }

    private boolean doesNotHaveRightChild(int rightChild, int lastNode) {
        return rightChild > lastNode;
    }

    private int findBiggerChild(int[] heap, int leftChild, int rightChild) {
        return (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
    }
}
