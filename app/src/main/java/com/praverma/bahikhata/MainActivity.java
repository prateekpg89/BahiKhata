package com.praverma.bahikhata;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private PopupMenu toolbar_menu;
    private int menu_id;
    private PopupMenu.OnMenuItemClickListener menuItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//disable default title

        //Prepare menu item on avatar
        final ImageView avatar = toolbar.findViewById(R.id.avatar);
        avatar.setImageResource(R.mipmap.ic_launcher);
        final PopupMenu toolbar_menu = new PopupMenu(this, avatar);
        setToolbar_menu(R.menu.menu_main);
        setMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return true;
            }
        });
        toolbar_menu.getMenuInflater().inflate(menu_id, toolbar_menu.getMenu());
        toolbar_menu.setOnMenuItemClickListener(menuItemClickListener);
   
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar_menu.show();
            }
        });
    }

    public void setToolbar_menu(int resid){
        menu_id = resid;
    }

    public PopupMenu getToolbar_menu() {
        return toolbar_menu;
    }

    public void setMenuItemClickListener(PopupMenu.OnMenuItemClickListener onMenuItemClickListener){
        menuItemClickListener = onMenuItemClickListener;
    }

    /*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}