package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.authentication.model.Profile;

import java.io.*;
import java.util.LinkedList;

public class ProfileDB implements DBSet<Profile> {

    GsonBuilder builder;

    public ProfileDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
    }

    @Override
    public Profile get(int id) {
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
    public void add(Profile profile) {
        int id = nextId();
        profile.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(profile);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/profiles/" + id + ".txt");
            fileWriter.write(json);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Profile profile) {

    }

    @Override
    public void update(Profile profile) {

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
