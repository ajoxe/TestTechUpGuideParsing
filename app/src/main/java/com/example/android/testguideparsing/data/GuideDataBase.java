package com.example.android.testguideparsing.data;


import android.content.Context;
import android.util.Log;


import com.example.android.testguideparsing.guides.models.Guide;

import java.util.HashMap;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class GuideDataBase extends HashMap<String, Guide>{
    private GuideDataBase guideDataBase;
    private GuideData guideData;
    Context context;

    public GuideDataBase(){


    }

    public void  setContext(Context context){
        this.context = context;

    }

    public GuideDataBase initializeGuideDataBase(){

        guideDataBase = new GuideDataBase();
        Log.d("database guidelist sixe", String.valueOf(guideData.size()));

        for (Guide guide: guideData){
            guideDataBase.put(guide.getGuide(), guide);
        }
        return guideDataBase;
    }

    public GuideDataBase getGuideDataBase() {
        guideData = setGuideData();
        guideDataBase = initializeGuideDataBase();
        Log.d("getdatabase method", String.valueOf(guideData.size()));

        return guideDataBase;
    }

    public GuideData setGuideData(){
        guideData = new GuideData();
        guideData.setContext(context.getApplicationContext());
        guideData = guideData.setGuideList();
        Log.d("database guide data", String.valueOf(guideData.size()));
        return guideData;
    }



    public void initializeGuideData(GuideData guideData){
        this.guideData.setGuideData(guideData);
    }

    public GuideData getGuideData(){
        return this.guideData;
    }
}
