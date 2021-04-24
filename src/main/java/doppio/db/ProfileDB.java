package doppio.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import doppio.apps.authentication.model.Profile;

import java.io.FileWriter;
import java.io.IOException;
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
        return null;
    }

    @Override
    public void add(Profile profile) {
        System.out.println("profile is added - add in profiledb");
        int id = nextId();
        profile.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(profile);
        try {
            FileWriter fileWriter = new FileWriter("./resources/profiles/" + id + ".txt");
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
