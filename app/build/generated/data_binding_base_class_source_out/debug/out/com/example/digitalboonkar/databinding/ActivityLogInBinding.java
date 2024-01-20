// Generated by view binder compiler. Do not edit!
package com.example.digitalboonkar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.digitalboonkar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLogInBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView createAccountTextview;

  @NonNull
  public final EditText emailEdittext;

  @NonNull
  public final ImageView emailLogoImageview;

  @NonNull
  public final ImageView facebookLogoImageview;

  @NonNull
  public final ImageView googleLogoImageview;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextView loginTextview;

  @NonNull
  public final EditText passwordEdittext;

  @NonNull
  public final ImageView passwordLogoImageview;

  @NonNull
  public final ImageView twitterLogoImageview;

  @NonNull
  public final ImageView userLogoImageview;

  @NonNull
  public final EditText usernameEdittext;

  private ActivityLogInBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView createAccountTextview, @NonNull EditText emailEdittext,
      @NonNull ImageView emailLogoImageview, @NonNull ImageView facebookLogoImageview,
      @NonNull ImageView googleLogoImageview, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3,
      @NonNull Button loginButton, @NonNull TextView loginTextview,
      @NonNull EditText passwordEdittext, @NonNull ImageView passwordLogoImageview,
      @NonNull ImageView twitterLogoImageview, @NonNull ImageView userLogoImageview,
      @NonNull EditText usernameEdittext) {
    this.rootView = rootView;
    this.createAccountTextview = createAccountTextview;
    this.emailEdittext = emailEdittext;
    this.emailLogoImageview = emailLogoImageview;
    this.facebookLogoImageview = facebookLogoImageview;
    this.googleLogoImageview = googleLogoImageview;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.loginButton = loginButton;
    this.loginTextview = loginTextview;
    this.passwordEdittext = passwordEdittext;
    this.passwordLogoImageview = passwordLogoImageview;
    this.twitterLogoImageview = twitterLogoImageview;
    this.userLogoImageview = userLogoImageview;
    this.usernameEdittext = usernameEdittext;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLogInBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLogInBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_log_in, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLogInBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.create_account_textview;
      TextView createAccountTextview = ViewBindings.findChildViewById(rootView, id);
      if (createAccountTextview == null) {
        break missingId;
      }

      id = R.id.email_edittext;
      EditText emailEdittext = ViewBindings.findChildViewById(rootView, id);
      if (emailEdittext == null) {
        break missingId;
      }

      id = R.id.email_logo_imageview;
      ImageView emailLogoImageview = ViewBindings.findChildViewById(rootView, id);
      if (emailLogoImageview == null) {
        break missingId;
      }

      id = R.id.facebook_logo_imageview;
      ImageView facebookLogoImageview = ViewBindings.findChildViewById(rootView, id);
      if (facebookLogoImageview == null) {
        break missingId;
      }

      id = R.id.google_logo_imageview;
      ImageView googleLogoImageview = ViewBindings.findChildViewById(rootView, id);
      if (googleLogoImageview == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.login_button;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.login_textview;
      TextView loginTextview = ViewBindings.findChildViewById(rootView, id);
      if (loginTextview == null) {
        break missingId;
      }

      id = R.id.password_edittext;
      EditText passwordEdittext = ViewBindings.findChildViewById(rootView, id);
      if (passwordEdittext == null) {
        break missingId;
      }

      id = R.id.password_logo_imageview;
      ImageView passwordLogoImageview = ViewBindings.findChildViewById(rootView, id);
      if (passwordLogoImageview == null) {
        break missingId;
      }

      id = R.id.twitter_logo_imageview;
      ImageView twitterLogoImageview = ViewBindings.findChildViewById(rootView, id);
      if (twitterLogoImageview == null) {
        break missingId;
      }

      id = R.id.user_logo_imageview;
      ImageView userLogoImageview = ViewBindings.findChildViewById(rootView, id);
      if (userLogoImageview == null) {
        break missingId;
      }

      id = R.id.username_edittext;
      EditText usernameEdittext = ViewBindings.findChildViewById(rootView, id);
      if (usernameEdittext == null) {
        break missingId;
      }

      return new ActivityLogInBinding((ConstraintLayout) rootView, createAccountTextview,
          emailEdittext, emailLogoImageview, facebookLogoImageview, googleLogoImageview,
          linearLayout, linearLayout2, linearLayout3, loginButton, loginTextview, passwordEdittext,
          passwordLogoImageview, twitterLogoImageview, userLogoImageview, usernameEdittext);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}