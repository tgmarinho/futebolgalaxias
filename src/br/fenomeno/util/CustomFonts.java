package br.fenomeno.util;

import android.content.Context;
import android.graphics.Typeface;


/**
 * 
 * vi android
 * 
 * Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Kokila.ttf"); 
   txtyour.setTypeface(type);
 * 
 * 
 * OU
 * 
 * 
 * Typeface tf = Typeface.createFromAsset(getAssets(),
        "fonts/DroidSansFallback.ttf");
TextView tv = (TextView) findViewById(R.id.CustomFontText);
tv.setTypeface(tf);
 * 
 * @author toliveira
 *
 */

public class CustomFonts {

	public static final int JD_LED =   0;
	public static final int FONT_NAME_2 =   1;
	public static final int FONT_NAME_3 =   2;

	private static final int NUM_OF_CUSTOM_FONTS = 3;

	private static boolean fontsLoaded = false;

	private static Typeface[] fonts = new Typeface[3];

	private static String[] fontPath = {
	    "fonts/jd_led3.ttf",
	    "fonts/FONT_NAME_2.ttf",
	    "fonts/FONT_NAME_3.ttf"
	};


	/**
	 * Returns a loaded custom font based on it's identifier. 
	 * 
	 * @param context - the current context
	 * @param fontIdentifier = the identifier of the requested font
	 * 
	 * @return Typeface object of the requested font.
	 */
	public static Typeface getTypeface(Context context, int fontIdentifier) {
	    if (!fontsLoaded) {
	        loadFonts(context);
	    }
	    return fonts[fontIdentifier];
	}


	private static void loadFonts(Context context) {
	    for (int i = 0; i < NUM_OF_CUSTOM_FONTS; i++) {
	        fonts[i] = Typeface.createFromAsset(context.getAssets(), fontPath[i]);
	    }
	    fontsLoaded = true;

	}
	}
	
