package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowingList;

import java.io.*;
import java.util.LinkedList;

public class FollowingListDB implements DBSet<FollowingList> {

    GsonBuilder builder;

    public FollowingListDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public FollowingList get(int id) {
        for (FollowingList followingList : all()) {
            if (followingList.getId() == id)
                return followingList;
        }
        return null;
    }

    @Override
    public LinkedList<FollowingList> all() {
        LinkedList<FollowingList> followingLists = new LinkedList<>();
        File file = new File("src/main/resources/followinglists/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/followinglists/" + s));
                followingLists.add(gson.fromJson(reader, FollowingList.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return followingLists;
    }

    @Override
    public int add(FollowingList followingList) {
        int id = nextId();
        followingList.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(followingList);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/followinglists/" + id + ".txt");
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
        File f = new File("src/main/resources/followinglists/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/followinglists/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/followinglists/" + s);
            f.delete();
        }
    }

    @Override
    public void update(FollowingList followingList) {
        remove(followingList.getId());
        add(followingList);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (FollowingList followingList : all()) {
                if (followingList.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }

}
