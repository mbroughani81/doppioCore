package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.sociallist.model.FollowRequest;

import java.io.*;
import java.util.LinkedList;

public class FollowRequestDB implements DBSet<FollowRequest> {

    GsonBuilder builder;

    public FollowRequestDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public FollowRequest get(int id) {
        for (FollowRequest followRequest : all()) {
            if (followRequest.getId() == id)
                return followRequest;
        }
        return null;
    }

    @Override
    public LinkedList<FollowRequest> all() {
        LinkedList<FollowRequest> followRequests = new LinkedList<>();
        File file = new File("src/main/resources/followrequests/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/followrequests/" + s));
                followRequests.add(gson.fromJson(reader, FollowRequest.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return followRequests;
    }

    @Override
    public int add(FollowRequest followRequest) {
        int id;
        if (followRequest.getId() != -1)
            id = followRequest.getId();
        else
            id = nextId();
        followRequest.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(followRequest);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/followrequests/" + id + ".txt");
            fileWriter.write(json);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void remove(int id) {
        File f = new File("src/main/resources/followrequests/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/followrequests/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/followrequests/" + s);
            f.delete();
        }
    }

    @Override
    public void update(FollowRequest followRequest) {
        remove(followRequest.getId());
        add(followRequest);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (FollowRequest followRequest : all()) {
                if (followRequest.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
