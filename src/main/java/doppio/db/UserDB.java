package doppio.db;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import doppio.apps.authentication.model.User;

import java.io.FileWriter;
import java.io.IOException;
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
                if (f.getDeclaringClass().equals(Process.class) && !f.getName().equals("id")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public LinkedList<User> all() {
        return null;
    }

    @Override
    public void add(User user) {
        System.out.println("user is added - add in userdb");
        int id = nextId();
        user.setId(id);
        Gson gson = builder.create();
        String json = gson.toJson(user);
        try {
            FileWriter fileWriter = new FileWriter("./resources/users/" + id + ".txt");
            fileWriter.write(json);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {

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
