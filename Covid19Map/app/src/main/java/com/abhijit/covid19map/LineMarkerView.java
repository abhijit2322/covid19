package com.abhijit.covid19map;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.Utils;

// import com.github.mikephil.charting.utils.MPPointF;
//import com.github.mikephil.charting.utils.MPPointF;


/**
 * Custom implementation of the MarkerView.
 *
 * @author Philipp Jahoda
 */
public class LineMarkerView extends MarkerView {

    private TextView tvContent;

    public LineMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = (TextView) findViewById(R.id.tvContent);
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        if (e instanceof CandleEntry) {

            CandleEntry ce = (CandleEntry) e;

            tvContent.setText("" + Utils.formatNumber(ce.getHigh(), 0, true));
        } else {

           // tvContent.setText("" + Utils.formatNumber(e.getX(), 0, true));//getVal
        }

        // super.refreshContent(e, highlight);
    }

     //   return new MPPointF(-(getWidth() / 2), -getHeight());
   @Override
    public int getXOffset(float xpos) {
        return 0;
    }
    @Override
    public int getYOffset(float xpos) {
        return 0;
    }


}

