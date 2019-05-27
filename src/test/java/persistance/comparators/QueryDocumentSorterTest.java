package persistance.comparators;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.threeten.bp.Instant;

public class QueryDocumentSorterTest {

    private QueryDocumentSorter queryDocumentSorter;

    @Before
    public void setup(){
        queryDocumentSorter = new QueryDocumentSorter();
    }

    @Test
    public void test_compare_two_documents_retrieves_first_one_has_been_created_before(){
        //setup:
        QueryDocumentSnapshot queryDocumentSnapshot1 = Mockito.mock(QueryDocumentSnapshot.class);
        QueryDocumentSnapshot queryDocumentSnapshot2 = Mockito.mock(QueryDocumentSnapshot.class);
        Mockito.when(queryDocumentSnapshot1.getCreateTime())
                .thenReturn(Instant.ofEpochSecond(1000L,10));

        Mockito.when(queryDocumentSnapshot2.getCreateTime())
                .thenReturn(Instant.ofEpochSecond(2000L,10));

        //when:
        int result = queryDocumentSorter.compare(queryDocumentSnapshot1,queryDocumentSnapshot2);
        //then:

        Assert.assertEquals(1, result);
    }

    @Test
    public void test_compare_two_documents_retrieves_first_one_has_been_created_after(){
        //setup:
        QueryDocumentSnapshot queryDocumentSnapshot1 = Mockito.mock(QueryDocumentSnapshot.class);
        QueryDocumentSnapshot queryDocumentSnapshot2 = Mockito.mock(QueryDocumentSnapshot.class);
        Mockito.when(queryDocumentSnapshot1.getCreateTime())
                .thenReturn(Instant.ofEpochSecond(2000L,10));

        Mockito.when(queryDocumentSnapshot2.getCreateTime())
                .thenReturn(Instant.ofEpochSecond(1000L,10));

        //when:
        int result = queryDocumentSorter.compare(queryDocumentSnapshot1,queryDocumentSnapshot2);
        //then:

        Assert.assertEquals(-1, result);
    }

}