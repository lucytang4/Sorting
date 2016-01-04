import java.util.ArrayList;

public class MySorts{
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for (int j = 0; j < data.size()-1; j++){
	    //for one pass
	    for (int i = data.size()-1; i > 0; i--){
		Comparable a = data.get(i);//right
		Comparable b = data.get(i-1);//left
		if (a.compareTo(b) < 0){
		    data.set(i,b);
		    data.set(i-1,a);
		}
	    }
	    //System.out.println("one pass" + data);
	}
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ){
	for (int j = 0; j < input.size()-1; j++){
	    //for one pass
	    for (int i = input.size()-1; i > 0; i--){
		Comparable a = input.get(i);//right
		Comparable b = input.get(i-1);//left
		if (a.compareTo(b) < 0){
		    input.set(i,b);
		    input.set(i-1,a);
		}
	    }
	    //System.out.println("one pass" + input);
	}
	return input;
    }//end bubbleSort -- O(n^2)
    //--------------------------------------------------------------

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
	//maximum number of passes 
	for (int j = 0; j < data.size()-1; j++){
	    Comparable first = data.get(j); //first element
	    int index = j; //index of minVal
	    Comparable minVal = data.get(j); //intially set minVal as first element
	    //to find minimum value
	    for (int i = j; i < data.size()-1; i++){
		if (minVal.compareTo(data.get(i+1)) > 0){
		    index = i+1;
		    minVal = data.get(index);
		}
	    }
	    //switch
	    data.set(j,minVal);
	    data.set(index,first);
	    //System.out.println("pass1 " + data);
	}
    }//end selectionSort -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.

    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
	ArrayList<Comparable> newData = input;
	//maximum number of passes
	for (int j = 0; j < newData.size()-1; j++){
	    Comparable first = newData.get(j); //first element
	    int index = j; //index of minVal
	    Comparable minVal = newData.get(j); //initially set minVal as first element
	    //to find minimum value
	    for (int i = j; i < newData.size()-1; i++){
		if (minVal.compareTo(newData.get(i+1)) > 0){
		    index = i+1;
		    minVal = newData.get(index);
		}
	    }
	    //switch
	    newData.set(j,minVal);
	    newData.set(index,first);
	    //System.out.println("pass1 " + newData);
	}
	return newData;
    }//end selectionSort -- O(n^2)

    public static void BogoSortV(ArrayList<Comparable> data){
	boolean isSorted = false;
	while (isSorted == false){
	    //check if sorted
	    isSorted = true;
	    for (int i = 0; i < data.size()-1; i++){
		if (data.get(i).compareTo(data.get(i+1)) > 0) isSorted = false;
	    }
	    if (isSorted == false) shuffle(data);
	}
    }
    /*
    public static void main(String[] args){
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	BogoSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	BogoSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
    }//end main method
    */

}//end MySorts class
