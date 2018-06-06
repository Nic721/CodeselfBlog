package hcxy.com.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ToolbarActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar mToolbar1,mToolbar2,mToolbar3,mToolbar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        mToolbar1 = findViewById(R.id.tool_bar_1);
        mToolbar2 = findViewById(R.id.tool_bar_2);
        mToolbar3 = findViewById(R.id.tool_bar_3);
        mToolbar4 = findViewById(R.id.tool_bar_4);
        findViewById(R.id.btn_toolbar1).setOnClickListener(this);
        findViewById(R.id.btn_toolbar2).setOnClickListener(this);
        findViewById(R.id.btn_toolbar3).setOnClickListener(this);
        findViewById(R.id.btn_toolbar4).setOnClickListener(this);
        initToolbar1();
        initToolbar2();
        initToolbar3();
        initToolbar4();
    }

    private void initToolbar1() {
        // 设置NavigationIcon
        mToolbar1.setNavigationIcon(R.drawable.ic_book_list);
        // 设置Toolbar背景色
        mToolbar1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        // 设置Title
        mToolbar1.setTitle(R.string.toolbar_title);
        // 设置Toolbar title文字颜色
        mToolbar1.setTitleTextColor(getResources().getColor(R.color.white));
        // 设置Toolbar subTitle
        mToolbar1.setSubtitle(R.string.sub_title);
        // 设置Toolbar subTitle文字颜色
        mToolbar1.setSubtitleTextColor(getResources().getColor(R.color.white));
        // 设置logo
        mToolbar1.setLogo(R.mipmap.ic_launcher);
        // 设置NavigationIcon点击事件
        mToolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 设置Toolbar menu
        mToolbar1.inflateMenu(R.menu.setting_menu);
        // 设置溢出菜单的图标
        mToolbar1.setOverflowIcon(getResources().getDrawable(R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha));
        // 设置menu item 点击事件
        mToolbar1.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_setting:
                        // 点击设置
                        break;
                }
                return false;
            }
        });
    }

    private void initToolbar2() {
        mToolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 添加溢出菜单
        mToolbar2.inflateMenu(R.menu.setting_menu);
        // 添加菜单点击事件
        mToolbar2.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_setting:
                        // 点击设置菜单
                        break;
                }
                return false;
            }
        });
    }

    private void initToolbar3() {
        mToolbar3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar3.inflateMenu(R.menu.tool_bar_menu);
    }

    private void initToolbar4() {
        mToolbar4.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar4.inflateMenu(R.menu.menu_search);
        mToolbar4.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_search:
                        // do search
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        // 获取Toolbar上的编辑框
        EditText searchEdit = mToolbar4.findViewById(R.id.edit_search);
        // 获取内容
        String content = searchEdit.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_toolbar1:
                mToolbar1.setVisibility(View.VISIBLE);
                mToolbar2.setVisibility(View.GONE);
                mToolbar3.setVisibility(View.GONE);
                mToolbar4.setVisibility(View.GONE);
                break;
            case R.id.btn_toolbar2:
                mToolbar1.setVisibility(View.GONE);
                mToolbar2.setVisibility(View.VISIBLE);
                mToolbar3.setVisibility(View.GONE);
                mToolbar4.setVisibility(View.GONE);
                break;
            case R.id.btn_toolbar3:
                mToolbar1.setVisibility(View.GONE);
                mToolbar2.setVisibility(View.GONE);
                mToolbar3.setVisibility(View.VISIBLE);
                mToolbar4.setVisibility(View.GONE);
                break;
            case R.id.btn_toolbar4:
                mToolbar1.setVisibility(View.GONE);
                mToolbar2.setVisibility(View.GONE);
                mToolbar3.setVisibility(View.GONE);
                mToolbar4.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
