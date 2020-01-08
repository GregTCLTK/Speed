package com.bbn.XZerkrypter.core;

/*
 * @Author Skidder / GregTCLTK
 */

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import org.json.JSONArray;

import java.util.NoSuchElementException;

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
            System.out.println(this.get("user", "id", "477141528981012511", "bot_premium"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB CONNECTION FAILED");
        }
    }

    private JSONArray getAsArray(String table, String where, String value) {
        try {
            String string = r.table(table).filter(row -> row.g(where.toLowerCase()).eq(value)).coerceTo("array").toJson().run(conn);
            return new JSONArray(string);
        } catch (NoSuchElementException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    private Object get(String table, String where, String value, String column) {
        JSONArray array = this.getAsArray(table, where, value);
        if (array.length() > 0)
            if (array.getJSONObject(0).has(column))
                return array.getJSONObject(0).get(column);
            else return null;
        else return null;
    }

    private void update(String table, String value, String what, String whatvalue) {
        try {
            r.table(table).get(value).update(r.hashMap(what, whatvalue)).run(conn);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private void insert(String table, Object object) {
        try {
            r.table(table).insert(object).run(conn);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private void remove(String table, String where, String value) {
        r.table(table).filter(row -> row.g(where.toLowerCase()).eq(value)).delete().run(conn);
    }

    public void setBotPremium(String id) {
        r.table("user").get(id).update(r.hashMap("bot_premium", true)).run(conn);
    }

    public boolean isBotPremium(String id) {
        return (Boolean) this.get("user", "id", id, "bot_premium");
    }

    public void insertUser(String id) {
        this.insert("user", r.hashMap("id", id)
                .with("bot_premium", false));
    }
}
