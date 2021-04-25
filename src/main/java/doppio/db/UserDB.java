package doppio.db;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;

import java.io.*;
import java.util.LinkedList;

public class UserDB implements DBSet<User> {

    GsonBuilder builder;

    public UserDB() {
        builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        ExclusionStrategy strategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                if (f.getDeclaringClass().equals(Profile.class) && !f.getName().equals("id")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        builder.addSerializationExclusionStrategy(strategy);
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public LinkedList<User> all() {
        LinkedList<User> users = new LinkedList<>();
        File file = new File("src/main/resources/users/");
        Gson gson = builder.create();
        for (String s : file.list()) {
            try {
                JsonReader reader = new JsonReader(new FileReader("src/main/resources/users/" + s));
                users.add(gson.fromJson(reader, User.class));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public int add(User user) {
        int id = nextId();
        user.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(user);
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/users/" + id + ".txt");
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

    }

    @Override
    public void clear() {
        File file = new File("src/main/resources/users/");
        for (String s : file.list()) {
            File f = new File("src/main/resources/users/" + s);
            f.delete();
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public int nextId() {
        for (int i = 0; ; i++) {
            boolean isUsed = false;
            for (User user : all()) {
                if (user.getId() == i)
                    isUsed = true;
            }
            if (!isUsed)
                return i;
        }
    }
}
