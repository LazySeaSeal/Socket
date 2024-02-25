package PARTIE3;

import java.io.Serializable;

public class CustomPerson implements Serializable {
    private int customAge;
    private String customName;
    private int customId;

    public CustomPerson(int age, String name, int id) {
        this.customAge = age;
        this.customName = name;
        this.customId = id;
    }

    public int getCustomAge() {
        return customAge;
    }

    public String getCustomName() {
        return customName;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int clientId) {
        this.customId = clientId;
    }
}
