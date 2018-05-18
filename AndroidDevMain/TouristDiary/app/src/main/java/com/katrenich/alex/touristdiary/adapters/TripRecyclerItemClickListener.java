package com.katrenich.alex.touristdiary.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* Клас імплементує інтерфейс для прослуховування дотиків до елементів RecycleView
 * */
public class TripRecyclerItemClickListener implements RecyclerView.OnItemTouchListener{
    private ClickListener mListener;

    public static interface ClickListener{
        public void onItemClick(View view, int position);
        public void onLongItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public TripRecyclerItemClickListener(Context context, final RecyclerView recyclerView, ClickListener listener) {
        this.mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if(child !=null && mListener != null){
                    mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childVew = rv.findChildViewUnder(e.getX(), e.getY());
        if(childVew != null && mListener != null && mGestureDetector.onTouchEvent(e)){
            mListener.onItemClick(childVew, rv.getChildAdapterPosition(childVew));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        //NOPE
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        //TODO
    }
}
