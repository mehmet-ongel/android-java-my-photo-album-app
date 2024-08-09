package com.techmania.myphotoalbum;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyImagesRepository {

    private MyImagesDao myImagesDao;
    private LiveData<List<MyImages>> imagesList;

    //Executors
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public MyImagesRepository(Application application){

        MyImagesDatabase database = MyImagesDatabase.getInstance(application);
        myImagesDao = database.myImagesDao();
        imagesList = myImagesDao.getAllImages();

    }

    public void insert(MyImages myImages){

        //new InsertImageAsyncTask(myImagesDao).execute(myImages);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImagesDao.insert(myImages);
            }
        });

    }

    public void delete(MyImages myImages){

        //new DeleteImageAsyncTask(myImagesDao).execute(myImages);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImagesDao.delete(myImages);
            }
        });

    }

    public void update(MyImages myImages){

        //new UpdateImageAsyncTask(myImagesDao).execute(myImages);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImagesDao.update(myImages);
            }
        });

    }

    public LiveData<List<MyImages>> getAllImages(){

        return imagesList;

    }

    //first parameter --> doInBackground()
    //second parameter --> onProgressUpdate()
    //third parameter --> return type of doInBackground() method

    /*
    private static class InsertImageAsyncTask extends AsyncTask<MyImages,Void,Void>{

        MyImagesDao imagesDao;

        public InsertImageAsyncTask(MyImagesDao imagesDao) {
            this.imagesDao = imagesDao;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDao.insert(myImages[0]);

            return null;
        }
    }

    private static class UpdateImageAsyncTask extends AsyncTask<MyImages,Void,Void>{

        MyImagesDao imagesDao;

        public UpdateImageAsyncTask(MyImagesDao imagesDao) {
            this.imagesDao = imagesDao;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDao.update(myImages[0]);

            return null;
        }
    }

    private static class DeleteImageAsyncTask extends AsyncTask<MyImages,Void,Void>{

        MyImagesDao imagesDao;

        public DeleteImageAsyncTask(MyImagesDao imagesDao) {
            this.imagesDao = imagesDao;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDao.delete(myImages[0]);

            return null;
        }
    }

     */


}













