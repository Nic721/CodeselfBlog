package com.hcxy.dialogfragment;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener,View.OnClickListener{

    private Button confimDialog;
    private Button editDialog;
    private Button loginDialog;
    private Button showDialogInDifferentScreen;
    private Button showLoginDialogWithoutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewf();
    }

    private void initViewf() {
        confimDialog = findViewById(R.id.confimDialog);
        editDialog = findViewById(R.id.editDialog);
        loginDialog = findViewById(R.id.loginDialog);
        showDialogInDifferentScreen = findViewById(R.id.dialogInDifferentScreen);
        showLoginDialogWithoutFragment = findViewById(R.id.loginDialogWithoutFragment);
        confimDialog.setOnClickListener(this);
        editDialog.setOnClickListener(this);
        loginDialog.setOnClickListener(this);
        showDialogInDifferentScreen.setOnClickListener(this);
        showLoginDialogWithoutFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confimDialog:
                showConfimDialog();
                break;
            case R.id.editDialog:
                showEditDialog();
                break;
            case R.id.loginDialog:
                showLoginDialog();
                break;
            case R.id.dialogInDifferentScreen:
                showDialogInDifferentScreen();
                break;
            case R.id.loginDialogWithoutFragment:
                showLoginDialogWithoutFragment();
                break;
            default:
                break;
        }
    }

    public void showConfimDialog(){
        FireMissilesDialogFragment test1 = new FireMissilesDialogFragment();
        test1.show(getFragmentManager(),"");
    }

    public void showEditDialog(){
        EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
        editNameDialogFragment.show(getFragmentManager(),"EditNameDialog");
    }

    public void showLoginDialog(){
        LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
        loginDialogFragment.show(getFragmentManager(),"loginDialog");
    }

    public void showDialogInDifferentScreen(){
        FragmentManager fragmentManager = getFragmentManager();
        EditNameDialogFragment newFragment = new EditNameDialogFragment();

        boolean mIsLargeLayout = getResources().getBoolean(R.bool.large_layout);
        Log.e("TAG",mIsLargeLayout+"");
        if(mIsLargeLayout){
            // The device is using a large layout, so show the fragment as a dialog
            newFragment.show(fragmentManager,"dialog");
        }else{
            // The device is smaller, so show the fragment fullscreen
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            // For a little polish, specify a transition animation
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            // To make it fullscreen, use the 'content' root view as the container for the fragment, which is always the root view for the activity
            transaction.replace(R.id.id_ly,newFragment).commit();
        }
    }

    public void showLoginDialogWithoutFragment(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_login_dialog,null))
                .setPositiveButton("Sign in",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // sign in the user ...
                            }
                        })
                .setNegativeButton("Cancel",null)
                .show();

    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this,"账号："+username+", 密码："+password,Toast.LENGTH_SHORT).show();
    }
}
