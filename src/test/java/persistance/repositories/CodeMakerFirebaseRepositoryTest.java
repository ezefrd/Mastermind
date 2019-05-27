package persistance.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import dtos.CodeMakerDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import persistance.firebase.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class CodeMakerFirebaseRepositoryTest {

    @Test
    public void test_create_code_maker_game(){
        //setup:
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        Map<String, Object> data = new HashMap<>();
        data.put("CODE_MAKER_PEGS", codeMakerDto.codeMakerPegs);

        FirebaseDatabase firebaseDatabase =
                Mockito.mock(FirebaseDatabase.class);
        Firestore mockedFirestore = Mockito.mock(Firestore.class);
        CollectionReference collectionReference = Mockito.mock(CollectionReference.class);
        ApiFuture mockedApiFuture = Mockito.mock(ApiFuture.class);

        Mockito.when(mockedApiFuture.isDone()).thenReturn(true);


        Mockito.when(firebaseDatabase.getFirestore()).thenReturn(mockedFirestore);
        Mockito.when(mockedFirestore.collection("CODE_MAKER_GAME")).thenReturn(collectionReference);
        Mockito.when(collectionReference.add(data)).thenReturn(mockedApiFuture);

        CodeMakerFirebaseRepository codeMakerFirebaseRepository =
                new CodeMakerFirebaseRepository(firebaseDatabase);

        //when:
        boolean repositoryResponse = codeMakerFirebaseRepository.insertCodemakerGame(codeMakerDto);
        //then:
        Assert.assertTrue(repositoryResponse);
    }

    @Test
    public void test_retrieve_code_maker_game()
            throws ExecutionException, InterruptedException {
        //setup:
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        Map<String, Object> data = new HashMap<>();
        data.put("CODE_MAKER_PEGS", codeMakerDto.codeMakerPegs);

        FirebaseDatabase firebaseDatabase =
                Mockito.mock(FirebaseDatabase.class);
        Firestore mockedFirestore = Mockito.mock(Firestore.class);
        CollectionReference collectionReference = Mockito.mock(CollectionReference.class);
        ApiFuture<QuerySnapshot> mockedApiFuture = Mockito.mock(ApiFuture.class);
        QuerySnapshot mockedQuerySnapshot = Mockito.mock(QuerySnapshot.class);
        QueryDocumentSnapshot mockedSnapshot = Mockito.mock(QueryDocumentSnapshot.class);
        Mockito.when(mockedSnapshot.get("CODE_MAKER_PEGS")).thenReturn(codeMakerDto.codeMakerPegs);
        ArrayList<QueryDocumentSnapshot> mockedDocuments = new ArrayList<>();
        mockedDocuments.add(mockedSnapshot);
        Mockito.when(mockedQuerySnapshot.getDocuments()).thenReturn(mockedDocuments);

        Mockito.when(mockedApiFuture.get()).thenReturn(mockedQuerySnapshot);


        Mockito.when(firebaseDatabase.getFirestore()).thenReturn(mockedFirestore);
        Mockito.when(mockedFirestore.collection("CODE_MAKER_GAME")).thenReturn(collectionReference);
        Mockito.when(collectionReference.get()).thenReturn(mockedApiFuture);

        CodeMakerFirebaseRepository codeMakerFirebaseRepository =
                new CodeMakerFirebaseRepository(firebaseDatabase);

        //when:
        CodeMakerDto savedGame = codeMakerFirebaseRepository.getCodeMakerGame();
        //then:
        Assert.assertEquals(codeMakerDto, savedGame);
    }

    @Test
    public void test_retrieve_code_maker_game_fails()
            throws ExecutionException, InterruptedException {
        //setup:
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        Map<String, Object> data = new HashMap<>();
        data.put("CODE_MAKER_PEGS", codeMakerDto.codeMakerPegs);

        FirebaseDatabase firebaseDatabase =
                Mockito.mock(FirebaseDatabase.class);
        Firestore mockedFirestore = Mockito.mock(Firestore.class);
        CollectionReference collectionReference = Mockito.mock(CollectionReference.class);
        ApiFuture<QuerySnapshot> mockedApiFuture = Mockito.mock(ApiFuture.class);
        QuerySnapshot mockedQuerySnapshot = Mockito.mock(QuerySnapshot.class);
        QueryDocumentSnapshot mockedSnapshot = Mockito.mock(QueryDocumentSnapshot.class);
        Mockito.when(mockedSnapshot.get("CODE_MAKER_PEGS")).thenReturn(codeMakerDto.codeMakerPegs);
        ArrayList<QueryDocumentSnapshot> mockedDocuments = new ArrayList<>();
        mockedDocuments.add(mockedSnapshot);
        Mockito.when(mockedQuerySnapshot.getDocuments()).thenReturn(mockedDocuments);

        Mockito.when(mockedApiFuture.get()).thenThrow(ExecutionException.class);


        Mockito.when(firebaseDatabase.getFirestore()).thenReturn(mockedFirestore);
        Mockito.when(mockedFirestore.collection("CODE_MAKER_GAME")).thenReturn(collectionReference);
        Mockito.when(collectionReference.get()).thenReturn(mockedApiFuture);

        CodeMakerFirebaseRepository codeMakerFirebaseRepository =
                new CodeMakerFirebaseRepository(firebaseDatabase);

        //when:
        CodeMakerDto savedGame = codeMakerFirebaseRepository.getCodeMakerGame();
        //then:
        Assert.assertEquals(new CodeMakerDto(), savedGame);
    }

}