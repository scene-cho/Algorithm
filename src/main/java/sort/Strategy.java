package sort;

public enum Strategy {

    BUBBLE {
        @Override
        public void execute(int[] array) {
            int n = array.length;

            for (int destination = 0; destination < n - 1; destination++) {
                for (int source = destination + 1; source < n; source++) {
                    if (array[destination] > array[source]) {
                        SortHelper.swap(array, source, destination);
                    }
                }
            }

        }
    },

    SELECTION {
        @Override
        public void execute(int[] array) {
            int n = array.length;

            for (int destination = 0; destination < n - 1; destination++) {
                int selectedSource = destination;

                for (int potentialSource = destination + 1; potentialSource < n; potentialSource++) {
                    if (array[potentialSource] < array[selectedSource]) {
                        selectedSource = potentialSource;
                    }
                }

                SortHelper.swap(array, selectedSource, destination);
            }

        }
    },

    INSERTION {
        @Override
        public void execute(int[] array) {
            int n = array.length;

            for (int source = 1; source < n; source++) {
                int insertedValue = array[source];

                for (int potentialDestination = source - 1; potentialDestination >= 0; potentialDestination--) {
                    if (array[potentialDestination] > insertedValue) {
                        array[potentialDestination + 1] = array[potentialDestination];
                        array[potentialDestination] = insertedValue;
                    } else {
                        break;
                    }
                }

            }

        }
    },

    ;

    abstract public void execute(int[] array);
}
