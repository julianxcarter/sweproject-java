package org.employable;

import java.util.ArrayList;
import java.util.List;

// import com.mongodb.ServerAddress;

import org.bson.Document;
// import java.util.Arrays;
// import com.mongodb.Block;
// import java.lang.Object;

// import com.mongodb.client.MongoCursor;
// import static com.mongodb.client.model.Filters.*;
// import com.mongodb.client.result.DeleteResult;
// import static com.mongodb.client.model.Updates.*;
// import com.mongodb.client.result.UpdateResult;
// import java.util.ArrayList;
// import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        mongo datab = new mongo();

        datab.addUser("Julian Carter", false, "notpassword", "julian.carter@email.com");
        List<Document> iterDoc = new ArrayList<Document>();
        iterDoc = datab.getUsers();

        for (Document x : iterDoc){
           System.out.println(x);
        }
    
}
}
