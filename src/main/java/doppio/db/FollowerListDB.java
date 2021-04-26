package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowerList;
import doppio.apps.sociallist.model.FollowingList;

import java.io.*;
import java.util.LinkedList;

public class FollowerListDB implements DBSet<FollowerList> {

    GsonBuilder builder;

    public FollowerListDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public FollowerList get(int id) {
        for (FollowerList followerList : all()) {
            if (followerList.getId() == id)
                return followerList;
        }
        return null;
    }

    @Override
    public LinkedList<FollowerList> all() {
        LinkedList<FollowerList> followerLists = new LinkedList<>();
        File file = new File("src/main/resources/followerlists/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/followerlists/" + s));
                followerLists.add(gson.fromJson(reader, FollowerList.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return followerLists;
    }

    @Override
    public int add(FollowerList followerList) {
        int id;
        if (followerList.getId() != -1)
            id = followerList.getId();
        else
            id = nextId();
        followerList.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(followerList);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/followerlists/" + id + ".txt");
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
        File f = new File("src/main/resources/followerlists/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/followerlists/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/followerlists/" + s);
            f.delete();
        }
    }

    @Override
    public void update(FollowerList followerList) {
        remove(followerList.getId());
        add(followerList);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (FollowerList followerList : all()) {
                if (followerList.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
