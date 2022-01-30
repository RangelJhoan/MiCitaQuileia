package com.example.micitaquileia.utilities;

import android.widget.EditText;

public class Utilities {
    public static int boolToInt(boolean bool){
        if(bool){
            return 1;
        }
        return 0;
    }

    public static boolean isFielsdFilled(EditText[] fieldList){
        for(int i=0; i<fieldList.length;i++){
            if(fieldList[i].getText().toString().trim().equals("")){
                return false;
            }
        }
        return true;
    }

}
