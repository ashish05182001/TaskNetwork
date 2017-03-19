package sddtu.org.tasknetwork;

/**
 * Created by Dell on 3/17/2017.
 */

public class Provider {
    private String mName;
    private String mDescription;

    Provider(String name, String description) {
        mName = name;
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public String getDescription(){
        return mDescription;
    }
}
