package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.authentication.model.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.LinkedList;

public class ProfileDB implements DBSet<Profile> {
    static Logger logger = LogManager.getLogger(ProfileDB.class);

    GsonBuilder builder;

    public ProfileDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public Profile get(int id) {
        for (Profile profile : all()) {
            if (profile.getId() == id)
                return profile;
        }
        return null;
    }

    @Override
    public LinkedList<Profile> all() {
        LinkedList<Profile> profiles = new LinkedList<>();
        File file = new File("src/main/resources/profiles/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/profiles/" + s));
                profiles.add(gson.fromJson(reader, Profile.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return profiles;
    }

    @Override
    public int add(Profile profile) {
        int id;
        if (profile.getId() != -1)
            id = profile.getId();
        else
            id = nextId();
        profile.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(profile);

        logger.trace("add profile" + json);

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/profiles/" + id + ".txt");
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
        logger.trace("remove profile " + id);

        File f = new File("src/main/resources/profiles/" + id + ".txt");
        f.delete();
    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/profiles/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/profiles/" + s);
            f.delete();
        }
    }

    @Override
    public void update(Profile profile) {
        logger.trace("update profile " + profile.getId());

        remove(profile.getId());
        add(profile);
    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (Profile profile : all()) {
                if (profile.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
