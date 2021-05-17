package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.timeline.model.MutedUserList;
import doppio.apps.timeline.model.ReportedTweetList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.LinkedList;

public class MutedUserListDB implements DBSet<MutedUserList> {
    static Logger logger = LogManager.getLogger(MutedUserListDB.class);

    GsonBuilder builder;

    public MutedUserListDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public MutedUserList get(int id) {
        for (MutedUserList mutedUserList : all()) {
            if (mutedUserList.getId() == id)
                return mutedUserList;
        }
        return null;
    }

    @Override
    public LinkedList<MutedUserList> all() {
        LinkedList<MutedUserList> mutedUserLists = new LinkedList<>();
        File file = new File("src/main/resources/muteduserlists/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/muteduserlists/" + s));
                mutedUserLists.add(gson.fromJson(reader, MutedUserList.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mutedUserLists;
    }

    @Override
    public int add(MutedUserList mutedUserList) {
        int id;
        if (mutedUserList.getId() != -1)
            id = mutedUserList.getId();
        else
            id = nextId();
        mutedUserList.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(mutedUserList);

        logger.trace("add muteduserlist" + json);

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/muteduserlists/" + id + ".txt");
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
        logger.trace("remove muteduserlist" + id);

        File f = new File("src/main/resources/muteduserlists/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/muteduserlists/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/muteduserlists/" + s);
            f.delete();
        }
    }

    @Override
    public void update(MutedUserList mutedUserList) {
        logger.trace("update muteduserlist " + mutedUserList.getId());

        remove(mutedUserList.getId());
        add(mutedUserList);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (MutedUserList mutedUserList : all()) {
                if (mutedUserList.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
