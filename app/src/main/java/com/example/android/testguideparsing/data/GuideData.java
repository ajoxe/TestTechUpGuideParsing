package com.example.android.testguideparsing.data;






import android.content.Context;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Guide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by amirahoxendine on 12/30/17.
 */

public class GuideData extends ArrayList<Guide>{
    private GuideData guideData;
    private Context context;

    public GuideData() {

    }
    public void setContext (Context context){
        this.context = context;
    }


    public GuideData setGuideList(){
        Type collectiontype = new TypeToken<Collection<Guide>>() {
        }.getType();
        Gson gs = new Gson();
        Collection<Guide> guides = null;
        InputStream is = context.getApplicationContext().getResources().openRawResource(R.raw.exampleguiderv);
        InputStreamReader isr = new InputStreamReader(is);
        guides = gs.fromJson(isr, collectiontype);
        guideData = new GuideData();
        guideData.addAll(guides);
        return guideData;
    }

    public void setGuideData(GuideData guideData){
        this.guideData = guideData;
    }

    public GuideData getGuideData(){
        return guideData;
    }




}
