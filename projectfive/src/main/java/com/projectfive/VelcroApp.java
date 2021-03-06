package com.projectfive;

import android.app.Application;
import android.content.Context;

import com.projectfive.ui.ActivityHierarchyServer;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import timber.log.Timber;

public class VelcroApp extends Application {

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject VelcroInitializer initializer;

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    buildObjectGraphAndInject();
    registerActivityLifecycleCallbacks(activityHierarchyServer);
    initializer.init();
  }

  @DebugLog
  public void buildObjectGraphAndInject() {
    objectGraph = ObjectGraph.create(Modules.list(this));
    objectGraph.inject(this);
  }

  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }

  public void inject(Object o) {
    objectGraph.inject(o);
  }

  public static VelcroApp get(Context context) {
    return (VelcroApp) context.getApplicationContext();
  }

}
