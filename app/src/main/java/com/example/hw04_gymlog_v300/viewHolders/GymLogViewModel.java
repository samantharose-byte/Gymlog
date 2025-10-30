package com.example.hw04_gymlog_v300.viewHolders;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hw04_gymlog_v300.database.GymLogRepository;
import com.example.hw04_gymlog_v300.database.entities.GymLog;

import java.util.List;

public class GymLogViewModel extends AndroidViewModel {
    private final GymLogRepository repository;

    //private final LiveData<List<GymLog>> allLogsById;

    public GymLogViewModel (Application application){
        super(application);
        repository = GymLogRepository.getRepository(application);
       // allLogsById = repository.getAlllogsByUserIdLiveData(userId);
    }

    public LiveData<List<GymLog>> getAllLogsById(int user) {
        return repository.getAlllogsByUserIdLiveData(user);
    }

    public void insert(GymLog log){
        repository.insertGymLog(log);
    }
}
