package com.seu.cose.dokyme;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zdksc on 2017/12/7.
 */
public class State {
    private static int sid = 0;

    private int id;
    private String tag;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof State)) {
            return false;
        } else {
            State another = (State) obj;
            if (id == another.id && tag.equals(another.tag)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public State() {
        id = sid++;
    }

    public State(String tag) {
        id = sid++;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
