package algorithm;

public class Sort {

    long executionTime = 0;
	/*
	 * Please implement all the sorting algorithm. Feel free to add helper methods.
	 * Store all the sorted data into one of the databases.
	 */


    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int j=0; j<array.length-1; j++){
            int min = j;
            for(int i=j+1; i<array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        int in, out;
        for(out=1; out<array.length; out++)
        {
            int temp = array[out];
            in = out;
            while(in>0 && array[in-1] >= temp)
            {
                array[in] = array[in-1];
                --in;
            }
            array[in] = temp;
        }



        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int [] array){
        int [] list = array;
        //implement here

        final long startTime = System.currentTimeMillis();
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }



    public  void MergeSort(int[] array) {
        if (array.length > 1) {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            MergeSort(left);
            MergeSort(right);
            merge(array, left, right);
        }
    }

    // left half
    public int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    // right half
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    // result
    public void merge(int[] result,
                      int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }
//Quick sort
    private int qw[];
    private  int length;

    public int [] quickSort(int [] array){
        int [] list = array;
        //implement here


        final long startTime = System.currentTimeMillis();//
        this.qw = list;
        length = list.length;
        quickSort(0,length-1);

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;

        int pivot = qw[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {

            while (qw[i] < pivot) {
                i++;
            }
            while (qw[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = qw[i];
        qw[i] = qw[j];
        qw[j] = temp;
    }

    //Heap Sort
    public int [] heapSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        bHeap(array);
        for(int i = array.length-1; i>=1; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            hpf(array, i, 0);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    public void bHeap(int[] array){
        for(int i=array.length/2-1; i >= 0; i--){
            hpf(array, array.length, i);
        }
    }
    public void hpf(int[] array, int n, int i){
        int max;
        int child;
        child = 2 * i + 1;
        max = i;
        if(child < n){
            if(array[child] > array[max]){
                max = child;
            }
            if(child+1 < n){
                if(array[child + 1] > array[max]){
                    max = child + 1;
                }
            }
            if(max != i){
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
                hpf(array, n, max);
            }
        }
    }


    public int [] bucketSort(int [] array){
        int [] list = array;
        //implement here
        final long startTime = System.currentTimeMillis();
        int maxVal = getMax(array);
        int[] bucket = new int[maxVal+1];
        for(int i=0; i<bucket.length; i++){
            bucket[i] = 0;
        }
        for(int i=0; i<array.length; i++){
            bucket[array[i]]++;
        }
        int outPos = 0;
        for(int i=0; i<bucket.length; i++){
            for(int j=0; j<bucket[i]; j++){
                array[outPos++] = i;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    // get max
    public int getMax(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public int [] shellSort(int [] array){
        int [] list = array;
        //implement here
        int inner, outer;
        int temp;
        int h = 1;
        while(h <= array.length/3)
            h = h*3 + 1;
        while(h>0)
        {
            for(outer=h; outer<array.length; outer++)
            {
                temp = list[outer];
                inner = outer;
                while(inner > h-1 && list[inner-h] >= temp)
                {
                    list[inner] = list[inner-h];
                    inner -= h;
                }
                list[inner] = temp;
            }
            h = (h-1) / 3;
        }
        return list;
    }

    public static void printSortedArray(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
