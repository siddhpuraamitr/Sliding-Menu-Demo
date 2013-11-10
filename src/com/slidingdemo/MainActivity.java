package com.slidingdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.slidingdemo.fragment.AboutUsFragment;
import com.slidingdemo.fragment.FavoriteFragment;
import com.slidingdemo.fragment.HistoryFragment;
import com.slidingdemo.fragment.SearchFragment;
import com.slidingdemo.fragment.SettingsFragment;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private LinearLayout llMainSearch, llMainSettings, llMainFavorite,
			llMainAboutUs, llMainHistory, llMainSlider;
	private TextView tvMainSearch, tvMainSettings, tvMainFavorite,
			tvMainAboutUs, tvMainHistory;
	private ImageView ivMainSearch, ivMainSettings, ivMainFavorite,
			ivMainAboutUs, ivMainHistory, ivMainMenu;
	private RelativeLayout rlMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getWidgetReferences();

		bindEventHandlers();

		setSwipeListener();

		onSearchClicked();

	}

	private void setSwipeListener() {
		llMainSlider.setOnTouchListener(new OnSwipeTouchListener() {
			@Override
			public void onSwipeTop() {
			}

			@Override
			public void onSwipeRight() {
			}

			@Override
			public void onSwipeLeft() {
				TranslateAnimation anim = new TranslateAnimation(
						0f, -200f, 0f, 0f);
				anim.setDuration(500);
				llMainSlider.setAnimation(anim);
				llMainSlider.setVisibility(View.GONE);
			}

			@Override
			public void onSwipeBottom() {
			}
		});

		rlMain.setOnTouchListener(new OnSwipeTouchListener() {
			@Override
			public void onSwipeTop() {
			}

			@Override
			public void onSwipeRight() {

			}

			@Override
			public void onSwipeLeft() {
				hideSlider();
			}

			@Override
			public void onSwipeBottom() {
			}
		});
	}

	private void bindEventHandlers() {
		llMainAboutUs.setOnClickListener(this);
		llMainSearch.setOnClickListener(this);
		llMainFavorite.setOnClickListener(this);
		llMainSettings.setOnClickListener(this);
		llMainHistory.setOnClickListener(this);
		ivMainMenu.setOnClickListener(this);
	}

	private void getWidgetReferences() {

		rlMain = (RelativeLayout) findViewById(R.id.rlMain);

		llMainAboutUs = (LinearLayout) findViewById(R.id.llMainAboutUs);
		llMainSearch = (LinearLayout) findViewById(R.id.llMainSearch);
		llMainFavorite = (LinearLayout) findViewById(R.id.llMainFavorite);
		llMainSettings = (LinearLayout) findViewById(R.id.llMainSettings);
		llMainHistory = (LinearLayout) findViewById(R.id.llMainHistory);
		llMainSlider = (LinearLayout) findViewById(R.id.llMainSlider);

		ivMainAboutUs = (ImageView) findViewById(R.id.ivMainAboutUs);
		ivMainFavorite = (ImageView) findViewById(R.id.ivMainFavorite);
		ivMainHistory = (ImageView) findViewById(R.id.ivMainHistory);
		ivMainSearch = (ImageView) findViewById(R.id.ivMainSearch);
		ivMainSettings = (ImageView) findViewById(R.id.ivMainSettings);
		ivMainMenu = (ImageView) findViewById(R.id.ivMainMenu);

		tvMainAboutUs = (TextView) findViewById(R.id.tvMainAboutUs);
		tvMainFavorite = (TextView) findViewById(R.id.tvMainFavorite);
		tvMainHistory = (TextView) findViewById(R.id.tvMainHistory);
		tvMainSearch = (TextView) findViewById(R.id.tvMainSearch);
		tvMainSettings = (TextView) findViewById(R.id.tvMainSettings);
	}

	@Override
	public void onClick(View v) {
		if (v == llMainAboutUs) {
			onAboutUsClicked();
		} else if (v == llMainSearch) {
			onSearchClicked();
		} else if (v == llMainFavorite) {
			onFavoriteClicked();
		} else if (v == llMainSettings) {
			onSettingClicked();
		} else if (v == llMainHistory) {
			onHistoryClicked();
		} else if (v == ivMainMenu) {
			if (llMainSlider.getVisibility() == View.GONE) {
				showSlider();
			} else {
				hideSlider();
			}
		}
	}

	private void onHistoryClicked() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		HistoryFragment aboutUsFragment = new HistoryFragment();
		fragmentTransaction.replace(R.id.flMain, aboutUsFragment);
		fragmentTransaction.commit();
		deselectAllSliderItem();
		tvMainHistory.setTextColor(getResources().getColor(
				R.color.dark_text_color));
		llMainHistory.setBackgroundColor(getResources().getColor(
				R.color.selected_slider_item_color));
	}

	private void onSettingClicked() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		SettingsFragment aboutUsFragment = new SettingsFragment();
		fragmentTransaction.replace(R.id.flMain, aboutUsFragment);
		fragmentTransaction.commit();
		deselectAllSliderItem();
		tvMainSettings.setTextColor(getResources().getColor(
				R.color.dark_text_color));
		llMainSettings.setBackgroundColor(getResources().getColor(
				R.color.selected_slider_item_color));
	}

	private void onFavoriteClicked() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		FavoriteFragment aboutUsFragment = new FavoriteFragment();
		fragmentTransaction.replace(R.id.flMain, aboutUsFragment);
		fragmentTransaction.commit();
		deselectAllSliderItem();
		tvMainFavorite.setTextColor(getResources().getColor(
				R.color.dark_text_color));
		llMainFavorite.setBackgroundColor(getResources().getColor(
				R.color.selected_slider_item_color));
	}

	private void onSearchClicked() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		SearchFragment aboutUsFragment = new SearchFragment();
		fragmentTransaction.replace(R.id.flMain, aboutUsFragment);
		fragmentTransaction.commit();
		deselectAllSliderItem();
		tvMainSearch.setTextColor(getResources().getColor(
				R.color.dark_text_color));
		llMainSearch.setBackgroundColor(getResources().getColor(
				R.color.selected_slider_item_color));
	}

	private void onAboutUsClicked() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		AboutUsFragment aboutUsFragment = new AboutUsFragment();
		fragmentTransaction.replace(R.id.flMain, aboutUsFragment);
		fragmentTransaction.commit();
		deselectAllSliderItem();
		tvMainAboutUs.setTextColor(getResources().getColor(
				R.color.dark_text_color));
		llMainAboutUs.setBackgroundColor(getResources().getColor(
				R.color.selected_slider_item_color));
	}

	private void deselectAllSliderItem() {
		hideSlider();
		tvMainAboutUs.setTextColor(getResources().getColor(
				R.color.light_text_color));
		llMainAboutUs.setBackgroundColor(getResources().getColor(
				R.color.sliding_menu));

		tvMainSearch.setTextColor(getResources().getColor(
				R.color.light_text_color));
		llMainSearch.setBackgroundColor(getResources().getColor(
				R.color.sliding_menu));

		tvMainFavorite.setTextColor(getResources().getColor(
				R.color.light_text_color));
		llMainFavorite.setBackgroundColor(getResources().getColor(
				R.color.sliding_menu));

		tvMainSettings.setTextColor(getResources().getColor(
				R.color.light_text_color));
		llMainSettings.setBackgroundColor(getResources().getColor(
				R.color.sliding_menu));

		tvMainHistory.setTextColor(getResources().getColor(
				R.color.light_text_color));
		llMainHistory.setBackgroundColor(getResources().getColor(
				R.color.sliding_menu));

	}

	private void showSlider() {
		TranslateAnimation anim = new TranslateAnimation(-200f, 0f, 0f,
				0f);
		anim.setDuration(500);
		llMainSlider.setAnimation(anim);
		llMainSlider.setVisibility(View.VISIBLE);
	}

	private void hideSlider() {
		TranslateAnimation anim = new TranslateAnimation(0f, -200f, 0f,
				0f);
		anim.setDuration(500);
		llMainSlider.setAnimation(anim);
		llMainSlider.setVisibility(View.GONE);
	}
}
