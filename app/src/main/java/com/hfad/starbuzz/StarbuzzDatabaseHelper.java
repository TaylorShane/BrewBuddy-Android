package com.hfad.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    StarbuzzDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                       + "NAME TEXT, "
                       + "DESCRIPTION TEXT, "
                       + "IMAGE_RESOURCE_ID INTEGER);");

            insertDrink(db, "Pale Ale \n", "This American-style pale ale is clean, dry, and very hoppy. American hops are the driving force of this beer, featuring the unmistakable citrus (some say grapefruit) aroma of Cascade up front as well as its smooth bittering at the finish. Pale caramel malt counterpoints the hopping with a sweet grain aroma and gives this appetizing ale its medium body and deep gold color. \n"+
                "\n Grains: \n"+"7.5 lbs Rahr 2-row Pale\n" + "1 lbs. Belgian Cara 8\n" + "0.5 lbs. Briess Caramel 20\n" +
                    "\n Hops: \n"+"2 oz. Cascade (60 min)\n" + "1 oz. Cascade (1 min)\n" +
                    "\n Yeast: \n"+"Wyeast 1056 American Ale", R.drawable.srm10);

            insertDrink(db, "Chinook IPA \n", "This American IPA has a relatively modest gravity and an immodest hop character derived entirely from a single hop variety. Chinook hops have long been used by US brewers for bittering additions, but their intense aroma and flavor have caught on only recently. This recipe is a bit lower in gravity and lighter in body than our other IPA recipes, which enhances the perceived bitterness and reduces the aging requirements. It shows up in the glass with a reddish-gold color and a thick, resinous Chinook aroma that lingers after the glass is emptied.\n"+
                "\n Grains: \n"+"10 lbs Rahr 2-row Pale \n" + "0.75 lbs. Belgian Cara \n" + "0.25 lbs. Briess Caramel 120\n" +
                    "\n Hops: \n"+"0.75 oz. Chinook (60 min)\n" + "0.5 oz. Chinook (10 min)\n" + "0.5 oz. Chinook (1 min)\n" +
                    "\n Yeast: \n"+"Wyeast 1056 American Ale", R.drawable.srm15);

            insertDrink(db, "Kolsch \n", "This pale, light-bodied golden ale is traditionally given a long, cold aging period which makes it very smooth and clean. 'Spritzy' is a word often used to describe Kolsch - very refreshing, and a popular lawnmower beer for beer snobs! \n"+
                    "\n Grains: \n"+"9 lbs German Pilsner \n" +
                    "\n Hops: \n"+"1 oz. Tradition\n" + "1 oz. Hersbrucker (30 min) \n" +
                    "\n Yeast: \n"+"Wyeast #2565 Kolsch", R.drawable.srm6);

            insertDrink(db, "Dunkelweizen \n", "Its name means dark wheat, and that's just what it is. An amber-colored version of a German hefeweizen, Dunkelweizen has the same spicy yeast and creamy wheat character of its pale counterpart, but with as much rich maltiness as a dark Bavarian lager. This recipe produces an ale with a hazy mahogany color, medium-full body, and spicy, bready aromas and flavors. \n"+
                            "\n Grains: \n"+"5 lbs. Weyermann Dark Wheat malt \n"
                     + "3.5 lbs. German Pilsner malt\n" + "1 lbs. German Dark Munich malt\n" + "0.5 lbs. Weyermann Caramunich II\n" + "0.25 lbs. Briess Caramel 120\n" +
            "\n Hops: \n"+"1 oz German Tettnang (60 min)\n" +
                    "\n Yeast: \n"+"Wyeast 3068 Weihenstephan Wheat", R.drawable.srm22);
        }
        insertDrink(db, "Bourbon Barrel Porter \n", "Bourbon barrel aged beers have been a hugely popular style ever since their inception in the early '90s by American craft brewers. By starting with a strongerthan-average robust porter, then infusing it with Bourbon-soaked oak (we recommend Maker's Mark), the end result is quite possibly the best beer ever. You'll have to supply your own bourbon - save a little to sip on brew day to really capture the spirit. The intense aroma and flavor of toasted American oak and the sweet graininess of good bourbon meld with the bittersweet roastiness of porter to make for a very characterful beer. \n"+
                "\n Grains: \n"+"9.5 lbs. English Maris Otter\n"
                + "1 lbs. Weyermann Pale Wheat\n" + "1 lbs. English Chocolate Malt\n" +"0.5 lbs. English Black Malt\n" +"0.5 lbs. English Dark Crystal \n" +
                "\n Hops: \n"+"1 oz. Chinook (60 min)\n"
                + " 0.5 oz. US Goldings (15 min)\n" + "0.5 oz. US Goldings (5 min) \n" +
                "\n Yeast: \n"+"Wyeast 1728 Scottish Ale", R.drawable.srm34);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }
}
