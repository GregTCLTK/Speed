package com.bbn.XZerkrypter.core;

/*
 * @Author Skidder / GregTCLTK
 */

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class Rethink {
    private RethinkDB r = RethinkDB.r;
    private Connection conn;

    public void connect() {
        try {
            conn = r.connection()
                    .hostname(SECRETS.IP)
                    .db("Speed")
                    .port(28015)
                    .user(SECRETS.username, SECRETS.password)
                    .connect();
            System.out.println("DB CONNECTED");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB CONNECTION FAILED");
        }
    }
}
