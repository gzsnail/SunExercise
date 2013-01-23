package org.sunshine_library.exercise.app.application;

import android.app.Application;

import android.content.Context;
import org.sunshine_library.exercise.metadata.database.DBHandler;
import org.sunshine_library.exercise.metadata.database.MetadataDBHandlerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: linuo
 * Date: 1/9/13
 * Usage: Global environment
 */
public class ExerciseApplication  extends Application {
    private DBHandler metadataDBHandler;
    static  ExerciseApplication application;


    public synchronized DBHandler getMetadataDBHandler() {
        if (metadataDBHandler == null) {
            metadataDBHandler = MetadataDBHandlerFactory.newMetadataDBHandler(this);
        }
        return metadataDBHandler;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        closeHandler();
    }

    private void closeHandler() {
        if (metadataDBHandler != null) {
            metadataDBHandler.close();
        }
    }

    public static Application getApplication(){
        return application;
    }


}
