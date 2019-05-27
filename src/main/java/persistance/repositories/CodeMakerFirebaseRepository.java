package persistance.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import dtos.CodeMakerDto;
import persistance.comparators.QueryDocumentSorter;
import persistance.firebase.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class CodeMakerFirebaseRepository implements CodeMakerRepository {
    private static final String CODE_MAKERS_KEY = "CODE_MAKER_GAME";
    private static final String CODE_MAKER_PEGS_KEY = "CODE_MAKER_PEGS";


    private final FirebaseDatabase database;

    public CodeMakerFirebaseRepository() throws IOException {
        database = FirebaseDatabase.getDatabase();
    }

    public CodeMakerFirebaseRepository(FirebaseDatabase database) {
        this.database = database;
    }


    @Override public boolean insertCodemakerGame(CodeMakerDto codeMakerDto) {
        CollectionReference docRef = database.getFirestore().collection(CODE_MAKERS_KEY);

        Map<String, Object> data = new HashMap<>();
        data.put(CODE_MAKER_PEGS_KEY, codeMakerDto.codeMakerPegs);
        ApiFuture response = docRef.add(data);

        return response.isDone();
    }

    @Override public CodeMakerDto getCodeMakerGame() {
        CollectionReference docRef = database.getFirestore().collection(CODE_MAKERS_KEY);
        ApiFuture<QuerySnapshot> querySnapshot = docRef.get();

        CodeMakerDto result = new CodeMakerDto();

        try {
            ArrayList<QueryDocumentSnapshot> documentsList = getSortedDocumentsList(
                    querySnapshot);

            DocumentSnapshot codeMakerFound = documentsList.get(0);
            result.codeMakerPegs = (ArrayList<String>) codeMakerFound.get(CODE_MAKER_PEGS_KEY);
        } catch (InterruptedException | ExecutionException | NullPointerException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * I've made this, because querySnapshot.get().getDocuments() returns an
     * unmodificable list.. so I need a new one if I want to sort it by CreationDate..
     *
     * I need to do that, because I want that when the user plays a game,
     * the codemaker game that challenges the user to be the last created one.
     * @param querySnapshot
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private ArrayList<QueryDocumentSnapshot> getSortedDocumentsList(
            ApiFuture<QuerySnapshot> querySnapshot)
            throws InterruptedException, ExecutionException {
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
        ArrayList<QueryDocumentSnapshot> documentsList = new ArrayList<>();

        for(QueryDocumentSnapshot document : documents){
            documentsList.add(document);
        }
        documentsList.sort(new QueryDocumentSorter());
        return documentsList;
    }
}
