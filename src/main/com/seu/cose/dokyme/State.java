package com.seu.cose.dokyme;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zdksc on 2017/12/7.
 */
public class State {
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
