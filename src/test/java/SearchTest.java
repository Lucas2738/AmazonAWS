import alogorithm.serach.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {

    @Test
    public void binarySearch(){
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26));
        int index = BinarySearch.execute(24, nums);

        Assertions.assertTrue(index == 23);
    }
}
