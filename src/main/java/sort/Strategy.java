package sort;

public enum Strategy {

    BUBBLE {
        @Override
        public void execute(int[] array) {
            int n = array.length;

            for (int dest = 0; dest < n - 1; dest++) {
                for (int src = n - 1; src > dest; src--) {
                    if (array[src - 1] > array[src]) {
                        SortHelper.swap(array, src - 1, src);
                    }
                }
            }
        }
    },

    SELECTION {
        @Override
        public void execute(int[] array) {
            int n = array.length;

            for (int dest = 0; dest < n - 1; dest++) {
                int selectedSrc = dest;

                for (int potentialSrc = dest + 1; potentialSrc < n; potentialSrc++) {
                    if (array[potentialSrc] < array[selectedSrc]) {
                        selectedSrc = potentialSrc;
                    }
                }
                SortHelper.swap(array, selectedSrc, dest);
            }
        }
    },

    INSERTION {
        @Override
        public void execute(int[] array) {
            int n = array.length;

            for (int src = 1; src < n; src++) {
                int insertVal = array[src];

                for (int dest = src - 1; dest >= 0; dest--) {
                    if (array[dest] > insertVal) {
                        array[dest + 1] = array[dest];
                        array[dest] = insertVal;
                    } else {
                        break;
                    }
                }
            }
        }
    },

    MERGE {
        @Override
        public void execute(int[] array) {
            int n = array.length;
            mergeSort(array, 0, n - 1);
        }

        private void mergeSort(int[] array, int head, int tail) {
            if (head >= tail) return;
            int center = (head + tail) / 2;
            mergeSort(array, head, center);
            mergeSort(array, center + 1, tail);
            merge(array, head, center, center + 1, tail);
        }

        private void merge(int[] array, int firstHead, int firstTail, int secondHead, int secondTail) {
            int n = secondTail - firstHead + 1;
            int[] tempArray = new int[n];
            int tempPtr = 0;

            int firstPtr = firstHead;
            int secondPtr = secondHead;

            while ((firstPtr <= firstTail) && (secondPtr <= secondTail)) {
                tempArray[tempPtr++] = (array[firstPtr] < array[secondPtr]) ? array[firstPtr++] : array[secondPtr++];
            }

            while (tempPtr < n) {
                tempArray[tempPtr++] = (firstPtr <= firstTail) ? array[firstPtr++] : array[secondPtr++];
            }

            System.arraycopy(tempArray, 0, array, firstHead, n);
        }
    };


    abstract public void execute(int[] array);
}
