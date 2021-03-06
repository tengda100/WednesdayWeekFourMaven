package com.projectfive.ui;

import android.os.Bundle;
import android.view.ViewGroup;

import com.projectfive.R;
import com.projectfive.VelcroApp;
import com.projectfive.ui.misc.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject AppContainer appContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    VelcroApp app = VelcroApp.get(this);
    ViewGroup container = appContainer.get(this, app);

    getLayoutInflater().inflate(R.layout.activity_main, container);
  }
}
