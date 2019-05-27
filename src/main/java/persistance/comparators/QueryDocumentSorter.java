package persistance.comparators;

import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.Objects;

/**
 * This class is used to sort a documents list by the creationDate,
 * retrieving the last one first. (LIFO)
 */
public class QueryDocumentSorter implements
        java.util.Comparator<com.google.cloud.firestore.QueryDocumentSnapshot> {
    @Override public int compare(QueryDocumentSnapshot queryDocumentSnapshot1, QueryDocumentSnapshot queryDocumentSnapshot2) {

        if(Objects.requireNonNull(queryDocumentSnapshot1.getCreateTime()).isBefore(
                Objects.requireNonNull(queryDocumentSnapshot2.getCreateTime())
        )){
            return 1;
        }else{
            return -1;
        }
    }
}
