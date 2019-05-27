package persistance.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FirebaseDatabase {
    private static FirebaseDatabase database;

    private Firestore firestore;

    private FirebaseDatabase() throws IOException {

        File credentialsFile = getCredentialsFiles();

        FileInputStream serviceAccount = new FileInputStream(credentialsFile);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        firestore = FirestoreClient.getFirestore();
    }

    public static synchronized FirebaseDatabase getDatabase() throws IOException {
        if (database == null)
            database = new FirebaseDatabase();

        return database;
    }

    /**
     * Return credentials file to access Firebase
     * In case it couldn´t be found, then create one
     *
     * @return File with credential to access Database
     * @throws IOException if file couldnt be created.
     */
    private File getCredentialsFiles() throws IOException {
        File file = new File("mastermind-ezefrd.json");

        if (!file.exists())
            createCredentialsFile(file);

        return file;
    }

    /**
     * in case that the mastermind-ezefrd json file couldn't be found, create one
     * @param file
     * @throws IOException
     */
    private void createCredentialsFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        writer.write("{\n" + "  \"type\": \"service_account\",\n"
                + "  \"project_id\": \"mastermind-ezefrd\",\n"
                + "  \"private_key_id\": \"1a1cd862e3f14b0b55772f4fee7ede20bad5bdc6\",\n"
                + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCoO09Ld+GZqZIB\\nceN/7NRvjelwnG3nz0F2LHeQWlmKeUtBdbV3iNhzn4XknTtz3Ayn//M+qV28mqlE\\nGmFNYQlwqFoPJmmKD9SP3gdpLqJ5Nv1HkHekX4m5+oBSvZpL4qVbr9LQkcnYLpZO\\n6sjlahcV1Dns3iwyOiZbnn9vcR30Hv8Be/GJy/wi2p4JESkjkMO6Lk3+3WYRY5Dq\\nQrr3I/7MshcMA7BG24VxIa5dfSLbOQXmgr3nK0tIxAuN1BbC/tObeddZudvRCQjQ\\nthEkW2ts69xMeBVZ+yMpXtpE5xWnYFUPqbIAWCE0UabxmQo89QpJmGDPCdYDqKCN\\n0P/GAUBNAgMBAAECggEADNgwavLtfOG7RdR3+fevVZAYe3JaGtmSZi8pdtJLJV0y\\n733I++YtHpDWtHiDxkoOBlKutAFS6JhHZa188d8/jQQxkhgM9U9Vm6FoX/HBUm9u\\nIaVoWRq5RYOYghi7W+FjXi97sVR8PH78F2zqJ0f1GMPSI2FoLvKNJLAiizPwBUgr\\nzso6V5Xie3Nb9vqfT+PK5A2etj6xJrqK3LCfJg0rIQGqWhI3sdcscEvFMeIaAxEg\\nDteHbGlIiiDzkQz8fr6L9B47roVcsVIgL7+CZ37Y5BOJTdOLvinfHOv0EfMY/3e3\\nE27m298Tf4qvxC+vSODSXLvu1GZE35m7n5YTA3sycQKBgQDdg/KbImC1gzfdPtoo\\nsFQKSxKlC/6mWFugfAsBVBmHPnH4I7GKa6uZO5U7rAZL2XR+eamnOWOBd80CXHwj\\nWZ7XAZSJrHEKDS7TxOIZ3PYDMnOs/ncN6krPDh1/OCX6+pLml82qBFPZ1TD4G0/R\\nm389+svFP2dVlyUtwn9aDhgi8QKBgQDCa9hzxHu1RN7O8cIiOp8bSdygyFWJ6udY\\nNnpYiTn2G5hRXcjRA7N/AZiZcLeAMJYbMccHGmlb+gxY92Z6d23xl80jycDvm8bK\\nfus5UMV7UMreO7v1EkMFNoipoFJKcZ+GRr7XYTR3iMOHBurrRWby61AqoV65X5o+\\nBHgaXTP7HQKBgEXXT0uYWDOCjr+EDJadmbGxH8zH7l8WJrV/xpyBnpbkmlxpLJX/\\nApiKj6/Duix6AF/MDjB6SKROWGXxMPaYUBtsFSAfLXjE1UnRnpQW9b3mT1Bw3qqV\\nf0avJZ+x3U+3Z0+q9x4uxR0+OXVQbycgRssM4uhq6DK1N/SoiSykmvmRAoGAD525\\n9RKDHTw66URh433x6a81GXT96eYETwGRMitTjIEK6v4tcxxo/nqSV0DGfHVqmSSW\\nZ+unKswa0cqNYKjXG+CliYpbBOPuQ7WODzx9oDoNEWya3ERrPa/zqixGb9RQi+iC\\ny6nzHObPTbkwhVU9v6VG+yWbBii3quORAg0ab8ECgYBYeSPES8O6ynTtoibJxLH+\\nKqGvWs7D60N7RuUbT2Qee9D4VfG1LhqIvkER1IyNUesv3ys+4cEYBbAFKotDgLf4\\nPJx8wBZ2PrSgDfud/etB/jktIzN3YeYvigc10YLtYexR/q2hqVOZH8LCpaFYMYQt\\nj8KmjCMv7tnliXDlFi1Hdw==\\n-----END PRIVATE KEY-----\\n\",\n"
                + "  \"client_email\": \"firebase-adminsdk-syhss@mastermind-ezefrd.iam.gserviceaccount.com\",\n"
                + "  \"client_id\": \"108382944460756660218\",\n"
                + "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n"
                + "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n"
                + "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n"
                + "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-syhss%40mastermind-ezefrd.iam.gserviceaccount.com\"\n"
                + "}\n");

        writer.close();
    }

    public Firestore getFirestore() {
        return firestore;
    }

}
