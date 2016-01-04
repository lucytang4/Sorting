import java.util.ArrayList;

public class Driver{
    public static void main(String[] args){
	ArrayList coco = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	MySorts.BogoSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
    }
}
