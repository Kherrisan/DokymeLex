package com.seu.cose.dokyme;

<<<<<<< HEAD
=======
import java.util.LinkedList;
import java.util.List;
>>>>>>> 940d6fa162c4415073f2533050e940dc2271d44b

/**
 * Created by zdksc on 2017/12/7.
 */
public class State {
<<<<<<< HEAD

    public static void resetId() {
        sid = 0;
    }

=======
>>>>>>> 940d6fa162c4415073f2533050e940dc2271d44b
    private static int sid = 0;

    public int id;
    public String tag;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof State)) {
            return false;
        } else {
            State another = (State) obj;
            if (id == another.id) {
                return true;
            } else {
                return false;
            }
        }
    }

    public State() {
        id = sid++;
        this.tag = "" + id;
    }

    public State(String tag) {
        id = sid++;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + tag;
    }
}
