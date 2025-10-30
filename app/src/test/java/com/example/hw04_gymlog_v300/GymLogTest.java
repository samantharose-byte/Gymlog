package com.example.hw04_gymlog_v300;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.hw04_gymlog_v300.database.GymLogDAO;
import com.example.hw04_gymlog_v300.database.GymLogDatabase;
import com.example.hw04_gymlog_v300.database.UserDAO;
import com.example.hw04_gymlog_v300.database.entities.User;

import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GymLogTest{
    private UserDAO userDao;
    private GymLogDatabase db;

    private GymLogDAO gymlogDao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, GymLogDatabase.class)
                .allowMainThreadQueries()
                .build();
        userDao = db.userDAO();
        gymlogDao = db.gymLogDAO();
    }

    @After
    public void closeDb(){
        db.close();
    }



    @Test
    public void writeUserAndReadInList() throws Exception {
        String username = "testuser";
        String password = "password";
        int uid = 42;
        User user = new User(username, password);
        user.setId(uid);

        userDao.insert(user);

        LiveData<User> liveUser = userDao.getUserByUserName(username);

        liveUser.observeForever(new Observer<User>() {
            @Override
            public void onChanged(User value) {
                if (value != null) {
                    assertEquals(username, value.getUsername());
                    assertEquals(password, value.getPassword());
                    assertTrue(value.getId() > 0);
                    liveUser.removeObserver(this);
                }
            }
        });
    }
}