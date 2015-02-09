package com.lucareto.love;

import android.app.Application;

import com.lucareto.love.ui.MainActivity;
import com.lucareto.love.utils.ParseConstants;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

public class LoveApplication extends Application {
	
	@Override
	public void onCreate() { 
		super.onCreate();
	    Parse.initialize(this, 
	    	"SJayMH4VR2znnbmNZpu1pdT47WO53AqcGo13Q65E", 
	    	"6kVW1YWEj2i6gNEEByZ9aqEgYv4vIU45gcGUaFDF");
	    
	   //PushService.setDefaultPushCallback(this, MainActivity.class);
	    PushService.setDefaultPushCallback(this, MainActivity.class, 
	    		R.drawable.ic_stat_ic_launcher);
	    ParseInstallation.getCurrentInstallation().saveInBackground();
	}
	
	public static void updateParseInstallation(ParseUser user) {
		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
		installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
		installation.saveInBackground();
	}
}
