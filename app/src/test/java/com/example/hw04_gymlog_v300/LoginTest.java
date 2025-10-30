package com.example.hw04_gymlog_v300;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.hw04_gymlog_v300.database.GymLogDatabase;
import com.example.hw04_gymlog_v300.database.UserDAO;
import com.example.hw04_gymlog_v300.database.entities.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginTest {

    private GymLogDatabase db;
    private UserDAO userDao;

    @Before
    public void setUp() {
        Context ctx = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(ctx, GymLogDatabase.class)
                .allowMainThreadQueries()
                .build();
        userDao = db.userDAO();
    }

    @After
    public void tearDown() { db.close(); }

    /**
     * this took me a while because User(password, login) and me being totally logical made
     * login (user, password) thinking user was the same
     *
     */
    private boolean login(String username, String password) {
        boolean[] result = {false};

        LiveData<User> liveUser = userDao.getUserByUserName(username);
        liveUser.observeForever(new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null && password.equals(user.getPassword())) {
                    result[0] = true;
                }
                liveUser.removeObserver(this);
            }
        });


        return result[0];
    }

    @Test
    public void loginTrue() {
        userDao.insert(new User("password","testuser"));
        assertTrue(login("testuser", "password"));
    }

    @Test
    public void loginFalse() {
        userDao.insert(new User("password", "testuser"));
        assertFalse(login("testuser", "nope"));
    }

    @Test
    public void loginNoUser() {
        assertFalse(login("duck", "anything"));
    }
}